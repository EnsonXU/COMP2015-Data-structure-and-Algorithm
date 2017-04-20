import java.io.IOException;

public class Q2 {

	public static void main(String[] args) throws IOException {
		ContentSorter cs = new ContentSorter();
		for(int i=0; i<5; i++)
			cs.openFile(String.format("Q2testdata_%d.txt", i));
		cs.sort();
	}

}
