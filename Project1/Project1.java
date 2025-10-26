import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Project1 {
    public static void main(String[] args) {

    // Check if filename was provided
         if (args.length == 0) {
            System.out.println("Provide a filename. Usage: java Project1 <filename>");
            System.exit(1);
        }
    
        String filename = args[0];  
    
        // ArrayList to store Date212 objects
        ArrayList<Date212> dateObjects = new ArrayList<>();
        ArrayList<String> rawDates = new ArrayList<>(); 

        //read from file 
        readFromFile(filename, rawDates, dateObjects);

        //Sort Date212 objects with selecitonSort 
        DateGUI.selectionSort(dateObjects); 

        //Create & display GUI
        DateGUI gui = new DateGUI(); 
        
        //raw dates left 
        for (String date : rawDates) {
            gui.addRawDate(date); 
        }
        
        //add sorted to right 
        for (Date212 date : dateObjects) {
            gui.addSortedDate(date.toString()); 
        }
        gui.setVisible(true);
    }
        
    
        //read dates from file 
        private static void readFromFile (String filename, ArrayList<String> rawDates, ArrayList<Date212> dateObjects) {
            BufferedReader in = null; 
            try { 
                in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
                String line = in.readLine(); 
                
                while (line != null) {
                    //String Tokenizer to separate dates 
                    StringTokenizer tokenizer = new StringTokenizer(line, ", ");
                    while (tokenizer.hasMoreTokens()) {
                        String dateStr = tokenizer.nextToken().trim(); 
                        rawDates.add(dateStr); 
                        dateObjects.add(new Date212(dateStr)); 
                    }

                    line = in.readLine();
                }
            } 
            catch (FileNotFoundException e) {
                System.out.println("Error: " + filename + " file not found!");
                System.exit(1);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                System.exit(1);
            } finally {
                try {
                    if (in != null) in.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }

        

    
