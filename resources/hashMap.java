public class hashMap {
  
  private LinkedBST<String> table [];

  public hashMap(int size){
    table = new LinkedBST [size];
  }

  private int function(String word){
    int index = word.charAt(0) - 97;
    if(index < 0 || index > table.length - 1)
      return table.length - 1;
    return index;
  }

  public void insert(String word , String data){
    int index = function(word);
    
    if(table[index] == null)
      table[index] = new LinkedBST<String>();
    if (!table[index].insert(word, data))
      table[index].update(table[index].retrieve() + " " + data);
  }

  public void fillTableHash(String docs []){
    for(int i = 0; i < docs.length; i++){

      String words[] = docs[i].split(" ");
      for(int j = 0; j < words.length; j++)
        insert(words[j], "" + i);
    }
    for (int i = 0; i < table.length; i++)
      if(table[i] == null)
        table[i] = new LinkedBST<String>();
  }

  public String search(String word) {
    int index = function(word);
    if (table[index].findKey(word)){
      String docs[] = table[index].retrieve().split(" ");
      String result = "";
      for (int i = 0; i < docs.length; i++) {
        if(!result.contains(docs[i]))
          result += docs[i] + " ";
      }
      return result;
    }
    return "Not found";
  }

  public String searchWithDuplicated(String word) {
    int index = function(word);
    if (table[index].findKey(word))
      return table[index].retrieve();

    return "Not found";
  }

  // test
  public void print() {
    for(int i = 0; i < table.length; i++){
      System.err.println(i);
      table[i].printTree();
    }
  }


}
