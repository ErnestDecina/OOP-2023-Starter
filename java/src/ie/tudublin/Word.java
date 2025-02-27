package ie.tudublin;

import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<Follow> followArrayList;

    public Word(String word) {
        this.word = word;
        followArrayList = new ArrayList<Follow>();
    } // End Word Constructor

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<Follow> getFollowArrayList() {
        return followArrayList;
    }

    public void setFollowArrayList(ArrayList<Follow> currentFollow) {
        this.followArrayList = currentFollow;
    }

    public void addFollow(Follow currentFollow) {
        this.followArrayList.add(currentFollow);
    }

    public void addFollowCount(Follow currentFollow) {
        currentFollow.incrementCount();
    }

    public int findFollow(String word) {
        for(Follow currentFollow : followArrayList)
            if(currentFollow.getWord().equals(word))  return this.followArrayList.indexOf(currentFollow);
        return -1;
    }
    
    public String toString() {
        String result = "Word: ";
        result += word + " :";
        for(Follow currentFollow : followArrayList)
            result += " " + currentFollow.toString();

        return result;
    }
} // End class Word
