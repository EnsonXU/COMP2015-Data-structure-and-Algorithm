import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q1{

	public static void main(String[] args) throws IOException {
		Sorter sorter = new Sorter();
		BufferedReader reader = new BufferedReader(new FileReader("Q1testdata.txt"));
		String input;
		while ((input = reader.readLine()) != null) {

				if (input.length() > 0)
					sorter.add(input.toLowerCase());
		}
		reader.close();
		System.out.println("Result 1 ======================");
		sorter.printOrderedByAppearanceInDsc();
		
		for(int i=0; i<5; i++)
			sorter.add("model");
		System.out.println("\n\nResult 2 ======================");
		sorter.printOrderedByAppearanceInDsc();
	}
}
