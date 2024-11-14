
public class InvertedIndex {
	private LinkedList<LinkedList<String>> a = new LinkedList<LinkedList<String>>();

	public void fillIndex(String docs[]) {
		LinkedList<String> x;
		boolean flag = false;

		for (int i = 0; i < docs.length; i++) {
			String[] words = docs[i].split(" ");

			for (int j = 0; j < words.length; j++) {
				flag = false;
				LinkedList<String> temp = new LinkedList<String>();
		
				a.findFirst();
				for (int k = 0; k < a.size(); k++) {
					x = a.retrieve();

					if (x.retrieveHead().equals(words[j])) {
						x.insert(String.valueOf(i));
						a.update(x);
						flag = true;
					}
					a.findNext();
				}

				if (flag == false) {
					temp.insert(words[j]);
					temp.insert(String.valueOf(i));
					a.findFirst();
					a.insert(temp);
				}

			}

		}
	}

	public String search(String k) {
		StringBuilder foundIn = new StringBuilder();

		a.findFirst();
		for (int i = 0; i < a.size(); i++) {
			LinkedList<String> temp = a.retrieve();
			temp.findFirst();

			if (temp.retrieve().equals(k)) {
				for (int j = 0; j < temp.size() - 1; j++) {
					temp.findNext();
					int ind = foundIn.indexOf(temp.retrieve() + " ");

					if(ind == -1)
						foundIn.append(temp.retrieve() + " ");
						
				}
				return foundIn.toString();
			}
			a.findNext();
		}
		return "Not found";
	}

	// search for rank
	public String searchWithDuplicated(String k) {
		StringBuilder foundIn = new StringBuilder();

		a.findFirst();
		for (int i = 0; i < a.size(); i++) {
			LinkedList<String> temp = a.retrieve();
			temp.findFirst();

			if (temp.retrieve().equals(k)) {
				for (int j = 0; j < temp.size() - 1; j++) {
					temp.findNext();
					foundIn.append(temp.retrieve() + " ");
				}
				return foundIn.toString();
			}
			a.findNext();
		}
		return "Not found";

	}

}
