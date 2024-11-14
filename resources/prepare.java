import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class prepare {

  private final static LinkedList<String> stop[] = new LinkedList[26];
  private int numOfFile;

  public prepare(int numOfFile) {
    this.numOfFile = numOfFile;
  }

  public void fillStop() throws IOException {
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

  public String filter(String word) {
    word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    for (int i = 0; i < stop.length; i++) {

      stop[i].findFirst();

      if (stop[i].retrieve().equals("" + word.charAt(0))) {
        if (stop[i].contain(word))
          return "";
        break;
      }

    }
    return word + " ";
  }

  public String[] filterDocs() throws IOException {

    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\96650\\Project-CS212\\data\\dataset.csv"));
    reader.readLine();
    String doc[] = new String[numOfFile];

    for (int i = 0; i < doc.length; i++) {
      String line = reader.readLine().substring(2);
      String filtered = "";

      String str[] = line.split(" ");
      for (int j = 0; j < str.length; j++)
        filtered += filter(str[j]);

      doc[i] = filtered;
    }
    reader.close();
    return doc;

  }

}
