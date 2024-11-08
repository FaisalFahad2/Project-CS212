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
      InvertedIndexBST BST = new InvertedIndexBST();
      BST.fillBST(a);
      BST.print();
      System.out.println(BST.search("market"));
      System.err.println(BST.search("changed"));
  }
}

