package com.example.phonemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PhonemeConstructor extends AppCompatActivity {

    private String symbol = "";
    private String word = "";

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
        word+=symbol;
        noname.setText(word);

    }





}