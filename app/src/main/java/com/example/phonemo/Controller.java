package com.example.phonemo;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;

/**
 * A controller class for the app that manages the graphemes
 */
public class Controller extends Application {

    private ArrayList<GraphemeClass> graphemes = new ArrayList<GraphemeClass>();
    private ArrayList<Integer> mediaList = new ArrayList<Integer>();

    /**
     * Returns the grapheme list
     * @return an arraylist of graphemes
     */
    public ArrayList<GraphemeClass> getGraphemes() {
        return graphemes;
    }

    /**
     * Returns the graphemes at a certain place
     * @param place the location of the graphemes
     * @return the grapheme object
     */
    public GraphemeClass getGraphemesAtPlace(int place) {
        return graphemes.get(place);
    }

    /**
     * Adds a grapheme object to the array list
     * @param grapheme the grapheme object to be added
     */
    public void addGrapheme(GraphemeClass grapheme){
        graphemes.add(grapheme);
    }

    /**
     * Returns the matching set of graphemes to a given phoneme
     * @param match the phoneme symbol to be matched
     * @return a string array of matching graphemes to the phoneme
     */
    public String[] getMatchingGraphemes(String match) {
        for (int i = 0; i < graphemes.size(); i++) {
            if (match.equalsIgnoreCase(graphemes.get(i).getSymbol())) {
                return graphemes.get(i).getGraphemes();
            }
        }
        return null;
    }

    /**
     * Sets the media sound labels for the phoneme word to an array
     * @param array the media list from the phoneme constructor class
     */
    public void setMediaList(ArrayList<Integer> array){
        for(Integer i: array){
            mediaList.add(i);

            Log.wtf("Controller", "check: "+ i);
        }
        for (int i=0; i<mediaList.size(); i++){
            if (mediaList.get(i)==null){
                mediaList.remove(i);
                i--;
            }
        }
    }

    /**
     * Returns the list of media sound labels
     * @return an array list of the sound file names
     */
    public ArrayList<Integer> getMediaList(){
        return mediaList;
    }

    /**
     * Removes the sounds from the media list
     */
    public void clearMediaList() {
        for(int i=0; i<mediaList.size(); i++){
            mediaList.set(i, null);
        }

    }

}
