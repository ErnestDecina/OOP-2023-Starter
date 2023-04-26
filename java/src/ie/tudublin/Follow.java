package ie.tudublin;

public class Follow {
    // Private feilds
    String word;
    int count;

    public Follow(String word) {
        this.word = word;
        this.count = 1;
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

    public void incrementCount() {
        count++;
    } // End void incremenentCount


    
} // End class Follow
