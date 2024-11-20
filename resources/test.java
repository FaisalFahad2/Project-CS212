import java.io.IOException;
import java.util.Set;

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

    hashMap hash = new hashMap(26);
    hash.fillTableHash(a);


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

    ranking r = new ranking(ind, ivner, BST);

    System.out.println(r.rankIndex("market sports"));
    System.out.println(r.rankIndex("weather warming"));
    System.out.println(r.rankIndex("business world market"));

    System.out.println(r.rankInvertedIndex("market sports"));
    System.out.println(r.rankInvertedIndex("weather warming"));
    System.out.println(r.rankInvertedIndex("business world market"));

    System.out.println(r.rankInvertedIndexBST("market sports"));
    System.out.println(r.rankInvertedIndexBST("weather warming"));
    System.out.println(r.rankInvertedIndexBST("business world market"));

    System.out.println("hash");
    System.out.println(hash.searchWithDuplicated("weather"));
    System.out.println(hash.searchWithDuplicated("warming"));
    System.out.println(hash.searchWithDuplicated("market"));
    System.err.println(hash.searchWithDuplicated("sports"));
    
    System.out.println(hash.search("weather"));
    System.out.println(hash.search("warming"));
    System.out.println(hash.search("market"));
    System.err.println(hash.search("sports"));

    System.out.println(hash.search("x"));
    
    hash.print();
  }
}
