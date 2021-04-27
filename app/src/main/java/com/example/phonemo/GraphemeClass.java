package com.example.phonemo;

/**
 * This class stores the grapheme data
 */
public class GraphemeClass {

    String phonemeSymbol;
    String[] graphemeSymbols;

    public GraphemeClass(){
        phonemeSymbol="";
        graphemeSymbols = new String[11];
    }

    public GraphemeClass(String[] symbols){
        phonemeSymbol=symbols[0];

        graphemeSymbols = new String[11];

        for (int i = symbols.length-1; i>0; i--){
            graphemeSymbols[i-1]=symbols[i];
        }

    }

    public String[] getGraphemes() {
        return graphemeSymbols;
    }

    public String getSymbol() {
        return phonemeSymbol;
    }

}
