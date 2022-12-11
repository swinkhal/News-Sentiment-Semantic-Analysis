import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Locale;

public class TFIDF {
    public static int documents_size;
    public static ArrayList<String> search_query;
    public static ArrayList<String> documents;

    public static int getDocuments_size() {
        return documents_size;
    }

    public static void setDocuments_size(int documents_size) {
        TFIDF.documents_size = documents_size;
    }

    public static void setDocuments(ArrayList<String> documents) {
        TFIDF.documents = documents;
    }


    public static ArrayList<String> getSearch_query() {
        return search_query;
    }

    public static void setSearch_query(ArrayList<String> search_query) {
        TFIDF.search_query = search_query;
    }

    public static int getDocuments() {
        return documents_size;
    }

    public static void setDocuments(int documents_size) {
        TFIDF.documents_size = documents_size;
    }

    public TFIDF() {
    }

    public static void calculateTFIDF(){
        System.out.println("query       doc-containing-term         total/df        Log10(N/df)");
        for(String str:search_query){
            int df=0;
            for(String doc: documents){

                String[] words = doc.trim().split(" ");
                for(int i=0; i<words.length;i++){
                    if (words[i].toLowerCase(Locale.ENGLISH).equals(str)) {
                        df+=1;
                        break;
                    }
                }
            }
            if(df!=0) {
                System.out.println(String.format("%8s   %20d    %5.10f    %5.10f", str, df,(float) documents_size / df, Math.log10((float)documents_size / df)));
            }
        }
    }

    public static void calculatehighestTF(String str){
        System.out.println("Article total-words  frequency  f/m");
            float max_tf=0;
            int count=0;
            for(String doc: documents){
                int df = 0;
                count+=1;
                String[] words = doc.trim().split(" ");
                int tf = words.length;

                for(int i=0; i<words.length;i++){
                    if (words[i].toLowerCase(Locale.ENGLISH).equals(str)) {
                        df+=1;
                    }
                }
                if(df!=0) {
                    System.out.println(String.format("%5d   %5d    %5d          %2.7f", count,tf,df,(float)df/tf ));
                    if((float)df/tf > max_tf){
                        max_tf=(float)df/tf;
                    }
                }
            }
        System.out.println(String.format("Highest tf for "+str+" is : %2.7f",max_tf));
    }

}
