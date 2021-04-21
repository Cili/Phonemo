package com.example.phonemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class GraphemeConstructor extends AppCompatActivity {

    ArrayList<String> phonemeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grapheme_constructor);

        Intent intent = getIntent();
        phonemeList = intent.getStringArrayListExtra("phonemeWord");

        StringBuilder phonemicWord = new StringBuilder();
        TextView noname = findViewById(R.id.PhonemeDisplay2);
        for (String str : phonemeList) {
            phonemicWord.append(str);
        }
        noname.setText(phonemicWord.toString());

    }

    /*private void displayPhonemes(){
        Intent intent = getIntent();
        phonemeList = intent.getStringArrayListExtra("phonemeWord");

        TextView noname = findViewById(R.id.PhonemeDisplay2);
        noname.setText((CharSequence) phonemeList.toString());
    }*/
}