
public class InvertedIndex {

	private LinkedList<LinkedList> a = new LinkedList<LinkedList>();

	public void fillIndex(String docs[]) {

		for (int i = 0; i < docs.length; i++) {
			LinkedList IDs = new LinkedList<String>();
			String[] words = docs[i].split(" ");

			for (int j = 0; j < words.length; j++) {

				IDs.insert(words[j]);
			}
			a.insert(IDs);

		}

	}

	public String search(String k) {
		StringBuilder foundIn = new StringBuilder();

		a.findFirst();
		for (int l = 0; l < a.size(); l++) {

			LinkedList temp = a.retrieve();
			temp.findFirst();

			if (temp.contain(k))
				foundIn.append(l + " ");
			a.findNext();
		}

		if (foundIn.toString().equals(""))
			return "Not found";
		return foundIn.toString();
	}

}
