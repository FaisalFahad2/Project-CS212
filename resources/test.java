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

    hashMap hash = new hashMap(26);
    hash.fillTableHash(a);


    System.out.println(ind.search("business"));
    System.out.println(ind.searchWithDuplicated("world"));
    System.out.println(ind.searchWithDuplicated("market"));
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

    ranking r = new ranking(ind, ivner, BST, hash);

    System.out.println(r.rank("market sports" , ranking.structure.index));
    System.out.println(r.rank("weather warming", ranking.structure.index));
    System.out.println(r.rank("business world market", ranking.structure.index));

    System.out.println(r.rank("market sports", ranking.structure.invertedIndex));
    System.out.println(r.rank("weather warming", ranking.structure.invertedIndex));
    System.out.println(r.rank("business world market", ranking.structure.invertedIndex));

    System.out.println(r.rank("market sports" ,ranking.structure.invertedIndexBST));
    System.out.println(r.rank("weather warming" ,ranking.structure.invertedIndexBST));
    System.out.println(r.rank("business world market" ,ranking.structure.invertedIndexBST));

    System.out.println(r.rank("market sports" ,ranking.structure.hashMap));
    System.out.println(r.rank("weather warming" ,ranking.structure.hashMap));
    System.out.println(r.rank("business world market" ,ranking.structure.hashMap));

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
    System.out.println(r.rank("business a world market" ,ranking.structure.hashMap));

  }
}
