public class ranking {

  public enum structure{
    index,
    invertedIndex,
    invertedIndexBST,
    hashMap
  }

  private Index index;
  private InvertedIndex invertedIndex;
  private InvertedIndexBST invertedIndexBST;
  private hashMap hashMap;

  public ranking(Index index, InvertedIndex invertedIndex, InvertedIndexBST invertedIndexBST , hashMap hashMap){
    this.index = index;
    this.invertedIndex = invertedIndex;
    this.invertedIndexBST = invertedIndexBST;
    this.hashMap = hashMap;
  }

  public String rank(String str , structure s){
    String words[] = str.split(" ");
    LinkedPQ<String> sorted = new LinkedPQ<String>();

    for(int i = 0; i < words.length; i++){
      String tmp = "" ;
      
      switch (s) {
        case index:
          tmp = index.searchWithDuplicated(words[i]);
          break;
        case invertedIndex:
          tmp = invertedIndex.searchWithDuplicated(words[i]);
          break;
        case invertedIndexBST:
          tmp = invertedIndexBST.searchWithDuplicated(words[i]);
          break;
        case hashMap:
          tmp = hashMap.searchWithDuplicated(words[i]);
          break;
          
      }

      if(tmp == "Not found")
        break;

      String docs[] = tmp.split(" ");
      for (int j = 0; j < docs.length; j++) {
        if(sorted.find(docs[j]))
          sorted.plusPrio(1);
        else
          sorted.enqueue(1, docs[j]);
      }
    }   

    int length = sorted.length();
    StringBuilder result = new StringBuilder();
    result.append(String.format("%-12s %s%n", "DocumentID", "Score"));

    boolean flag = false; // if flag is true then other getPrio = 1 (don't check highest prio)

    for (int i = 0; i < length; i++) {
      PQElement<String> tmp ; 
      if (flag == true)
        tmp = sorted.serveFromHead();
      else
        tmp = sorted.serve();

      result.append(String.format("%-12d %3d%n", Integer.parseInt(tmp.getData()), tmp.getPrio()));

      if(tmp.getPrio() == 1)
        flag = true;
    }
    return result.toString();
  }

}
