package com.example.phonemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Library extends AppCompatActivity {

    private ArrayList<String> phonemes;
    private String[] graphemes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Intent intent = getIntent();
        phonemes = intent.getStringArrayListExtra("phonemes");
        graphemes = intent.getStringArrayExtra("word");

        StringBuilder phonemicWord = new StringBuilder();
        TextView phonNoname = findViewById(R.id.phonemeDisplay);
        for (String str : phonemes) {
            phonemicWord.append(str);
        }
        phonNoname.setText(phonemicWord.toString());

        StringBuilder graphemicWord = new StringBuilder();
        TextView graphNoname = findViewById(R.id.graphemeDisplay);
        for (String str : graphemes) {
            graphemicWord.append(str);
        }
        graphNoname.setText(graphemicWord.toString());
    }

    /**
     * Returns the user to the phoneme constructor with a blank word setup
     * @param v the create button being clicked
     */
    public void clickCreateButton(View v){
        Intent intent = new Intent(this, PhonemeConstructor.class);
        startActivity(intent);
    }
}