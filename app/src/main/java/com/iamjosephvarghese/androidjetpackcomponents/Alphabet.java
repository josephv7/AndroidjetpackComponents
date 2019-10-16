package com.iamjosephvarghese.androidjetpackcomponents;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Entity(tableName = "alphabet_table")
public class Alphabet {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "alphabet")
    private String mAlphabet;

    public Alphabet(@NonNull String mAlphabet) {
        this.mAlphabet = mAlphabet;
    }

    public String getAlphabet() {
        return mAlphabet;
    }



    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE `alphabet_table` (`alphabet` TEXT NOT NULL, PRIMARY KEY(`alphabet`))");
        }
    };

}