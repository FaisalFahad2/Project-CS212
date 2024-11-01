import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class prepare {
  
    public static LinkedList<String> stop[] = new LinkedList[26];
  
    public static void fillStop() throws IOException {
      BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\96650\\Project-CS212\\data\\stop.txt"));
      LinkedList<String> words = new LinkedList<>();
  
      char ch = 'a';
      String line;
      int count = 0;
  
      while (true) {
  
        line = reader.readLine();
        if (line == null)
          break;
  
        if (line.charAt(0) != ch) {
          count++;
          ch = line.charAt(0);
          words = new LinkedList<>();
  
        }
        words.insert(line);
  
        stop[count] = words;
      }
      reader.close();
    }
  
    // just to test
    public static void displey() {
      for (int i = 0; i < stop.length; i++) {
        if (stop[i] == null)
          break;
  
        stop[i].findFirst();
  
        while (!stop[i].last()) {
          System.out.println(stop[i].retrieve());
          stop[i].findNext();
        }
        System.out.println(stop[i].retrieve());
      }
    }
    //
  
    public static String filter (String word) {
      word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
      char c = word.charAt(0);
      for(int i = 0; i < stop.length; i++){
        
        stop[i].findFirst();

        if(stop[i].retrieve().equals(""+word.charAt(0))){
          if(stop[i].contain(word))
            return "";
          break;
        }
          
      }
      return word+" ";
      
    }
  
    public static String[] filterDocs () throws IOException{

      BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\96650\\Project-CS212\\data\\dataset.csv"));
      reader.readLine();
      String doc[] = new String [50];
      
      for(int i = 0; i < doc.length; i++){
        String line = reader.readLine().substring(2);
        String filtered = "";

        String str [] = line.split(" ");
        for(int j = 0; j < str.length; j++)
          filtered += filter(str[j]);

        doc[i] = filtered;
      }
      return doc;

    }
    public static void main(String[] args) {
      try {
        fillStop();
        
        String a[] = filterDocs();
        for(int i = 0; i < a.length; i++){

          System.out.println(i +": " +a[i]);
        }
      } catch (IOException e) {
        System.out.println("err");
      }
      
    }
}
  