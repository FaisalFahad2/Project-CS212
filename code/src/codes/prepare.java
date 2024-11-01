package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class prepare {
  public static LinkedList<String> stop[] = new LinkedList[28];
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

  public static void filter(LinkedList<String[]> docs) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\96650\\Project-CS212\\data\\stop.txt"));
    String line = reader.readLine();
    String parts[];

    while (line != null) {
      line = reader.readLine();
      parts = line.split(" ");
    }
  }

  public static void main(String[] args) {
    try {
      fillStop();
      displey();
    } catch (IOException e) {
      System.out.println("err");
    }

  }
}
