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
}