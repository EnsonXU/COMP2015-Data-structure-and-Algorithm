
public class Sorter implements InfSorter {

	static String[] table = null;
	int[] count = null;
	int numOfKeys = 0;
	int findIndex = -1;

	public Sorter() {
		// initialize the arrays
		table = new String[1];
		count = new int[1];
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
	}

	public void add(String str) {

		int index = 0;
		int k = 0;
		int c = 0;
		index = k = hash(str);

		if (find(str) == true) {
			try {
				count[findIndex]++;
				return;
			} catch (ArrayIndexOutOfBoundsException e) {

			}
		}

		while (table[index] != null) {
			c++;
			index = hash(k + c * c);
		}

		table[index] = str;
		count[index]++;
		numOfKeys++;

		if (numOfKeys * 2 >= table.length) {
			rehashing();
		}
	}

	private boolean find(String str) {

		findIndex = -1;
		for (int i = 0; i < table.length; i++) {
			if (str.equals(table[i])) {
				findIndex = i;
				return true;
			}
		}

		return false;
	}

	int findIndex(String x) {
		int result = -1;

		try {
			for (int i = 0; i < table.length; i++) {
				if (table[i].equals(x)) {
					result = i;
				}
			}
		} catch (NullPointerException e) {

		}

		return result;
	}

	private int hash(int i) {
		return i % table.length;
	}

	int hash(String x) {
		int i = 0;
		try {
			i = Integer.parseInt(x);

		} catch (NumberFormatException e) {

		}
		return i % table.length;

	}

	boolean isPrime(int x) {

		for (int i = 2; i <= Math.sqrt(x); i++)
			if (x % i == 0)
				return false;

		return true;
	}

	int nextPrime(int x) {
		int p = x;
		if (p == 2)
			return p;

		if (p % 2 == 0)
			p++;

		while (!isPrime(p))
			p += 2;

		return p;
	}

	void rehashing() {
		String[] oldTable = table;
		int[] oldTable2 = count;
		table = new String[nextPrime(oldTable.length * 2)];
		count = new int[nextPrime(oldTable2.length * 2)];
		try {
			for (String x : oldTable) {
				if (x.equals(null) == false)
					add(x);
			}
		} catch (NullPointerException e) {

		}

	}

	public void printOrderedByAppearanceInDsc() {

		shellSort(count);
		for (int i = table.length-1; i >0 ; i--) {
			if (table[i] != null) {
				System.out.println(table[i] + " , " + count[i]);
			}
		}
	}

	public static void shellSort(int[] a) {
		int j;

		for (int gap = a.length / 2; gap > 0; gap /= 2) {

			for (int i = gap; i < a.length; i++) {

				int tmp = a[i];
				String tmp1 = table[i];

				for (j = i; j >= gap; j -= gap) {

					if (tmp >= a[j - gap])
						break;

					a[j] = a[j - gap];
					table[j] = table[j - gap];

				}
				a[j] = tmp;
				table[j] = tmp1;
			}
		}
	}
}
