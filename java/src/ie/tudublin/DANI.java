package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {
	ArrayList<Word> model;
	ArrayList<String> sonnect;
	StringBuilder sb;

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

	public void setup() {
		colorMode(HSB);
		model = new ArrayList<Word>();
		loadFile();
		printModel();
		writeSonnet();
		printSonnet();
       
	}

	public void keyPressed() {
		if (key == ' ') {
			writeSonnet();
		}
	}

}
