
public class Querys {

	public enum structure {
		index, invertedIndex, invertedIndexBST, hashMap
	}

	private Index index;
	private InvertedIndex invertedIndex;
	private InvertedIndexBST invertedIndexBST;
	private hashMap hashMap;

	public Querys(Index index, InvertedIndex invertedIndex, InvertedIndexBST invertedIndexBST, hashMap hashMap) {
		this.index = index;
		this.invertedIndex = invertedIndex;
		this.invertedIndexBST = invertedIndexBST;
		this.hashMap = hashMap;
	}

	private String searchByStructure(String term, structure s) {

		switch (s) {
		case index:
			return index.search(term.trim());
		case invertedIndex:
			return invertedIndex.search(term.trim());
		case invertedIndexBST:
			return invertedIndexBST.search(term.trim());
		case hashMap:
			return hashMap.search(term.trim());
		default:
			return "Not found";
		}
	}

	private String and(String a, String b, structure s) {
		String strA = a;
		String strB = b;

		if (strA.equalsIgnoreCase("Not found") || strB.equalsIgnoreCase("Not found"))
			return "Not found";

		StringBuilder temp = new StringBuilder();

		String[] aa = strA.split("\\s+");
		String[] bb = strB.split("\\s+");

		if (!(aa[0].charAt(0) >= 48 && aa[0].charAt(0) <= 57))
			return "one of the words are not found";

		if (!(bb[0].charAt(0) >= 48 && bb[0].charAt(0) <= 57))
			return "one of the words are not found";

		int x = 0, y = 0;

		while (true) {
			if (Integer.parseInt(aa[x]) > Integer.parseInt(bb[y])) {
				if (y != bb.length)
					y++;
			} else if (Integer.parseInt(aa[x]) < Integer.parseInt(bb[y])) {
				if (x != aa.length)
					x++;
			} else {
				temp.append(aa[x] + " ");
				if (x != aa.length)
					x++;
				if (y != bb.length)
					y++;
			}

			if (x == aa.length || y == bb.length)
				break;
		}

		if (temp.toString().length() == 0) {
			return "no intersections";
		}
		return temp.toString();
	}

	private String or(String a, String b) {
		StringBuilder temp = new StringBuilder();
		String[] aa = a.trim().split("\\s+");
		String[] bb = b.trim().split("\\s+");

		if (!(aa[0].charAt(0) >= 48 && aa[0].charAt(0) <= 57))
			return b;

		if (!(bb[0].charAt(0) >= 48 && bb[0].charAt(0) <= 57))
			return a;

		int x = 0, y = 0;

		while (true) {
			if (Integer.parseInt(aa[x]) > Integer.parseInt(bb[y])) {
				temp.append(bb[y] + " ");
				if (y != bb.length)
					y++;
			} else if (Integer.parseInt(aa[x]) < Integer.parseInt(bb[y])) {
				temp.append(aa[x] + " ");
				if (x != aa.length)
					x++;
			} else {
				temp.append(aa[x] + " ");
				if (x != aa.length)
					x++;
				if (y != bb.length)
					y++;
			}

			if (x == aa.length || y == bb.length)
				break;
		}

		if (x < aa.length) {
			for (int i = x; i < aa.length; i++)
				temp.append(aa[i] + " ");
		}
		if (y < bb.length) {
			for (int i = y; i < bb.length; i++)
				temp.append(bb[i] + " ");
		}
		return temp.toString();
	}

	public String Query(String k, structure s) {
		String[] splitOr = k.split("\\b" + "or" + "\\b");
		String orAll = "";
		for (int i = 0; i < splitOr.length; i++) {
			String[] splitAnd = splitOr[i].split("\\b" + "and" + "\\b");

			if (1 < splitAnd.length) {
				String temp = "";
				for (int j = 0; j < splitAnd.length; j++) {
					// search and store
					if (j == 0)
						temp = searchByStructure(splitAnd[j].trim(), s);

					// and with search
					else
						temp = and(temp, searchByStructure(splitAnd[j].trim(), s), s);

				}
				splitOr[i] = temp.trim();
			} else {
				splitOr[i] = searchByStructure(splitAnd[0], s);
			}
		}

		for (int i = 0; i < splitOr.length; i++) {
			if (i == 0)
				orAll = splitOr[i];
			else
				orAll = or(orAll, splitOr[i]);
		}
		return orAll;
	}
}
