import java.io.IOException;

public class test {
  public static void main(String[] args) {
    String a[] = new String[0];
    prepare p = new prepare(50);
      try {
        p.fillStop();
        a = p.filterDocs();

      } catch (IOException e) {
        System.out.println("err");
      }
      Index ind = new Index();
      ind.fillIndex(a);
      InvertedIndexBST BST = new InvertedIndexBST();
      BST.fillBST(a);
      System.out.println(ind.search("market"));
      System.out.println(ind.search("changed"));
      System.out.println(ind.search("a"));
      System.out.println(BST.search("market"));
      System.err.println(BST.search("changed"));
  }
}

