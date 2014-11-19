import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/************************************************************************************************
 * Handles the action taken when an event takes place in the Display menu of the RomanNumeralGUI.
 * @author Gideon Glass
 *
 */
public class DisplayMenuHandler implements ActionListener {
   
   RomanNumeralGUI rnGUI; // instantiate object 
   
   /************************************************************************************************
    * Pass RomanNumeralGUI object in and allow access to public methods.
    */
   public DisplayMenuHandler (RomanNumeralGUI rn) {
      rnGUI = rn;
   
   } // constructor 
   
   /************************************************************************************************
    * Handles the action of each event- "Unsorted" and "Sorted,"
    * namely displaying each list in their respective column of the GUI.
    */
   public void actionPerformed(ActionEvent event) {
      
      String menuName = event.getActionCommand();
      
      // if clicked "Unsorted," display the unsorted list in left column
      if (menuName.equals("Unsorted")) 
         rnGUI.displayUnsorted();
      
      
      // if clicked "Sorted," display the sorted list in right column
      else if (menuName.equals("Sorted")) 
         rnGUI.displaySorted();
   
   } //actionPerformed
   
} // class DisplayMenuHandler