package ie.tudublin;

import java.util.ArrayList;

public class Word {
    String word;
    ArrayList<Follow> followArrayList;
 
    public Word(String word) {
        this.word = word;
        this.followArrayList = new ArrayList<Follow>();
    } // End Word constructor



    // Accessor Methods
    public String getWord() {
        return word;
    }

    public ArrayList<Follow> getWordArrayList() {
        return followArrayList;
    }


    
} // End class Word
