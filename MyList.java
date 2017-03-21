
class MyList extends AbsList {

	int start;
	int length;

	public MyList(int size) {
		super(size);
		start = 1;
		length = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i][1] = -2;
		}
	}

	public boolean append(int v) {

		int last;
		if (isEmpty()) {
			arr[start][0] = v;
			arr[start][1] = -1;
			length++;
			return true;
		} else if (isFull()) {
			return false;
		} else {
			// find the index of the last data
			last = 0;
			for (int i = 0; i <= arr.length; i++) {
				if (arr[i][1] == -1) {
					last = i;
					break;
				}
			}
			int empty = findEmpty();
			arr[last][1] = empty;
			arr[empty][0] = v;
			arr[empty][1] = -1;
			length++;
			return true;
		}
	}

	private int findEmpty() {
		int empty = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][1] == -2) {
				empty = i;
				break;
			}
		}
		return empty;
	}

	public boolean insert(int v, int p) {

		// not insert in the first
		if (p != 0) {
			int preindex = findPreviousIndex(p);
			int tmpnext = arr[preindex][1];
			int index = findEmpty();
			arr[index][0] = v;
			arr[index][1] = tmpnext;
			arr[preindex][1] = index;
			length++;
		}
		// insert in the first
		else if (p == 0) {
			int index = findEmpty();
			arr[index][0] = v;
			arr[index][1] = start;
			start = index;
			length++;
		}
		if (isFull()) {
			return false;
		}
		if (p + 1 == length) {
			return false;
		}

		return true;
	}

	private int findPreviousIndex(int p) {
		int index = start;
		for (int i = 1; i <= length; i++) {
			if (i == p - 1) {
				break;
			}
			index = arr[index][1];
		}

		return index;
	}

	@Override
	public boolean delete(int v) {
		int index = start;
		if (isEmpty()) {
			return false;
		} else {
			for (int i = 0; i <= length; i++) {
				// delete the start
				if (index >= 0 && arr[index][0] == v && index == start) {
					start = arr[index][1];
					arr[index][1] = -2;
					arr[index][0] = 0;
					length--;
					return true;
				} // delete others
				else if (index >= 0 && arr[index][0] == v && index != start && arr[index][1] != -1) {
					int tmpindex = arr[index][1];
					int preindex = findPreviousIndex(find(v));
					arr[index][1] = -2;
					arr[index][0] = 0;
					if (preindex >= 0) {
						arr[preindex][1] = tmpindex;
					}
					length--;
					return true;
				} else if (arr[index][0] == v && arr[index][1] == -1) {
					int preindex = findPreviousIndex(find(v));
					arr[preindex][1] = -1;
				}
				index = arr[index][1];
			}
		}
		return false;
	}

	public int find(int v) {
		int index = start;
		int i;
		if (isEmpty()) {
			return -1;
		} else {
			for (i = 0; i < length; i++) {
				if (index != -2 && arr[index][0] == v) {
					return i;
				} else if (index != -2) {
					index = arr[index][1];
				}
			}
			return -1;
		}
	}

	public void traversal() {
		int index = start;
		for (int i = 0; i <= length; i++) {
			System.out.print(arr[index][0] + " ");
			if (arr[index][1] == -1) {
				break;
			}
			index = arr[index][1];
		}
	}

	boolean isEmpty() {
		if (length == 0) {
			return true;
		} else {
			return false;
		}
	}

	boolean isFull() {
		if (length == arr.length) {
			return true;
		} else {
			return false;
		}
	}

	int length() {
		return length;
	}

}
