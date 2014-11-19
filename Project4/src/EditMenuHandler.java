import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
/************************************************************************************************
 * Handles the action taken when an event takes place in the Edit menu of the RomanNumeralGUI.
 * @author Gideon Glass
 *
 */
public class EditMenuHandler implements ActionListener {
   
   RomanNumeralGUI rnGUI; // instantiate object
   
   /************************************************************************************************
    * Pass RomanNumeralGUI object in and allow access to public methods.
    */
   public EditMenuHandler (RomanNumeralGUI rn) {
      rnGUI = rn;
   
   } // constructor
   
   /************************************************************************************************
    * Handles the action of the events- "Add" and "Delete," 
    * namely prompting the user for a RN/Arabic number to input and adding to or
    * deleting from the respective lists.
    * The modified lists are then displayed to reflect the changes.
    */
   public void actionPerformed(ActionEvent event) {
      
      String menuName = event.getActionCommand();
      String input;
      
      // if clicked "Add," prompt user for input dialog
      // and if valid RN, add it to each list,
      // then display the list to reflect the addition
      if (menuName.equals("Add")) {
         input = JOptionPane.showInputDialog(null,"Enter a Roman Numeral to add:"); 
         try {
            RomanNumeral rn = new RomanNumeral(input);
            rnGUI.rnList.add(rn);
         }
         catch (InvalidRomanNumeralException iae) {
            JOptionPane.showMessageDialog(null,  "Invalid Roman Numeral: " + input);
            System.out.println("Invalid Roman Numeral: "+input);
         }
         
         rnGUI.displayUnsorted();
      } // Add
      
      // if clicked "Delete," prompt user for input dialog
      // and if valid index, delete it from the list,
      // then display the list to reflect the deletion
      if (menuName.equals("Delete")) {
      // clear lists
         rnGUI.unsortedList.setText("");
         rnGUI.sortedList.setText("");
      // reset iterator to traverse the list
         rnGUI.rnli = rnGUI.rnList.listIterator(0);
      // fill left column of GUI with unsortedList
         for (int i=0; i <rnGUI.rnList.size(); i++)
            rnGUI.unsortedList.append( i + ":   " + (rnGUI.rnList.get(i)) + "\n");
         
         input = JOptionPane.showInputDialog(null,  "Choose index of Roman Numeral to delete:");
         try {
            rnGUI.rnList.remove(Integer.parseInt(input));
         }
         catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null, "Invalid index.");
         }
         catch (IndexOutOfBoundsException ioobe) {
            JOptionPane.showMessageDialog(null, "Index out of bounds");
         }
         finally {
         // clear list
            rnGUI.unsortedList.setText("");
         // reset iterator to traverse the list
            rnGUI.rnli = rnGUI.rnList.listIterator(0);
         // fill left column of GUI with unsortedList
            for (int i=0; i <rnGUI.rnList.size(); i++)
               rnGUI.unsortedList.append( i + ":   " + (rnGUI.rnList.get(i)) + "\n");
         }
      }
         
   } //actionPerformed
   
} // class EventMenuHandler