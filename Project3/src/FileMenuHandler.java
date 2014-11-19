import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
/************************************************************************************************
 * Handles the action taken when an event takes place in the File menu of the RomanNumeralGUI.
 * @author Gideon Glass
 *
 */
public class FileMenuHandler implements ActionListener {
   
   RomanNumeralGUI rnGUI; // instantiate object
   
   /************************************************************************************************
    * Pass RomanNumeralGUI object in and allow access to public methods.
    */
   public FileMenuHandler (RomanNumeralGUI rn) {
      rnGUI = rn;
   
   } // constructor
   
   /************************************************************************************************
    * Handles the action of each event- "Open" and "Exit," 
    * namely opening a file chooser and quitting the program respectively.
    */
   public void actionPerformed(ActionEvent event) {
      
      String menuName = event.getActionCommand();
      
      // if clicked "Open," display a file chooser
      // then prompt user to choose a display (from the display menu) of the file we just opened
      if (menuName.equals("Open")) {
         openFile(); 
         JOptionPane.showMessageDialog(null, "Select a Display option. \nDisplay > Sorted/Unsorted "); 
      }
      
      // if clicked "Exit," quit the program
      else if (menuName.equals("Exit"))
          System.exit(0);
      
   } //actionPerformed
   
   /************************************************************************************************
    * Display a file chooser with a file filter to limit the user to text files.
    * If valid ("file.txt"), call the readSource method and read file.
    */
   private void openFile(){
      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt"); // filter to only .txt files 
      chooser.setFileFilter(filter);
      int returnVal = chooser.showOpenDialog(null);
      if(returnVal == JFileChooser.APPROVE_OPTION) // if condition set by filter is met
         readSource(chooser.getSelectedFile()); // read file
      
   } // openFile method
   
   /************************************************************************************************
    * Read in from text file and add them to respective lists (sorted and unsorted).
    * @param selectedFile
    */
   private void readSource(File selectedFile) {
      TextFileInput in = new TextFileInput(selectedFile.toString());
      String inputLine = in.readLine();
      while (inputLine != null) {
         try {
             RomanNumeral rn = new RomanNumeral(inputLine);
             rnGUI.inOrder.add(rn); // create inOrder list
             rnGUI.sorted.add(rn); // create sorted list
         }
         catch (IllegalArgumentException iae) {
            System.out.println("Illegal Roman numeral: "+inputLine);
            
         }
         finally {
            inputLine = in.readLine();
         }
      }  // while
      
   } // readSource method

} // class FileMenuHandler