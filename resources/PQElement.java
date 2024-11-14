public class PQElement<T> {
  
    private int prio;
    private T data;
  
    public PQElement(int prio, T data) {
      this.prio = prio;
      this.data = data;
    }

    public int getPrio() {
      return prio;
    }
  
    public T getData() {
      return data;
    }
  
}
