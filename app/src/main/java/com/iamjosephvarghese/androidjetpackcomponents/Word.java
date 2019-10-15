package com.iamjosephvarghese.androidjetpackcomponents;

import androidx.annotation.NonNull;

public class Word {

    private String mWord;

    public Word(@NonNull String mWord) {
        this.mWord = mWord;
    }


    public String getmWord() {
        return mWord;
    }
}
