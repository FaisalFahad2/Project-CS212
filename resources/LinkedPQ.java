public class LinkedPQ<T> {

	private static class PQNode<T> {
		int prio;
		T data;
		PQNode<T> next;

		public PQNode(int prio, T data) {
			this.prio = prio;
			this.data = data;
			next = null;
		}
	}
	
	private PQNode<T> head;
	private int count;
  private PQNode<T> currunt;

	public LinkedPQ() {
		head = null;
		count = 0;
	}

  // find data and current change to data 
  // if data not found current not change
  public boolean find (T data){
    PQNode<T> n = head;
    while (n != null) {
      if(n.data.equals(data)){
        currunt = n;
        return true;
      }
      n = n.next;
    }
    return false;
  }

  public void plusPrio(int pri){
    currunt.prio += pri; 
  }

	public int length () {
		return count;
	}

	public boolean full () {
		return false;
	}
	
	public void enqueue(int prio, T data) {
		PQNode<T> newNode = new PQNode<T>(prio, data);
		
		newNode.next = head;
		head = newNode;
		
		count++;
	}

	public PQElement<T> serve() {
		PQNode<T> max = head, maxprev = null, c = head.next, cprev = head;
		
		while (c != null) {
			if (c.prio > max.prio) {
				max = c;
				maxprev = cprev;
			}
			
			cprev = c;
			c = c.next;
		}
		if (maxprev == null)
			head = head.next;
		else
			maxprev.next = max.next;
		
		count--;
		
		return new PQElement<T>(max.prio, max.data);
	}
	
}