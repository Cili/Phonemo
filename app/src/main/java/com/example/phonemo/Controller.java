package com.example.phonemo;

import android.app.Application;

import java.util.ArrayList;

public class Controller extends Application {

    ArrayList<GraphemeClass> graphemes = new ArrayList<GraphemeClass>();

    public ArrayList<GraphemeClass> getGraphemes(){
        return graphemes;
    }

    public void addGrapheme(GraphemeClass question){
        graphemes.add(question);
    }

    public String[] getMatchingGraphemes(String match){
        for (int i=1; i<graphemes.size(); i++){
            if(match==graphemes.get(i).getSymbol()){
                return graphemes.get(i).getGraphemes();

            }
        }

        return null;
    }

}
