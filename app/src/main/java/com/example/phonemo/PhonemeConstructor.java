package com.example.phonemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

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
        //play sound of phoneme
    }

    public void phonemeDoubleOnClick(View v) {
        symbol = ((Button) v).getText().toString().substring(0, 2);
        //play sound of phoneme
    }

    public void phonemeTripleOnClick(View v) {
        symbol = ((Button) v).getText().toString().substring(0, 3);
        //play sound of phoneme
    }

    public void addButtonOnClick(View v) {
        wordList.add(index++, symbol); //Fun Fact: you can increment and use index at the same time
        constructWord();
    }

    public void leftArrowOnClick(View v) {
        if (index != 0)
            index--;
    }

    public void rightArrowOnClick(View v) {
        if (index < symbol.length())
            index++;
    }

    public void backspaceOnClick(View v) {
        if (wordList.size() > 0 || index>0) {
            wordList.remove(--index); //Will first decrement index THEN run the deleteCharAt function. At least, it should do that...
            constructWord();
        }
    }

    public void constructWord() {
        String phonemicWord = "";
        TextView noname = (TextView) findViewById(R.id.PhonemeDisplay);
        for (String str : wordList) {
            phonemicWord += str;
        }
        noname.setText(phonemicWord);
    }
}
