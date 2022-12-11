import java.util.ArrayList;
import java.util.HashMap;

public class BagofWords {

    public static ArrayList<String> positive_words;
    public HashMap<Integer, ArrayList<String>> matches;
    public HashMap<Integer, String> sentiment;
    public int count;

    public BagofWords() {
        count=0;
        this.matches = new HashMap<>();
        this.sentiment = new HashMap<>();
    }

    public static ArrayList<String> getPositive_words() {
        return positive_words;
    }

    public static void setPositive_words(ArrayList<String> positive_words) {
        BagofWords.positive_words = positive_words;
    }

    public static ArrayList<String> getNegeative_words() {
        return negeative_words;
    }

    public static void setNegeative_words(ArrayList<String> negeative_words) {
        BagofWords.negeative_words = negeative_words;
    }

    public static ArrayList<String> negeative_words;


    boolean isNegative(String str){
        for(String word: negeative_words){
            if(str.equals(word)){
                return true;
            }
        }
        return false;
    }

    boolean isPositive(String str){
        for(String word: positive_words){
            if(str.equals(word)){
                return true;
            }
        }
        return false;
    }

    void getSentiment(String text){
        count+=1;
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("text: "+text);
        String[] words = text.trim().split(" ");
        int score=0;
        ArrayList<String> match= new ArrayList<String>();

        for (String word: words
             ) {
            if(isNegative(word)){
                match.add(word);
                score-=1;
            }
            if(isPositive(word)){
                match.add(word);
                score+=1;
            }
        }

        matches.put(count,match);
        System.out.println("matches "+match);


        if(score>0){
            sentiment.put(count,"positive");
            System.out.println("Sentiment: Positive ");

        }
        else if(score<0){
            sentiment.put(count,"negetive");
            System.out.println("Sentiment: negetive ");

        }
        else {
            sentiment.put(count,"neutral");
            System.out.println("Sentiment: neutral ");

        }
    }

}
