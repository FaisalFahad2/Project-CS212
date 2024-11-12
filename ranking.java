public class ranking {
  enum dataStructures {
    index,
    invertedIndex,
    invertedIndexBST
  }

  private class rankingNode{
    String IDdoc;
    LinkedList<freqencyNode> rankOfIdDoc = new LinkedList<>();

    rankingNode(String IDdoc){
      this.IDdoc = IDdoc;
    }
  }

  private class freqencyNode{
    String word;
    int freqency;

    freqencyNode(String word , int freqency){
      this.word = word;
      this.freqency = freqency;
    }
  }
  
  public void rankIndex(String str , Index a){
    String words [] = str.split(" ");
    LinkedList<rankingNode> rank = new LinkedList<>();

    for(int i = 0; i < words.length; i++){
      String docs [] = a.search(words[i]);
      
    }
  } 

  public void rankInvertedIndex(String str){

  }

  public void rankInvertedIndexBST(String str){

  }
}
