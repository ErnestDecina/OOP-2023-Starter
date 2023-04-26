package ie.tudublin;

public class Follow {
    public String word;
    public int count;

    public Follow(String word,int count) {
        this.word=word;
        this.count=count;
    } // End Follow Constructor

    public String getWord() {
        return this.word;
    }

    public int getCount() {
        return this.count;
    }

    public void incrementCount() {
        this.count++;
    }

    public String toString() {
        return (String) this.word + "( " + this.count + " )";
    }
    
} // End class Follow
