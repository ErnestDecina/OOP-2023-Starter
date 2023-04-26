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

    public int getCount() {
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public void incrementCount() {
        this.count++;
    }

    public String toString() {
        return (String) word + "( " + count + " )";
    }
    
} // End class Follow
