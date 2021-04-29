package com.example.phonemo;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
//import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PhonemeConstructor extends AppCompatActivity implements View.OnClickListener {

    private String symbol = "";
    private ArrayList<String> wordList = new ArrayList<>();
    private ArrayList<Integer> soundList = new ArrayList<>();
    private int empty = 0;
    private int index = 0;
    private Button b;
    //private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int sound01, sound02, sound03, sound04, sound05, sound06, sound07, sound08, sound09, sound10, sound11, sound12, sound13, sound14, sound15, sound16, sound17, sound18, sound19, sound20, sound21, sound22, sound23, sound24, sound25, sound26, sound27, sound28, sound29, sound30, sound31, sound32, sound33, sound34, sound35, sound36, sound37, sound38, sound39, sound40, sound41, sound42, sound43, sound44;
    private int currentSound;
    private final ScheduledExecutorService delay = Executors.newScheduledThreadPool(1);
    private boolean firstClick = true;

    /**
     * On start, the initial phoneme constructor page is built
     * @param savedInstanceState -
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phoneme_constructor);

        //trying to use sound player
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder().setMaxStreams(50).setAudioAttributes(audioAttributes).build();

        sound01 = soundPool.load(this, R.raw.phonemeaudio01,1);
        sound02 = soundPool.load(this, R.raw.phonemeaudio02,1);
        sound03 = soundPool.load(this, R.raw.phonemeaudio03,1);
        sound04 = soundPool.load(this, R.raw.phonemeaudio04,1);
        sound05 = soundPool.load(this, R.raw.phonemeaudio05,1);
        sound06 = soundPool.load(this, R.raw.phonemeaudio06,1);
        sound07 = soundPool.load(this, R.raw.phonemeaudio07,1);
        sound08 = soundPool.load(this, R.raw.phonemeaudio08,1);
        sound09 = soundPool.load(this, R.raw.phonemeaudio09,1);
        sound10 = soundPool.load(this, R.raw.phonemeaudio10,1);
        sound11 = soundPool.load(this, R.raw.phonemeaudio11,1);
        sound12 = soundPool.load(this, R.raw.phonemeaudio12,1);
        sound13 = soundPool.load(this, R.raw.phonemeaudio13,1);
        sound14 = soundPool.load(this, R.raw.phonemeaudio14,1);
        sound15 = soundPool.load(this, R.raw.phonemeaudio15,1);
        sound16 = soundPool.load(this, R.raw.phonemeaudio16,1);
        sound17 = soundPool.load(this, R.raw.phonemeaudio17,1);
        sound18 = soundPool.load(this, R.raw.phonemeaudio18,1);
        sound19 = soundPool.load(this, R.raw.phonemeaudio19,1);
        sound20 = soundPool.load(this, R.raw.phonemeaudio20,1);
        sound21 = soundPool.load(this, R.raw.phonemeaudio21,1);
        sound22 = soundPool.load(this, R.raw.phonemeaudio22,1);
        sound23 = soundPool.load(this, R.raw.phonemeaudio23,1);
        sound24 = soundPool.load(this, R.raw.phonemeaudio24,1);
        sound25 = soundPool.load(this, R.raw.phonemeaudio25,1);
        sound26 = soundPool.load(this, R.raw.phonemeaudio26,1);
        sound27 = soundPool.load(this, R.raw.phonemeaudio27,1);
        sound28 = soundPool.load(this, R.raw.phonemeaudio28,1);
        sound29 = soundPool.load(this, R.raw.phonemeaudio29,1);
        sound30 = soundPool.load(this, R.raw.phonemeaudio30,1);
        sound31 = soundPool.load(this, R.raw.phonemeaudio31,1);
        sound32 = soundPool.load(this, R.raw.phonemeaudio32,1);
        sound33 = soundPool.load(this, R.raw.phonemeaudio33,1);
        sound34 = soundPool.load(this, R.raw.phonemeaudio34,1);
        sound35 = soundPool.load(this, R.raw.phonemeaudio35,1);
        sound36 = soundPool.load(this, R.raw.phonemeaudio36,1);
        sound37 = soundPool.load(this, R.raw.phonemeaudio37,1);
        sound38 = soundPool.load(this, R.raw.phonemeaudio38,1);
        sound39 = soundPool.load(this, R.raw.phonemeaudio39,1);
        sound40 = soundPool.load(this, R.raw.phonemeaudio40,1);
        sound41 = soundPool.load(this, R.raw.phonemeaudio41,1);
        sound42 = soundPool.load(this, R.raw.phonemeaudio42,1);
        sound43 = soundPool.load(this, R.raw.phonemeaudio43,1);
        sound44 = soundPool.load(this, R.raw.phonemeaudio44,1);

        AudioManager audioManager = (AudioManager) getSystemService(this.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);
    }

    /**
     * When a phoneme button is clicked, the symbol is generated and the sound is played
     * @param v the phoneme button
     */
    @Override
    public void onClick(View v) {
        if(firstClick)
            firstClick = false;
        else
            b.setBackgroundColor(getResources().getColor(R.color.phonemared));
        b = findViewById(v.getId());
        symbol = b.getText().toString().substring(0, 3).trim();
        b.setBackgroundColor(getResources().getColor(R.color.buttonhighlight));
        /*String phonemeId = (v.getResources().getResourceName(v.getId()));
        String phonemeNumber = "sound"+phonemeId.substring(30);
        currentSound = Integer.parseInt(phonemeNumber);
        TextView tv = findViewById(R.id.PhonemeDisplay);
        tv.setText(phonemeNumber);*/

        switch (v.getId()) {
            case R.id.Phoneme01:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio01);
                soundPool.play(sound01, 1, 1, 0, 0, 1);
                currentSound = sound01;
                break;

            case R.id.Phoneme02:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio02);
                soundPool.play(sound02, 1, 1, 0, 0, 1);
                soundList.add(sound02);
                break;

            case R.id.Phoneme03:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio03);
                soundPool.play(sound03, 1, 1, 0, 0, 1);
                soundList.add(sound03);
                break;

            case R.id.Phoneme04:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio04);
                soundPool.play(sound04, 1, 1, 0, 0, 1);
                soundList.add(sound04);
                break;

            case R.id.Phoneme05:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio05);
                soundPool.play(sound05, 1, 1, 0, 0, 1);
                soundList.add(sound05);
                break;

            case R.id.Phoneme06:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio01);
                soundPool.play(sound06, 1, 1, 0, 0, 1);
                soundList.add(sound06);
                break;

            case R.id.Phoneme07:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio07);
                soundPool.play(sound07, 1, 1, 0, 0, 1);
                soundList.add(sound07);
                break;

            case R.id.Phoneme08:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio08);
                soundPool.play(sound08, 1, 1, 0, 0, 1);
                currentSound = sound08;
                break;

            case R.id.Phoneme09:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio09);
                soundPool.play(sound09, 1, 1, 0, 0, 1);
                currentSound = sound09;
                break;

            case R.id.Phoneme10:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio10);
                soundPool.play(sound10, 1, 1, 0, 0, 1);
                currentSound = sound10;
                break;

            case R.id.Phoneme11:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio11);
                soundPool.play(sound11, 1, 1, 0, 0, 1);
                currentSound = sound11;
                break;

            case R.id.Phoneme12:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio12);
                soundPool.play(sound12, 1, 1, 0, 0, 1);
                currentSound = sound12;
                break;

            case R.id.Phoneme13:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio13);
                soundPool.play(sound13, 1, 1, 0, 0, 1);
                currentSound = sound13;
                break;

            case R.id.Phoneme14:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio14);
                soundPool.play(sound14, 1, 1, 0, 0, 1);
                currentSound = sound14;
                break;

            case R.id.Phoneme15:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio15);
                soundPool.play(sound15, 1, 1, 0, 0, 1);
                currentSound = sound15;
                break;

            case R.id.Phoneme16:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio16);
                soundPool.play(sound16, 1, 1, 0, 0, 1);
                currentSound = sound16;
                break;

            case R.id.Phoneme17:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio17);
                soundPool.play(sound17, 1, 1, 0, 0, 1);
                currentSound = sound17;
                break;

            case R.id.Phoneme18:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio18);
                soundPool.play(sound18, 1, 1, 0, 0, 1);
                currentSound = sound18;
                break;

            case R.id.Phoneme19:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio19);
                soundPool.play(sound19, 1, 1, 0, 0, 1);
                currentSound = sound19;
                break;

            case R.id.Phoneme20:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio20);
                soundPool.play(sound20, 1, 1, 0, 0, 1);
                currentSound = sound20;
                break;

            case R.id.Phoneme21:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio21);
                soundPool.play(sound21, 1, 1, 0, 0, 1);
                currentSound = sound21;
                break;

            case R.id.Phoneme22:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio22);
                soundPool.play(sound22, 1, 1, 0, 0, 1);
                currentSound = sound22;
                break;

            case R.id.Phoneme23:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio23);
                soundPool.play(sound23, 1, 1, 0, 0, 1);
                currentSound = sound23;
                break;

            case R.id.Phoneme24:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio24);
                soundPool.play(sound24, 1, 1, 0, 0, 1);
                currentSound = sound24;
                break;

            case R.id.Phoneme25:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio25);
                soundPool.play(sound25, 1, 1, 0, 0, 1);
                currentSound = sound25;
                break;

            case R.id.Phoneme26:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio26);
                soundPool.play(sound26, 1, 1, 0, 0, 1);
                currentSound = sound26;
                break;

            case R.id.Phoneme27:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio27);
                soundPool.play(sound27, 1, 1, 0, 0, 1);
                currentSound = sound27;
                break;

            case R.id.Phoneme28:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio28);
                soundPool.play(sound28, 1, 1, 0, 0, 1);
                currentSound = sound28;
                break;

            case R.id.Phoneme29:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio29);
                soundPool.play(sound29, 1, 1, 0, 0, 1);
                currentSound = sound29;
                break;

            case R.id.Phoneme30:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio30);
                soundPool.play(sound30, 1, 1, 0, 0, 1);
                currentSound = sound30;
                break;

            case R.id.Phoneme31:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio31);
                soundPool.play(sound31, 1, 1, 0, 0, 1);
                currentSound = sound31;
                break;

            case R.id.Phoneme32:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio32);
                soundPool.play(sound32, 1, 1, 0, 0, 1);
                currentSound = sound32;
                break;

            case R.id.Phoneme33:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio33);
                soundPool.play(sound33, 1, 1, 0, 0, 1);
                currentSound = sound33;
                break;

            case R.id.Phoneme34:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio34);
                soundPool.play(sound34, 1, 1, 0, 0, 1);
                currentSound = sound34;
                break;

            case R.id.Phoneme35:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio35);
                soundPool.play(sound35, 1, 1, 0, 0, 1);
                currentSound = sound35;
                break;

            case R.id.Phoneme36:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio36);
                soundPool.play(sound36, 1, 1, 0, 0, 1);
                currentSound = sound36;
                break;

            case R.id.Phoneme37:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio37);
                soundPool.play(sound37, 1, 1, 0, 0, 1);
                currentSound = sound37;
                break;

            case R.id.Phoneme38:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio38);
                soundPool.play(sound38, 1, 1, 0, 0, 1);
                currentSound = sound38;
                break;

            case R.id.Phoneme39:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio39);
                soundPool.play(sound39, 1, 1, 0, 0, 1);
                currentSound = sound39;
                break;

            case R.id.Phoneme40:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio40);
                soundPool.play(sound40, 1, 1, 0, 0, 1);
                currentSound = sound40;
                break;

            case R.id.Phoneme41:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio41);
                soundPool.play(sound41, 1, 1, 0, 0, 1);
                currentSound = sound41;
                break;

            case R.id.Phoneme42:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio42);
                soundPool.play(sound42, 1, 1, 0, 0, 1);
                currentSound = sound42;
                break;

            case R.id.Phoneme43:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio43);
                soundPool.play(sound43, 1, 1, 0, 0, 1);
                currentSound = sound43;
                break;

            case R.id.Phoneme44:
                //mediaPlayer = MediaPlayer.create(this, R.raw.phonemeaudio44);
                soundPool.play(sound44, 1, 1, 0, 0, 1);
                currentSound = sound44;
                break;

            default:
                break;
        }

        //mediaPlayer.start();
    }

    /**
     * The last phoneme symbol that was selected will be added to the phonemic workspace
     * @param v the add button
     */
    public void addButtonOnClick(View v) {
        wordList.add(index++, symbol); //Fun Fact: you can increment and use index at the same time
        soundList.add(currentSound);
        constructWord();
        empty++;
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
        if (index <= symbol.length())
            index++;
    }

    /**
     * Deletes the previous character of wherever the cursor is
     * @param v the backspace button
     */
    public void backspaceOnClick(View v) {
        if (wordList.size() > 0 && index>0) {
            wordList.remove(--index); //Will first decrement index THEN run the deleteCharAt function. At least, it should do that...
            soundList.remove(index);
            constructWord();
            empty--;
        }
    }

    /**
     * Plays the sounds of all the chosen phonemes
     * @param v the speaker button
     */
    public void speakerOnClick(View v) throws InterruptedException {
        /*for(Integer m: soundList) {
            soundPool.notify();
            soundPool.play(m, 1, 1, 0, 0, 1);
            soundPool.wait(500);
            *//*delay.schedule(new Runnable() {
                @Override
                public void run() {
                    soundPool.
                }
            }, 1, TimeUnit.SECONDS);*//*

        }*/
    }

    /**
     * Displays the phonemic list in the text view box
     */
    public void constructWord() {
        StringBuilder phonemicWord = new StringBuilder();
        TextView noname = findViewById(R.id.PhonemeDisplay);
        for (String str : wordList) {
            phonemicWord.append(str);
        }
        noname.setText(phonemicWord.toString());
    }

    /**
     * Starts the grapheme constructor activity if the phonemic list/text view box is not empty
     * @param v the done button
     */
    public void doneButtonOnClick(View v){
        Intent intent = new Intent(this, GraphemeConstructor.class);
        intent.putExtra("phonemeWord", wordList);
        if (empty>0)
            startActivity(intent);
        else
            Snackbar.make(findViewById(R.id.DoneButton), R.string.noPhonemeError,
                    Snackbar.LENGTH_SHORT)
                    .show();
                //intent.putExtra("phonemeWord",wordList);
        //mediaPlayer.release();
    }
}
