package com.example.phonemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class GraphemeConstructor extends AppCompatActivity {

    private ArrayList<String> phonemeList;
    private String[] graphemes;
    private Button button01, button02, button03, button04,button05, button06, button07, button08, button09, button10, button11;

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

        button01 = findViewById(R.id.Grapheme01);
        button02 = findViewById(R.id.Grapheme02);
        button03 = findViewById(R.id.Grapheme03);
        button04 = findViewById(R.id.Grapheme04);
        button05 = findViewById(R.id.Grapheme05);
        button06 = findViewById(R.id.Grapheme06);
        button07 = findViewById(R.id.Grapheme07);
        button08 = findViewById(R.id.Grapheme08);
        button09 = findViewById(R.id.Grapheme09);
        button10 = findViewById(R.id.Grapheme10);
        button11 = findViewById(R.id.Grapheme11);

        final Controller aController = (Controller) getApplicationContext();

        graphemes = aController.getMatchingGraphemes(phonemeList.get(0));
        displayGraphemes(graphemes);

        //readPhonemeData();

    }

    /*private String[] getMatchingGraphemes(String symbol){
        for (int i=1; i<graphemes.size(); i++){
            Log.wtf("GraphemeConstructor", "check: "+symbol+", "+graphemes.get(i).getSymbol());
            if(symbol==graphemes.get(i).getSymbol()){
                return graphemes.get(i).getGraphemes();

            }
        }

        return null;
    }*/

    public void displayGraphemes(String[] matchingGraphemes){
        button01.setText(matchingGraphemes[0]);
        button02.setText(matchingGraphemes[1]);
        button03.setText(matchingGraphemes[2]);
        button04.setText(matchingGraphemes[3]);
        button05.setText(matchingGraphemes[4]);
        button06.setText(matchingGraphemes[5]);
        button07.setText(matchingGraphemes[6]);
        button08.setText(matchingGraphemes[7]);
        button09.setText(matchingGraphemes[8]);
        button10.setText(matchingGraphemes[9]);
        button11.setText(matchingGraphemes[10]);

        /*GraphemeClass g = graphemes.get(2);
        String[] matchingGraphemes = g.getGraphemes();
        button01.setText(g.getGraphemes()[0]);
        button02.setText(matchingGraphemes[1]);
        button03.setText(matchingGraphemes[2]);
        button04.setText(matchingGraphemes[3]);
        button05.setText(matchingGraphemes[4]);
        button06.setText(matchingGraphemes[5]);
        button07.setText(matchingGraphemes[6]);
        button08.setText(matchingGraphemes[7]);
        button09.setText(matchingGraphemes[8]);
        button10.setText(matchingGraphemes[9]);
        button11.setText(matchingGraphemes[10]);*/

    }
}