import java.io.IOException;

public class ContentSorter extends AbsContentSorter {

	int index;

	public ContentSorter() throws IOException {
		super();

		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() throws IOException {
		// TODO Auto-generated method stub

		buffer[0] = getInt(0);
		buffer[1] = getInt(1);
		buffer[2] = getInt(2);
		buffer[3] = getInt(3);
		buffer[4] = getInt(4);

		do {

			output(findMin(buffer));
			buffer[index] = getInt(index);

		} while (buffer[0] != -1 && buffer[1] != -1 && buffer[2] != -1 && buffer[3] != -1 && buffer[4] != -1);

	}

	private int findMin(int[] a) {

		int min = a[0];
		index = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
				index = i;
			}
		}

		return min;
	}

}
