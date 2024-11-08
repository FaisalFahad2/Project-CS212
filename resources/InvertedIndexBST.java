public class InvertedIndexBST {

  private LinkedBST<String> a = new LinkedBST<String>();

  public void fillBST (String docs []){
    for(int i = 0; i < docs.length; i++){
      String words [] = docs[i].split(" ");

      for(int j = 0; j < words.length; j++){
        if(!a.insert(words[j], " " + i))
          a.update(a.retrieve()+ " " + i);
      }
    }
  }

  public String search(String k) {
    
    String or[] = k.split("OR");
    for(int i = 0; i < or.length; i++){

      String and[] = or[i].split("AND");

      for (int j = 0; j < and.length; j++) {
        
        if(a.findKey(and[i]))
          return a.retrieve();
        
          return "Not found";
      }
    }
  }

  public void print(){
    a.printTree();
  }

  
}
