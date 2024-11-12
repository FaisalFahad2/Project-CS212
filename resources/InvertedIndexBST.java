public class InvertedIndexBST {

  private LinkedBST<String> a = new LinkedBST<String>();

  public void fillBST (String docs []){
    for(int i = 0; i < docs.length; i++){
      String words [] = docs[i].split(" ");

      for(int j = 0; j < words.length; j++){
        if(!a.insert(words[j], "" + i))
          a.update(a.retrieve()+ " " + i);
      }
    }
  }

  public String search(String k) {  
        if(a.findKey(k))
          return a.retrieve();
        
          return "Not found";
  }

  //test
  public void print(){
    a.printTree();
  }
}
