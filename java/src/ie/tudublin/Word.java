package ie.tudublin;

import java.util.ArrayList;

public class Word {
    private String word;
    private ArrayList<Follow> followArrayList;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<Follow> getFollowArrayList() {
        return followArrayList;
    }

    public void setFollowArrayList(ArrayList<Follow> follows) {
        this.followArrayList = follows;
    }
    
    public void addFollow(Follow currentFollow) {
        followArrayList.add(currentFollow);
    }

    public void addFollowCount(Follow currentFollow) {
        currentFollow.incrementCount();
    }

    public int findFollow(String word) {
        for(Follow currentFollow : followArrayList) {
            if(currentFollow.getWord().equals(word)) {
                return followArrayList.indexOf(currentFollow);
            }
        }
        return -1;
    }


    public Word(String word) {
        this.word = word;
        followArrayList = new ArrayList<Follow>();
    }
    
    public String toString() {
        String result = "";
        result += word + ":";
        for(Follow currentFollow : followArrayList)
        {
            result += " " + currentFollow.toString();
        }
        return result;
    }
} // End class Word
