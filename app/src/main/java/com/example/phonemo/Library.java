package com.example.phonemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Library extends AppCompatActivity {

    private ArrayList<String> phonemes;
    private String[] graphemes;
    private ArrayList<Integer> mediaList;

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

        final Controller aController = (Controller) getApplicationContext();
        mediaList=aController.getMediaList();

        AudioManager audioManager = (AudioManager) getSystemService(this.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);
    }

    /**
     * Plays the sounds of all the chosen phonemes
     * @param v the speaker button
     */
    public void speakerOnClick(View v) throws InterruptedException {

        Log.d("Library", "In speakerOnClick() method, test value="+mediaList.get(0)+"test");

        for(int index = 0; index < mediaList.size(); index++ ) {
            MediaPlayer mp = MediaPlayer.create( this, mediaList.get(index));
            mp.start();
            delay(200000);  // Add a delay - decide what works best
            mp.stop();
        }
    }

    /**
     *  This is the delay(...) method that will clock a user defined millisecond delay - this can behave like a "pause" between sounds.
     *
     */
    public void delay(long n) {
        n *= 1000;
        long startDelay = System.nanoTime();
        long endDelay = 0;
        while (endDelay - startDelay < n)
            endDelay = System.nanoTime();
    }

    /**
     * Returns the user to the phoneme constructor with a blank word setup
     * @param v the create button being clicked
     */
    public void clickCreateButton(View v) {
        Intent intent = new Intent(this, PhonemeConstructor.class);
        startActivity(intent);
    }
}