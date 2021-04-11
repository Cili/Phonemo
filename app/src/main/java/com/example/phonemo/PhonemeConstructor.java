package com.example.phonemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PhonemeConstructor extends AppCompatActivity {

    private String symbol = "";
    private StringBuilder word = new StringBuilder();
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phoneme_constructor);
    }

    public void phonemeSingleOnClick (View v){
       symbol = ((Button) v).getText().toString().substring(0,1);
       //play sound of phoneme
    }

    public void phonemeDoubleOnClick (View v){
        symbol = ((Button) v).getText().toString().substring(0,2);
        //play sound of phoneme
    }

    public void phonemeTripleOnClick (View v){
        symbol = ((Button) v).getText().toString().substring(0,3);
        //play sound of phoneme
    }

    public void addButtonOnClick (View v){
        TextView noname = (TextView)findViewById(R.id.PhonemeDisplay);
        index+=symbol.length();
        word.insert(index,symbol);

        noname.setText(word);
    }

    public void leftArrowOnClick(View v){
        if (index!=0)
        index--;
    }

    public void rightArrowOnClick(View v){
        if (index<symbol.length())
            index++;
    }

    public void backspaceOnClick(View v){
        word.deleteCharAt(index-1);
        //need to fix index
    }










}