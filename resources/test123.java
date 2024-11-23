import java.io.IOException;

public class test123 {
  public static void main(String[] args) {
    String a[] = new String[0];
    prepare p = new prepare(50);
      try {
        p.fillStop();
        a = p.filterDocs();

      } catch (IOException e) {
        System.out.println("err");
      }
   
      
      
      Index BST = new Index();
      BST.fillIndex(a);
      InvertedIndex ivner = new InvertedIndex();
      ivner.fillIndex(a);
      
      InvertedIndexBST iib = new InvertedIndexBST();
      iib.fillBST(a);

      hashMap hash = new hashMap(26);
      hash.fillTableHash(a);
      
      
      //BST.print();
      String testt = "  ";
      Querys aaa = new Querys(BST,ivner,iib,hash);

      System.out.println(testt);
      System.err.println("global: "+BST.search("global"));
      System.err.println("supply: "+BST.search("supply"));
      System.err.println("accurate: "+BST.search("accurate"));

      System.out.println(aaa.Query(testt, Querys.structure.hashMap));
      
//      System.err.println("shift: "+BST.search("shift"));
//      System.err.println("global: "+BST.search("global"));
//      System.err.println("market: "+BST.search("market"));
      
//      System.out.println(BST.or("shift","global"));
     // BST.Query(testt);
/*      Test: OR query - weather or technology
      Query: "weather or technology"
      Expected: "2 6 7"
      Got: "0 2 4 6 7"
      Status: FAILED
      
      */
     
//     4 15 24 27 34 39 42 48       
   /*   InvertedIndexBST BST = new InvertedIndexBST();
      BST.fillBST(a);
      BST.print();
      System.out.println(BST.search("market"));
      System.err.println(BST.search("changed"));*/
  }
}

