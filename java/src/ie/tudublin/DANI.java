package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;

public class DANI extends PApplet {
	ArrayList<Word> wordArrayList;
	ArrayList<String> stringArrayList;
	StringBuilder sonnetStringBuilder;
	int sonnetSize = 14;
	int textSize = 15;

	public void settings() {
		size(1000, 1000);
	}

    String[] sonnetStringArray;

	public void setup() {
		colorMode(HSB);
		wordArrayList = new ArrayList<Word>();
		loadFile();
		showModel();
		createSonnet();       
	}

	public void keyPressed() {
		if (key == ' ') {
			createSonnet();
		}
	}

	public void loadFile() {
		String[] stringArray = loadStrings("shakespere.txt");
		for(int stringIndex = 0; stringIndex < stringArray.length; stringIndex++) {
			String[] wordsArray = split(stringArray[stringIndex], " ");
			for(int wordIndex = 0; wordIndex < wordsArray.length; wordIndex ++) {
				wordsArray[wordIndex] = wordsArray[wordIndex].replaceAll("[^a-zA-Z ]", "");
				wordsArray[wordIndex] = wordsArray[wordIndex].toLowerCase();

				boolean finalWordInString;

				if(wordIndex+1 == wordsArray.length) finalWordInString = true;
				else finalWordInString = false;
				
				if(!finalWordInString) {
					wordsArray[wordIndex+1] = wordsArray[wordIndex+1].replaceAll("[^a-zA-Z ]", "");
					wordsArray[wordIndex+1] = wordsArray[wordIndex+1].toLowerCase();
				}

				int findWordResult = findWord(wordsArray[wordIndex]);
				Word newWord;
					
				if(findWordResult == -1) {
					newWord = new Word(wordsArray[wordIndex]);
					wordArrayList.add(newWord);
				}
				else newWord = wordArrayList.get(findWordResult);
			

				if(!finalWordInString) {
					if(newWord.findFollow(wordsArray[wordIndex+1]) == -1) newWord.addFollow(new Follow(wordsArray[wordIndex+1], 1));
					else newWord.addFollowCount(newWord.getFollowArrayList().get(newWord.findFollow(wordsArray[wordIndex+1])));
				}
			}
		}
	}

	public int findWord(String word){
		for(int wordIndex = 0; wordIndex < wordArrayList.size(); wordIndex ++) {
			if(wordArrayList.get(wordIndex).getWord().equals(word)) return wordIndex;
		}
		return -1;
	}

	public void showModel(){
		for(Word wordInArrayList : wordArrayList) {
			System.out.println(wordInArrayList.toString());
		}
	}

	public void createSonnet(){
		sonnetStringArray = new String[sonnetSize];
		for (int i = 0; i < sonnetSize; i++) {
			int randomNumbeIndex = (int) random(0, wordArrayList.size());
			Word randomWordfromIndex = wordArrayList.get(randomNumbeIndex);
			sonnetStringBuilder = new StringBuilder();
			sonnetStringBuilder.append(randomWordfromIndex.getWord() + " ");

			for(int indexFollow = 0; indexFollow < 7;indexFollow++) {
				int randomFollow;

				if(randomWordfromIndex.getFollowArrayList().size() == 0) {
					break;
				}

				else {
					randomFollow = (int) random(0, randomWordfromIndex.getFollowArrayList().size());
				}
				Follow randomFollowWord = randomWordfromIndex.getFollowArrayList().get(randomFollow);
				sonnetStringBuilder.append(randomFollowWord.getWord() + " ");
				randomWordfromIndex = wordArrayList.get(findWord(randomFollowWord.getWord()));

			}
			String s = sonnetStringBuilder.toString();
			sonnetStringArray[i] = s;
		}
	}

	public void draw() {
		background(0);
		renderSonnet();

	}

	public void renderSonnet() {
		pushMatrix();
		pushStyle();

		fill(255);
		textSize(textSize);
		int gap = 20;
		for(int stringSonnetIndex = 0; stringSonnetIndex <sonnetStringArray.length; stringSonnetIndex++)
		{
			text(sonnetStringArray[stringSonnetIndex], (width / 2) - 300, gap + stringSonnetIndex * gap + (300));
		}
		
		popMatrix();
		popStyle();
	}


}
