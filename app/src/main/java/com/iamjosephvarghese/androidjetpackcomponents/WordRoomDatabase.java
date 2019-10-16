package com.iamjosephvarghese.androidjetpackcomponents;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import static com.iamjosephvarghese.androidjetpackcomponents.Alphabet.MIGRATION_1_2;

@Database(entities = {Word.class,Alphabet.class}, version = 2)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();
    public abstract AlphabetDao alphabetDao();


    private static volatile WordRoomDatabase INSTANCE;

    static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .addMigrations(MIGRATION_1_2)
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };


    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;
        private final AlphabetDao mAlphabetDao;

        PopulateDbAsync(WordRoomDatabase db) {
            mDao = db.wordDao();
            mAlphabetDao = db.alphabetDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Word word = new Word("Hello");
            mDao.insert(word);
            word = new Word("World");
            mDao.insert(word);


            mAlphabetDao.deleteAll();
            Alphabet alphabet = new Alphabet("A");
            mAlphabetDao.insert(alphabet);

            return null;
        }
    }

}


