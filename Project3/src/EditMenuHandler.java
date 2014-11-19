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
    * Handles the action of the event- "Add," 
    * namely prompting the user for a RN to input and adding to the respective lists.
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
            rnGUI.inOrder.add(rn);
            rnGUI.sorted.add(rn);
         }
         catch (IllegalArgumentException iae) {
            JOptionPane.showMessageDialog(null,  "Illegal Roman Numeral: " + input);
            System.out.println("Illegal Roman numeral: "+input);
         }
         rnGUI.displaySorted();
         rnGUI.displayUnsorted();
      } // Add
         
   } //actionPerformed
   
} // class EventMenuHandler