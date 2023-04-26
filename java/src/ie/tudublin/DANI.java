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

	public void loadFile() {
		String[] line = loadStrings("shakespere.txt");
		for(int i = 0; i < line.length; i ++)
		{
			String[] words = split(line[i], " ");
			for(int j = 0; j < words.length; j ++)
			{
				//get a word from line and create a word object, add it to model
				//then get the next word and create a follow object, add it to the arraylist of follows in the word object
				words[j] = words[j].replaceAll("[^a-zA-Z ]", "");
				words[j] = words[j].toLowerCase();

				//check if next word exist or not
				boolean lastWord;
				if(j+1 == words.length)
				{
					lastWord = true;
				}
				else
				{
					lastWord = false;
				}
				
				if(!lastWord)
				{
					words[j+1] = words[j+1].replaceAll("[^a-zA-Z ]", "");
					words[j+1] = words[j+1].toLowerCase();
				}

				int result = findWord(words[j]);
				Word word;
				//if word is not in model, add it
				if(result == -1)
				{
					word = new Word(words[j]);
					model.add(word);
				}
				else
				{
					word = model.get(result);
				}

				//check if follow for the word exist.
				if(!lastWord)
				{
					if(word.findFollow(words[j+1]) == -1)
					{
						word.addFollow(new Follow(words[j+1], 1));
					}
					else
					{
						word.addFollowCount(word.getFollows().get(word.findFollow(words[j+1])));
					}
				}
			}
		}
	}

	public int findWord(String word)
	{
		for(int i = 0; i < model.size(); i ++)
		{
			if(model.get(i).getWord().equals(word))
			{
				return i;
			}
		}
		return -1;
	}

	public void printModel()
	{
		for(Word w:model)
		{
			System.out.println(w.toString());
		}
	}

	public void writeSonnet()
	{
		sonnet = new String[14];
		//loop 14 times to create 14 lines
		for (int i = 0; i < 14; i++)
		{
			int r = (int) random(0, model.size());
			Word w = model.get(r);
			sb = new StringBuilder();
			sb.append(w.getWord() + " ");

			for(int k = 0; k < 7;k++)
			{
				int r2;

				if(w.getFollows().size() == 0)
				{
					break;
				}

				else
				{
					r2 = (int) random(0, w.getFollows().size());
				}
				Follow f = w.getFollows().get(r2);
				sb.append(f.getWord() + " ");
				w = model.get(findWord(f.getWord()));

			}
			String s = sb.toString();
			sonnet[i] = s;
		}
	}

	public void printSonnet()
	{
		for(String s:sonnet)
		{
			System.out.println(s);
		}
	}


}
