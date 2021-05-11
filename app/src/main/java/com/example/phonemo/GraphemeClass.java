package com.example.phonemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class stores the grapheme data
 */
public class GraphemeClass {

    String phonemeSymbol;
    String[] graphemeSymbols;

    /**
     * Constructs an object of the grapheme class with a blank phoneme and grapheme array
     */
    public GraphemeClass() {
        phonemeSymbol = "";
        graphemeSymbols = new String[11];
    }

    /**
     * Constructs an object with a phoneme and grapheme string from a given array
     * @param symbols the given array containing a phoneme at index 0 and graphemes at indexes 1-11
     */
    public GraphemeClass(String[] symbols) {
        phonemeSymbol = symbols[0];
        graphemeSymbols = new String[11];

        for(int i = symbols.length-1; i>0; i--)
            graphemeSymbols[i-1]=symbols[i];
    }

    /**
     * Returns the grapheme string
     * @return
     */
    public String[] getGraphemes() {
        return graphemeSymbols;
    }

    /**
     * Returns the phoneme symbols
     * @return the phoneme symbol
     */
    public String getSymbol() {
        return phonemeSymbol;
    }
}
