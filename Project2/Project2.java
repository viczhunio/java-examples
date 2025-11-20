import java.util.StringTokenizer; 
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Project2 {
	public static void main(String[] args) {

		// check if filename provided
		if (args.length == 0) {
			System.out.println("Provide a filename. Usage: java Project2 <filename>");
			System.exit(1);
		}

		String filename = args[0]; 

		//create 2 linked lists 
		UnsortedDate212List unsortedList = new UnsortedDate212List();
		SortedDate212List sortedList = new SortedDate212List();

		//read from file 
		readFromFile(filename, unsortedList, sortedList);

		//create and display gui 
		Date212GUI gui = new Date212GUI(); 

		//add unsorted to left side 
		Date212Node current = unsortedList.first.next;
		while (current != null) {
			if (current.data != null) {
				gui.addRawDate(current.data.toString());
			}
			current = current.next;
		}

		//add sorted to right side 
		current = sortedList.first.next; 
		while (current != null) {
			if (current.data != null) {
				gui.addSortedDate(current.data.toString());
			}
			current = current.next;
		}

		gui.setVisible(true);
	}

	//read dates from file 
	private static void readFromFile(String filename, UnsortedDate212List unsortedList, SortedDate212List sortedList) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String line = in.readLine();
			while (line != null) {
				//String Tokenizer to separate dates 
				StringTokenizer tokenizer = new StringTokenizer(line, ", ");
				while (tokenizer.hasMoreTokens()) {
					String dateStr = tokenizer.nextToken().trim();
					Date212 date = new Date212(dateStr);
					unsortedList.add(date);
					sortedList.add(date);
				}
				line = in.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filename);
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Error reading file: " + filename);
			System.exit(1);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				System.out.println("Error closing file: " + filename);
			}
		}
	}
}