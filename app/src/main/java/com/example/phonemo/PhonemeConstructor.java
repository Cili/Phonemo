package com.example.phonemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

import static java.lang.Integer.parseInt;

public class PhonemeConstructor extends AppCompatActivity {

    private String symbol = "";
    //private StringBuilder word = new StringBuilder();
    private LinkedList<String> wordList = new LinkedList<>();

    private int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phoneme_constructor);
    }

    public void phonemeSingleOnClick(View v) {
        symbol = ((Button) v).getText().toString().substring(0, 1);
        String phonemeId = (v.getResources().getResourceName(v.getId()));
        String phonemeNumber = phonemeId.substring(30);
        TextView noname = (TextView) findViewById(R.id.PhonemeDisplay);
        noname.setText(phonemeNumber);
        //Log.v("Phoneme", "number"+phonemeNumber);
        //play sound of phoneme
    }

    public void phonemeDoubleOnClick(View v) {
        symbol = ((Button) v).getText().toString().substring(0, 2);
        String phonemeId = (v.getResources().getResourceName(v.getId()));
        String phonemeNumber = phonemeId.substring(30);
        TextView noname = (TextView) findViewById(R.id.PhonemeDisplay);
        noname.setText(phonemeNumber);
        //play sound of phoneme
    }

    public void phonemeTripleOnClick(View v) {
        symbol = ((Button) v).getText().toString().substring(0, 3);
        String phonemeId = (v.getResources().getResourceName(v.getId()));
        String phonemeNumber = phonemeId.substring(30);
        TextView noname = (TextView) findViewById(R.id.PhonemeDisplay);
        noname.setText(phonemeNumber);
        //play sound of phoneme
    }

    /**
     * The last phoneme symbol that was selected will be added to the word list
     * @param v the add button
     */
    public void addButtonOnClick(View v) {
        wordList.add(index++, symbol); //Fun Fact: you can increment and use index at the same time
        constructWord();
    }

    /**
     * Moves the cursor to the left
     * @param v the left arrow button
     */
    public void leftArrowOnClick(View v) {
        if (index != 0)
            index--;
    }

    /**
     * Moves the cursor to the right
     * @param v the right arrow button
     */
    public void rightArrowOnClick(View v) {
        if (index < symbol.length())
            index++;
    }

    /**
     * Deletes the last character wherever the cursor is
     * @param v the backspace button
     */
    public void backspaceOnClick(View v) {
        if (wordList.size() > 0 && index>0) {
            wordList.remove(--index); //Will first decrement index THEN run the deleteCharAt function. At least, it should do that...
            constructWord();
        }
    }

    /**
     * Displays the word list in the text view box
     */
    public void constructWord() {
        String phonemicWord = "";
        TextView noname = (TextView) findViewById(R.id.PhonemeDisplay);
        for (String str : wordList) {
            phonemicWord += str;
        }
        noname.setText(phonemicWord);
    }

    /**
     * Starts the grapheme constructor activity
     * @param v the done button
     */
    public void doneButtonOnClick(View v){
        Intent intent = new Intent(this, GraphemeConstructor.class);
        intent.putExtra("phonemeWord",wordList);
        startActivity(intent);
    }

}
