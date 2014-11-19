import java.awt.*;
import javax.swing.*;
/**
 * This class extends JFrame to create a GUI in which to append the linked lists.
 * @author Gideon Glass
 *
 */
public class RomanNumeralGUI extends JFrame {
   JFrame frame;
   Container myContentPane;
   TextArea unsortedList = new TextArea();
   TextArea sortedList = new TextArea();
   
   public RomanNumeralGUI (String title) {
        setTitle (title);
        setSize (400, 300);
        setLocation (100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myContentPane = getContentPane();
        myContentPane.setLayout(new GridLayout (1,2));
        myContentPane.add(unsortedList);
        myContentPane.add(sortedList);
        unsortedList.setEditable(false);
        sortedList.setEditable(false);
        setVisible(true);
   } // constructor
} // class RomanNUmeralGUI

