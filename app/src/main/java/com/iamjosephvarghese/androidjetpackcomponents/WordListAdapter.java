package com.iamjosephvarghese.androidjetpackcomponents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        private final TextView alphabetItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
            alphabetItemView = itemView.findViewById(R.id.textView2);
        }
    }

    private final LayoutInflater mInflater;
    private List<Word> mWords; // Cached copy of words
    private List<Alphabet> mAlphabets;

    WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            holder.wordItemView.setText(current.getWord());
            Alphabet currentAlphabet = mAlphabets.get(position);
            holder.alphabetItemView.setText(currentAlphabet.getAlphabet());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }


//    TODO need to update this method
    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }


    void setmAlphabets(List<Alphabet> alphabets){
        mAlphabets = alphabets;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }

}
