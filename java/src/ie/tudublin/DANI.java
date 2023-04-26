package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

    public String[] writeSonnet()
    {
        return null;
    }

	public void setup() {
		colorMode(HSB);

       
	}

	public void keyPressed() {

	}

	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);
        
	}


	// 
	public void loadFile() {
		String[] stringArray = this.loadStrings("small.txt");

		for(int stringIndex = 0; stringIndex < stringArray.length; stringIndex++) {
			String[] arrayWords = split(stringArray[stringIndex], ' '); // Split a string into an array of words
			
			for(int wordIndex = 0; wordIndex < arrayWords.length; wordIndex++) {
				arrayWords[wordIndex].replaceAll("[^\\w\\s]","");
				arrayWords[wordIndex].toLowerCase();
			} // End for
		} // End for



		
		w.replaceAll("[^\\w\\s]",""); // Remove punction characters
		s.toLowerCase() // Convert a string to lower case 
	} // End void loadFile

	public void findWord(String string) {

	} // End void findWord()
}
