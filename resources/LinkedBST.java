public class LinkedBST<T> {
  
	private static class BSTNode<T> {
		String key;
		T data;
		BSTNode<T> left, right;

		public BSTNode(String key, T data) {
			this.key = key;
			this.data = data;
			left = right = null;
		}
	}
	
	private BSTNode<T> root, current;

	public LinkedBST() {
		root = current = null;
	}

	public boolean empty() {
		return root == null;
	}

	public boolean full() {
		return false;
	}

	public T retrieve() {
		return current.data;
	}

	public boolean findKey(String k) {
		BSTNode<T> n = root;
		while (n != null) {
			current = n;
			if (k.equals(n.key))
				return true;
			else if (k.compareTo(n.key) < 0)
				n = n.left;
			else
				n = n.right;
		}
		
		return false;
	}

	public void update(T data) {
		current.data = data;
		
	}

	public boolean insert(String k, T data) {
		if (root == null) {
			current = root = new BSTNode<T>(k, data);
			return true;
		}
		
		if (findKey(k)) 
			return false;
		
		BSTNode<T> newNode = new BSTNode<T>(k, data);
		if (k.compareTo(current.key) < 0)
			current.left = newNode;
		else 
			current.right = newNode;
		
		current = newNode;
		
		return true;
	}


	public boolean remove(String k) {
		BSTNode<T> n = root, p = null;
		while (n != null) {
			if (k.compareTo(n.key) < 0) {
				p = n;
				n = n.left;
			} 
			else if (k.compareTo(n.key) > 0) {
				p = n;
				n = n.right;
			}
			else { 
				// case 3
				if (n.left != null && n.right != null) {
					BSTNode<T> min = n.right;
					p = n;
					while (min.left != null) {
						p = min;
						min = min.left;
					}

					n.key = min.key;
					n.data = min.data;
					n = min;
				}
				// fall into case 1 & 2
				BSTNode<T> c = null;
				if (n.left != null)
					c = n.left;
				else
					c = n.right;
				
				if (p == null)
					root = c;
				else {
					if (n.key.compareTo(p.key) < 0)
						p.left = c;
					else
						p.right = c;
				}
				
				current = root;
				return true;
			} 
		}
		return false;
	}
	

	// try

	void printTree() {
		printTreeRec(root, 0);
}

// Helper function to print the tree structure
void printTreeRec(BSTNode<T> root, int level) {
		if (root == null) {
				return;
		}

		// Print the root node with indentation
		if (level != 0) {
			for (int i = 0; i < level - 1; i++)
					System.out.print("|\t");
			System.out.println("|-------" + root.data + " " + root.key);
	} else {
			System.out.println(root.data + " " + root.key);
	}

		// Print right subtree first (so it appears at the top right)
		printTreeRec(root.left, level + 1);

		

		// Print left subtree
		printTreeRec(root.right, level + 1);
}

}
