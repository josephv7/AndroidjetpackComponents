package com.iamjosephvarghese.androidjetpackcomponents;


import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface WordDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);


    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    List<Word> getAlphabetizedWords();


}
