package com.example.phonemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class GraphemeConstructor extends AppCompatActivity {

    private ArrayList<String> phonemeList;
    private String[] graphemes;
    private int index = 0;
    private boolean firstClick = true;
    private Button button01, button02, button03, button04,button05, button06, button07, button08, button09, button10, button11;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grapheme_constructor);

        Intent intent = getIntent();
        phonemeList = intent.getStringArrayListExtra("phonemeWord");

        Log.wtf("Constructissue", "check: "+phonemeList.get(0));

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

        displayGraphemes();

        graphemes = new String[phonemeList.size()];

        for (int i = 0; i<graphemes.length; i++){
            graphemes[i] = "_ ";
        }

    }

    /**
     * Displays the grapheme string that the user builds
     */
    public void displayGraphemes(){
        final Controller aController = (Controller) getApplicationContext();

        String[] matchingGraphemes = aController.getMatchingGraphemes(phonemeList.get(index));

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

    }

    /**
     * Moves the cursor to the left
     * @param v the left arrow button
     */
    public void leftArrowOnClick(View v) {
        if (index <= 0){
            Snackbar.make(findViewById(v.getId()), R.string.tooSmallIndexError,
                    Snackbar.LENGTH_SHORT)
                    .show();
        }
        else{
            index--;
        }

        b.setBackgroundColor(getResources().getColor(R.color.phonemared));
        displayGraphemes();

    }

    /**
     * Moves the cursor to the right
     * @param v the right arrow button
     */
    public void rightArrowOnClick(View v) {
        if (index == graphemes.length-1){
            Snackbar.make(findViewById(v.getId()), R.string.tooLargeIndexError,
                    Snackbar.LENGTH_SHORT)
                    .show();
        }
        else{
            index++;
        }

        b.setBackgroundColor(getResources().getColor(R.color.phonemared));
        displayGraphemes();

    }

    /**
     * Allows the user to select a grapheme that corresponds with the phoneme they chose at a specified index
     * @param v the grapheme button
     */
    public void onGraphemeClick(View v) {
        if(firstClick)
            firstClick = false;
        else
            b.setBackgroundColor(getResources().getColor(R.color.phonemared));

        b = findViewById(v.getId());
        b.setBackgroundColor(getResources().getColor(R.color.buttonhighlight));

        String chosenGrapheme = b.getText().toString();
        graphemes[index] = chosenGrapheme;
        TextView noname = findViewById(R.id.GraphemeDisplay);

        StringBuilder englishWord = new StringBuilder();
        for (String str : graphemes) {
            englishWord.append(str);
        }
        noname.setText(englishWord.toString());
    }

    /**
     * Starts the library activity, creating a new word with the grapheme string
     * @param v the done button
     */
    public void doneButtonOnClick(View v){
        /*Intent intent = new Intent(this, Library.class);
        intent.putExtra("word", graphemes);

        boolean empty = false;

        for (String s : graphemes){
            if (s.equalsIgnoreCase("_ ")){
                empty=true;
            }
            else {
                empty=false;
            }
        }

        if (empty) {
            Snackbar.make(findViewById(v.getId()), R.string.noGraphemeError,
                    Snackbar.LENGTH_SHORT)
                    .show();

        }
        else{
            startActivity(intent);
        }*/

        boolean empty = false;

        for (String s : graphemes){
            if (s.equalsIgnoreCase("_ ")){
                empty=true;
            }
            else {
                empty=false;
            }
        }

        if (empty) {
            Snackbar.make(findViewById(v.getId()), R.string.noGraphemeError,
                    Snackbar.LENGTH_SHORT)
                    .show();

        }

        else {
            Snackbar.make(findViewById(v.getId()), R.string.comeBackLater,
                    Snackbar.LENGTH_SHORT)
                    .show();
        }

    }
}