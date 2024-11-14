public class ranking {

  public enum structure{
    index,
    invertedIndex,
    invertedIndexBST
  }

  private Index index;
  private InvertedIndex invertedIndex;
  private InvertedIndexBST invertedIndexBST;

  public ranking(Index index, InvertedIndex invertedIndex, InvertedIndexBST invertedIndexBST){
    this.index = index;
    this.invertedIndex = invertedIndex;
    this.invertedIndexBST = invertedIndexBST;
  }

  public String rank(String str , structure s){
    switch (s) {
      case index:
        return rankIndex(str);
      case invertedIndex:
        return rankInvertedIndex(str);
      case invertedIndexBST:
        return rankInvertedIndexBST(str);
        
    }
    return"";
  }

  public String rankIndex(String str){
    String words[] = str.split(" ");
    LinkedPQ<String> sorted = new LinkedPQ<String>();

    for(int i = 0; i < words.length; i++){
      String tmp = index.searchWithDuplicated(words[i]);

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

    for (int i = 0; i < length; i++) {
      PQElement<String> tmp = sorted.serve(); 
      result.append(String.format("%-12d %3d%n", Integer.parseInt(tmp.getData()), tmp.getPrio()));    
    }
    
    
    return result.toString();
  } 

  public String rankInvertedIndex(String str){
    String words[] = str.split(" ");
    LinkedPQ<String> sorted = new LinkedPQ<String>();

    for(int i = 0; i < words.length; i++){
      String tmp = invertedIndex.searchWithDuplicated(words[i]);

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

    for (int i = 0; i < length; i++) {
      PQElement<String> tmp = sorted.serve(); 
      result.append(String.format("%-12d %3d%n", Integer.parseInt(tmp.getData()), tmp.getPrio()));    
    }
    
    
    return result.toString();
  }

  public String rankInvertedIndexBST(String str){
    String words[] = str.split(" ");
    LinkedPQ<String> sorted = new LinkedPQ<String>();

    for(int i = 0; i < words.length; i++){
      String tmp = invertedIndexBST.searchWithDuplicated(words[i]);

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

    for (int i = 0; i < length; i++) {
      PQElement<String> tmp = sorted.serve(); 
      result.append(String.format("%-12d %3d%n", Integer.parseInt(tmp.getData()), tmp.getPrio()));    
    }
    
    
    return result.toString();
  }

    
}
