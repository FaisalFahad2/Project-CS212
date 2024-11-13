public class ranking {

  private class DocumentScoreNode {
    int docId;
    int score;

    public DocumentScoreNode(int docId, int score) {
        this.docId = docId;
        this.score = score;
    }

    public int getDocId() {
        return docId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score){
      this.score = score;
    }
}

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
        rankInvertedIndex(str);
      case invertedIndexBST:
        rankInvertedIndexBST(str);
        
    }
    return"";
  }

  public String rankIndex(String str){
    String words [] = str.split(" ");
    LinkedList<DocumentScoreNode> ranked = new LinkedList<>();
    

    for(int i = 0; i < words.length; i++){
      String found = index.search(words[i]);

      if(found != "Not found"){
        String docs [] = found.split(" ");

        for(int j = 0; j < docs.length; j++)
          update(ranked, Integer.parseInt(docs[j]));  
          
      }
    }

    String result = "";
    if(!ranked.empty()){
      ranked.findFirst();
      for(int i = 0; i < ranked.size(); i++){
        DocumentScoreNode c = ranked.retrieve();
        result += "Document ID: " + c.getDocId() + ", Score: " + c.getScore() + "\n";
        ranked.findNext();
      }
    }

    return result;
  } 

  public void rankInvertedIndex(String str){

  }

  public void rankInvertedIndexBST(String str){

  }

  private void update(LinkedList<DocumentScoreNode> list, int ID){

    if(list.empty()){
      list.insert(new DocumentScoreNode(ID, 1));
      return;
    }

    list.findFirst();
    
    
    for(int i = 0; i < list.size(); i++) {

      DocumentScoreNode c = list.retrieve();
      if(c.getDocId() == ID){
        c.setScore(c.getScore() + 1);
        return;
      }

      

      if(!list.last())
        list.findNext();
    }

    list.insert(new DocumentScoreNode(ID, 1));
      
    
  }

  
}
