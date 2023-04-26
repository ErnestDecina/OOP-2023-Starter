package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;

public class DANI extends PApplet {
	ArrayList<Word> wordArrayList = new ArrayList<Word>();
	ArrayList<String> stringArrayList;
	StringBuilder sonnetStringBuilder;
	String[] sonnetStringArray;

	int sonnetSize = 14;
	int textSize = 15;
	int gap = 20;

	public void settings() {
		size(1000, 1000);
	}

	public void setup() {
		colorMode(HSB);
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
		int findWordResult;
		boolean finalWordInString;
		Word newWord;
		String[] stringArray = loadStrings("shakespere.txt");

		for(int stringIndex = 0; stringIndex < stringArray.length; stringIndex++) {
			String[] wordsArray = split(stringArray[stringIndex], " ");
			for(int wordIndex = 0; wordIndex < wordsArray.length; wordIndex ++) {
				wordsArray[wordIndex] = wordsArray[wordIndex].replaceAll("[^a-zA-Z ]", "");
				wordsArray[wordIndex] = wordsArray[wordIndex].toLowerCase();

				if(wordIndex + 1 == wordsArray.length) finalWordInString = true;
				else finalWordInString = false;
				
				if(!finalWordInString) {
					wordsArray[wordIndex+1] = wordsArray[wordIndex + 1].replaceAll("[^a-zA-Z ]", "");
					wordsArray[wordIndex+1] = wordsArray[wordIndex + 1].toLowerCase();
				}

				findWordResult = searchWord(wordsArray[wordIndex]);
	
				if(searchWord(wordsArray[wordIndex]) == -1) {
					newWord = new Word(wordsArray[wordIndex]);
					wordArrayList.add(newWord);
				}
				else newWord = wordArrayList.get(findWordResult);
		
				if(!finalWordInString) {
					if(newWord.findFollow(wordsArray[wordIndex + 1]) == -1) newWord.addFollow(new Follow(wordsArray[wordIndex + 1], 1));
					else newWord.addFollowCount(newWord.getFollowArrayList().get(newWord.findFollow(wordsArray[wordIndex + 1])));
				}
			}
		}
	}

	public int searchWord(String word){
		for(int wordIndex = 0; wordIndex < wordArrayList.size(); wordIndex++)
			if(wordArrayList.get(wordIndex).getWord().equals(word)) return wordIndex;

		return -1;
	}

	public void showModel(){
		for(Word wordInArrayList : wordArrayList) 
			System.out.println(wordInArrayList.toString());
	}

	public void createSonnet(){
		String totalSonnetString;
		Follow randomFollowWord;
		sonnetStringArray = new String[sonnetSize];
		for (int currentSonnetString = 0; currentSonnetString < sonnetSize; currentSonnetString++) {
			int randomNumbeIndex = (int) random(0, wordArrayList.size());
			Word randomWordfromIndex = wordArrayList.get(randomNumbeIndex);
			sonnetStringBuilder = new StringBuilder();
			sonnetStringBuilder.append(randomWordfromIndex.getWord() + " ");

			for(int indexFollow = 0; indexFollow < sonnetSize / 2; indexFollow++) {
				int randomFollow;

				if(randomWordfromIndex.getFollowArrayList().size() == 0) break;
				else randomFollow = (int) random(0, randomWordfromIndex.getFollowArrayList().size());

				randomFollowWord = randomWordfromIndex.getFollowArrayList().get(randomFollow);
				sonnetStringBuilder.append(randomFollowWord.getWord() + " ");
				randomWordfromIndex = wordArrayList.get(searchWord(randomFollowWord.getWord()));
			}
			totalSonnetString = sonnetStringBuilder.toString();
			sonnetStringArray[currentSonnetString] = totalSonnetString;
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
		for(int stringSonnetIndex = 0; stringSonnetIndex <sonnetStringArray.length; stringSonnetIndex++)
			text(sonnetStringArray[stringSonnetIndex], (width / 2) - 400, gap + stringSonnetIndex * gap + 300);
		
		popMatrix();
		popStyle();
	}
} // End class DANI
