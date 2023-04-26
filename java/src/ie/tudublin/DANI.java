package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {
	// Private Fields
	String[] stringArray;
	ArrayList<String[]> arrayWords;
	ArrayList<Word> wordArrayList;
	

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
		this.wordArrayList = new ArrayList<Word>();
		this.arrayWords = new ArrayList<String[]>();
		loadFile();
		loadWords();
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
		stringArray = this.loadStrings("small.txt");

		// Load Words into A array 
		for(int stringIndex = 0; stringIndex < stringArray.length; stringIndex++) {
			// arrayWords = split(stringArray[stringIndex], ' '); // Split a string into an array of words
			arrayWords.add(split(stringArray[stringIndex], ' '));

			for(int wordIndex = 0; wordIndex < arrayWords.get(stringIndex).length; wordIndex++) {
				arrayWords.get(stringIndex)[wordIndex].replaceAll("[^\\w\\s]","");
				arrayWords.get(stringIndex)[wordIndex] = arrayWords.get(stringIndex)[wordIndex].toLowerCase();
			} // End for
		} // End for


		// TODO: Testing words

		// Load Words into A array 

		/*
		for(int stringIndex = 0; stringIndex < stringArray.length; stringIndex++) {
		
			for(int wordIndex = 0; wordIndex < arrayWords.get(stringIndex).length; wordIndex++) {
				System.out.println(arrayWords.get(stringIndex)[wordIndex]);
			} // End for
		} // End for
		*/
	} // End void loadFile

	private void loadWords() {
		// Load Words into A array 
		for(int stringIndex = 0; stringIndex < stringArray.length; stringIndex++) {
			for(int wordIndex = 0; wordIndex < arrayWords.get(stringIndex).length; wordIndex++) {
				Word newWord = new Word(arrayWords.get(stringIndex)[wordIndex]);
				
				// Check if word already exists in the wordArrayList
				boolean wordExists = false;
				for (Word currentWord : wordArrayList) {
					if(currentWord.word.equals(newWord.word)) {
						wordExists = true;
						break;
					}
					else {
						wordExists = false;
					}
				} // End for

				if(!wordExists) {
					if(wordIndex != arrayWords.get(stringIndex).length - 1) {
						Follow newWordFollow = new Follow(arrayWords.get(stringIndex)[wordIndex + 1]);
						newWord.followArrayList.add(newWordFollow);
					} 

					wordArrayList.add(newWord);
				} // End if
				else {
					// Find index of word
					int wordPlace = 0;
					for(Word word : wordArrayList) {
						wordPlace++;

						if(word.word.equals(newWord.word)) {
							break;
						}
					}	

					ArrayList<Follow> followList = wordArrayList.get(wordPlace).followArrayList;
					

					if(wordIndex != arrayWords.get(stringIndex).length - 1) {
						boolean followExists = false;
						for(Follow follow : followList) {
							if(follow.word.equals(arrayWords.get(stringIndex)[wordIndex + 1])) {
								followExists = true;
								break;
							}
						} // End for

						if(!followExists) {
							Follow newWordFollow = new Follow(arrayWords.get(stringIndex)[wordIndex + 1]);
							newWord.followArrayList.add(newWordFollow);

						}
						else {

							// Find index of follow
							// Find index of word
							int followPlace = 0;
							for(Follow follow : followList) {
								followPlace++;

								if(follow.word.equals(newWord.word)) {
									break;
								}
							}	

							followList.get(followPlace).incrementCount();
						}
					} // End if












					/*
					for (Word currentWord : wordArrayList) {
						if(currentWord.word.equals(newWord.word)) {
							int wordArrayListIndex = -1;
							for(Word word : wordArrayList) {
								if(word.word.equals(newWord.word)) {
									break;
								}
								wordArrayListIndex++;
							}

							if(wordIndex != arrayWords.get(stringIndex).length - 1) {
								Follow newWordFollow = new Follow(arrayWords.get(stringIndex)[wordIndex + 1]);

								boolean followExists = false;
								for(Follow follow : wordArrayList.get(wordArrayListIndex).followArrayList) {
									if(follow.word.equals(newWordFollow.word)) {
										followExists = true;
										break;
									} // End if
								} // End foreach 

								if(!followExists) {
									wordArrayList.get(wordArrayListIndex).followArrayList.add(newWordFollow);
								} 
								else {
									for(Follow follow : wordArrayList.get(wordArrayListIndex).followArrayList) {
										if(follow.word.equals(newWordFollow.word)) {
											follow.incrementCount();
										} // End if
									} // End foreach 
								}
								
							} 
						}
					} // End for
					*/
					

					// TODO: Increment count for follow

				} // End else

				// if(wordArrayList.contains())
			} // End for
		} // End for

		// TODO: Testing wordArrayList
		for(int wordIndex = 0; wordIndex < wordArrayList.size(); wordIndex++) {
			System.out.print(wordArrayList.get(wordIndex).word + ": ");
			for(Follow followWord : wordArrayList.get(wordIndex).followArrayList) {
				System.out.print(followWord.word + "(" + followWord.count + ") ");
			} // End for
			System.out.println();
		} // End for

	} // End void loadWords

	public void findWord(String string) {

	} // End void findWord()
}
