package com.iamjosephvarghese.androidjetpackcomponents;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;
    private LiveData<List<Alphabet>> mAllAlphabets;

    public WordViewModel (Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
        mAllAlphabets = mRepository.getAllAlphabets();
    }


    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public LiveData<List<Alphabet>> getAllAlphabets() {
        return mAllAlphabets;
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }

    public void insert(Alphabet alphabet){
        mRepository.insert(alphabet);
    }
}
