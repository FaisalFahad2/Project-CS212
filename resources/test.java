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
    
    InvertedIndex ivner = new InvertedIndex();
    ivner.fillIndex(a);
    
    InvertedIndexBST BST = new InvertedIndexBST();
    BST.fillBST(a);
    
    System.out.println(ind.search("market"));
    System.out.println(ind.search("sports"));
    System.out.println(ind.searchWithDuplicated("sports"));
    System.out.println(ind.search("a"));
    System.out.println("inverted:");
    System.out.println(ivner.search("sports"));
    System.out.println(ivner.searchWithDuplicated("sports"));
// Q: weather warming
    System.out.println(ivner.search("weather"));
    System.out.println(ivner.searchWithDuplicated("weather"));
    System.out.println(ivner.search("warming"));
    System.out.println(ivner.searchWithDuplicated("warming"));

    System.out.println("BST");
    System.out.println(BST.search("weather"));
    System.out.println(BST.search("warming"));
    System.out.println(BST.search("market"));
    System.err.println(BST.search("sports"));

    System.out.println(BST.searchWithDuplicated("weather"));
    System.out.println(BST.searchWithDuplicated("warming"));
    System.out.println(BST.searchWithDuplicated("market"));
    System.err.println(BST.searchWithDuplicated("sports"));

    ranking r = new ranking(ind, null, BST);

   // System.out.println(r.rankIndex("market sports"));

  }
}
