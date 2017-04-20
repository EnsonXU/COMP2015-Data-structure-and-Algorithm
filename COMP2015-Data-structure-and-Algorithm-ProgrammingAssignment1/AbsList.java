abstract class AbsList {
	int[][] arr;

	public AbsList(int size) {
		arr = new int[size][2]; // instantiate a 2D array
	}

	/**
	 * append value v to the end of the list
	 * 
	 * @param v
	 *            - value
	 * @return true if success. Otherwise, false.
	 */
	public abstract boolean append(int v);

	/**
	 * insert value v in the list at position p.
	 * 
	 * @param v
	 *            - value.
	 * @param p
	 *            - position.
	 * @return true if success. Otherwise, false.
	 */
	public abstract boolean insert(int v, int p);

	/**
	 * delete the first occurred value v in the list.
	 * 
	 * @param v
	 *            - value.
	 * @return true if success. Otherwise, false.
	 */
	public abstract boolean delete(int v);

	/**
	 * find value v in the list.
	 * 
	 * @param v
	 *            - value.
	 * @return the position of the first occurred value v. -1 indicates value v
	 *         is not in the list
	 */
	public abstract int find(int v);

	/**
	 * print values stored in the list.
	 */
	public abstract void traversal();

	/**
	 * check whether the list is empty or not
	 * 
	 * @return true if empty
	 */
	abstract boolean isEmpty();

	/**
	 * check whether the list is full or not
	 * 
	 * @return true if full
	 */
	abstract boolean isFull();

	/**
	 * get the length of the list
	 * 
	 * @return the length
	 */
	abstract int length();

	/**
	 * print all elements stored in the array
	 */
	public void printArray() {
		String str;
		for (int i = 0; i < arr.length; i++) {
			str = String.format("#%d, Data: %d, Next: %d", i, arr[i][0], arr[i][1]);
			System.out.println(str);
		}
	}

	/**
	 * get the status of the list
	 * 
	 * @return status
	 */
	public String status() {
		if (isEmpty())
			return "list is empty.";
		else if (isFull())
			return "list is full.";
		else {
			return String.format("Total %d number%s stored in the list.", length(), (length() > 1 ? "s" : ""));
		}
	}

}