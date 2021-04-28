package com.example.phonemo;

import android.app.Application;

import java.util.ArrayList;

public class Controller extends Application {

    ArrayList<GraphemeClass> graphemes = new ArrayList<GraphemeClass>();

    public ArrayList<GraphemeClass> getGraphemes(){
        return graphemes;
    }

    public GraphemeClass getGraphemesAtPlace(int place){
        return graphemes.get(place);
    }

    public void addGrapheme(GraphemeClass grapheme){
        graphemes.add(grapheme);
    }

    public String[] getMatchingGraphemes(String match){
        for (int i=0; i<graphemes.size(); i++){
            if(match.equalsIgnoreCase(graphemes.get(i).getSymbol())){
                return graphemes.get(i).getGraphemes();

            }
        }
        return null;
        //return new String[0];
    }

}
