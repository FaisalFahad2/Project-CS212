public class LinkedList<T> {

  private static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			next = null;
		}
	}


	private Node<T> head;
	private Node<T> current;
	private int size;
	

	
	public LinkedList() {
		head = current = null;
		size = 0;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean full() {
		return false;
	}

	public boolean last() {
		return current.next == null;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public T retrieve() {
		return current.data;
	}

	//for inverted Index
	public T retrieveHead() {
		return head.data;
	}

	public void update(T data) {
		current.data = data;
	}

	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);

		if (head == null) {
			head = current = newNode;
		} 
		else {
			newNode.next = current.next;
			current.next = newNode;
			current = newNode;
		}
		size++;
	}

	public void remove() {
		if (current == head) {
			head = head.next;
		} 
		else {
			Node<T> prev = head;
			while (prev.next != current) {
				prev = prev.next;
			}

			prev.next = current.next;
		}

		current = (current.next == null) ? head : current.next;
		size--;
	}
  
  public boolean contain(T data){
    Node<T> c = head;

    while (c != null) {
      if(c.data.equals(data))
        return true;
      c = c.next;
    }
    return false;
  }

  public int size() {
		return size;
	}

	
}
