package ie.tudublin;

public class Follow {
    // Private feilds
    String word;
    int count;

    public Follow(String word, int count) {
        this.word = word;
        this.count = count;
    } // End Follow Constructor




    // Accessort Methods
    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return "Word: " + word + "Appears " + count + "times.";
    }   


    
} // End class Follow
