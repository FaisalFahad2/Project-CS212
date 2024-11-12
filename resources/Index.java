
public class Index {
	private LinkedList<LinkedList> a = new LinkedList<LinkedList>();

	public void fillIndex(String docs[]) {
		int found;
		LinkedList x;
		boolean flag = false;

		for (int i = 0; i < docs.length; i++) {
			String[] words = docs[i].split(" ");
			for (int j = 0; j < words.length; j++) {
				flag = false;
				LinkedList temp = new LinkedList<String>();
		
				a.findFirst();
				for (int k = 0; k < a.size(); k++) {
					x = a.retrieve();
					x.findFirst();

					if (x.retrieve().equals(words[j])) {
						x.insert(i);
						a.update(x);
						flag = true;
					}
					a.findNext();
				}

				if (flag == false) {
					temp.insert(words[j]);
					temp.insert(i);
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
			LinkedList temp = a.retrieve();
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
