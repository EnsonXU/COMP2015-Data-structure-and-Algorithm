import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class AbsContentSorter {
	BufferedReader[] inputFiles = new BufferedReader[5];
	BufferedWriter out;
	int[] buffer = new int[5];
	int numOfFiles = 0;
	
	public AbsContentSorter() throws IOException {
		out = new BufferedWriter(new FileWriter("Q2outputfile.txt"));
	}
	
	public void openFile(String filename) throws FileNotFoundException {
		if (numOfFiles < inputFiles.length) {
			inputFiles[numOfFiles] = new BufferedReader(new FileReader(filename));
			numOfFiles++;
		} else 
			System.out.println("Too many files");
	}
	
	public int getInt(int inputFileIndex) {
		String str = null;
		
		try {
			str = inputFiles[inputFileIndex].readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (str != null)
			return Integer.parseInt(str);
		else
			return -1;
	}
	
	public void output(int x) throws IOException {
		out.write("" + x + "\n");
		out.flush();
	}
	
	abstract public void sort() throws IOException;
	
}