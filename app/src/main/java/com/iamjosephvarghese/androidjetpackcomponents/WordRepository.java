package com.iamjosephvarghese.androidjetpackcomponents;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class WordRepository {

    private WordDao mWordDao;
    private AlphabetDao mAlphabetDao;
    private LiveData<List<Word>> mAllWords;
    private LiveData<List<Alphabet>> mAllAlphabets;


    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAlphabetDao = db.alphabetDao();
        mAllWords = mWordDao.getAlphabetizedWords();
        mAllAlphabets = mAlphabetDao.orderAscending();
    }


    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public LiveData<List<Alphabet>> getAllAlphabets() {
        return mAllAlphabets;
    }



    public void insert (Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }


    public void insert (Alphabet alphabet){
        new insertAsyncTaskAlphabet(mAlphabetDao).execute(alphabet);
    }


    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }


    private static class insertAsyncTaskAlphabet extends AsyncTask<Alphabet, Void, Void> {

        private AlphabetDao mAsyncTaskDao;

        insertAsyncTaskAlphabet(AlphabetDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Alphabet... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
