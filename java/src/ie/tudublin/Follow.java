package ie.tudublin;

public class Follow {
    public String word;
    public int count;

    public Follow(String word,int count) {
        this.word=word;
        this.count=count;
    } // End Followw Constructor

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public String toString() {
        return word + "(" + count + ")";
    }
    
} // End class Follow
