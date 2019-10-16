package com.iamjosephvarghese.androidjetpackcomponents;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface AlphabetDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Alphabet alphabet);


    @Query("DELETE FROM alphabet_table")
    void deleteAll();

    @Query("SELECT * from alphabet_table ORDER BY alphabet ASC")
    LiveData<List<Word>> orderAscending();


}
