import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Date212GUI extends JFrame {
    private JTextArea rawArea;
    private JTextArea sortedArea;

    public Date212GUI () {
        //set up frame
        setTitle("Date Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));
        setSize(600,400); 
        
        //content panel with titles 
        JPanel rawContentPanel = new JPanel(new BorderLayout()); 
        TitledBorder rawTitle = BorderFactory.createTitledBorder("Original Format");
        rawContentPanel.setBorder(rawTitle);

        JPanel sortedContentPanel = new JPanel(new BorderLayout());
        TitledBorder sortedTitle = BorderFactory.createTitledBorder("Sorted Dates (Earliest to Latest)");
        sortedContentPanel.setBorder(sortedTitle);

        //create text areas
        rawArea = new JTextArea();
        rawArea.setEditable(false);
        JScrollPane rawScroll = new JScrollPane(rawArea); 

        sortedArea = new JTextArea();
        sortedArea.setEditable(false);
        JScrollPane sortedScroll = new JScrollPane(sortedArea); 

        //add text areas to content panels
        rawContentPanel.add(rawScroll);
        sortedContentPanel.add(sortedScroll);

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

}
