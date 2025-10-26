import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class DateGUI extends JFrame {
    private JTextArea rawArea;
    private JTextArea sortedArea;

    public DateGUI () {
        //set up frame
        setTitle("Date Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));
        setSize(600,400); 
        
        //contentpanel with titles 
        JPanel rawContentPanel = new JPanel(new GridLayout (1,1)); 
        TitledBorder rawTitle = BorderFactory.createTitledBorder("Original Format");
        rawContentPanel.setBorder(rawTitle);

        JPanel sortedContentPanel = new JPanel(new GridLayout(1,1));
        TitledBorder sortedTitle = BorderFactory.createTitledBorder("Sorted Dates (Earliest to Latest)");
        sortedContentPanel.setBorder(sortedTitle);

        //create text areas
        rawArea = new JTextArea();
        rawArea.setEditable(false);
        sortedArea = new JTextArea();
        sortedArea.setEditable(false);

        //add text areas to content panels
        rawContentPanel.add(rawArea);
        sortedContentPanel.add(sortedArea);

        //add frame 
        add(rawContentPanel); 
        add(sortedContentPanel); 

        setLocationRelativeTo(null);

    } 

    //Add raw date
    public void addRawDate (String date) {
        rawArea.append(date + "\n");
    }

    //Add a sorted date 
    public void addSortedDate (String date) {
        sortedArea.append(date + "\n");
    }

    //Selection Sort 
    public static void selectionSort (ArrayList<Date212> dates) {
        for (int i = 0; i < dates.size() - 1; i++) {
            int min= i; 
            for (int j= i+1; j < dates.size(); j++) {
                if (dates.get(j).compareTo(dates.get(min))< 0) {
                    min = j;
                }
            }
            //swap
            Date212 temp = dates.get(i); 
            dates.set(i, dates.get(min));
            dates.set(min, temp);
        }
    }

}
