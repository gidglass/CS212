import java.awt.*;
import java.util.*;
import javax.swing.*;
/************************************************************************************************
 * This class extends JFrame to create a GUI in which to append the linked lists.
 * The GUI has three menus with options to open a file, exit, add a new RN, or choose which list to display.
 * @author Gideon Glass
 *
 */
public class RomanNumeralGUI extends JFrame {
   
   // instantiate necessary objects:
   LinkedList<RomanNumeral> rnList =  new LinkedList<RomanNumeral>();
   ListIterator<RomanNumeral> rnli;
   Container myContentPane; // content pane to place text areas into 
   TextArea unsortedList = new TextArea(); // text area designated for the unsorted list
   TextArea sortedList = new TextArea(); // text area designated for the sorted list
   JMenuBar menuBar  = new JMenuBar(); // menu bar to place the respective menus (File, Edit, Display)
   
   /************************************************************************************************
    * Constructor for RomanNumeralGUI object.  It sets the size, title, location, layout, and operations of the GUI.
    * A content pane container is created and two text areas are added to it in a GridLayout.
    * A menu bar is instantiated with three menus: File, Edit, Display (and respective menu items).
    * Respective menu handlers are called when each menu item is clicked on by the user (event-action).
    * @param title 
    */
   public RomanNumeralGUI (String title) {
      
        setTitle (title);
        setSize (400, 300);
        setLocation (100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        unsortedList.setEditable(false);
        sortedList.setEditable(false);
        
        myContentPane = getContentPane();
        myContentPane.setLayout(new GridLayout (1,2)); // define layout with 1 row, 2 columns
        myContentPane.add(unsortedList,0); // add unsorted list text area to the left column
        myContentPane.add(sortedList,1); // add sorted list text area to the right column
        
        
        createFileMenu(menuBar);
        createEditMenu(menuBar);
        createDisplayMenu(menuBar);
        
        setVisible(true);
        
   } // constructor
   
   /************************************************************************************************
    * Creates a FIle Menu to place into the menu bar of the GUI.  
    * Contains two menu items, "Open" (which prompts to open a file) and "Exit" (which quits the program).
    * @param menuBar
    */
   private void createFileMenu(JMenuBar menuBar) {
      JMenuItem item;
      JMenu fileMenu = new JMenu("File");
      FileMenuHandler fmh  = new FileMenuHandler(this);

      item = new JMenuItem("Open");    //Open
      item.addActionListener(fmh);
      fileMenu.add( item );

      fileMenu.addSeparator();  //add a horizontal separator line
    
      item = new JMenuItem("Exit"); //Exit
      item.addActionListener( fmh );
      fileMenu.add( item );

      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
    
   } //createFileMenu
   
   /************************************************************************************************
    * Creates an Edit Menu to place into the menu bar of the GUI.  
    * Contains one menu items, "Add" 
    * (which prompts the user to input a RN and adds it appropriately to each list respectively).
    * @param menuBar
    */
   private void createEditMenu (JMenuBar menuBar) {
      JMenuItem item;
      JMenu fileMenu = new JMenu("Edit");
      EditMenuHandler emh  = new EditMenuHandler(this);

      item = new JMenuItem("Add");    // Add
      item.addActionListener( emh );
      fileMenu.add( item );
      
      item = new JMenuItem("Delete");    // Delete
      item.addActionListener( emh );
      fileMenu.add( item );

      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
    
   } //createEditMenu
   
   /************************************************************************************************
    * Creates a Display Menu to place into the menu bar of the GUI.  
    * Contains two menu items, "Unsorted" (which displays the unsorted list) 
    * and "Sorted" (which displays the sorted list).
    */
   private void createDisplayMenu(JMenuBar menuBar) {
      JMenuItem item;
      JMenu fileMenu = new JMenu("Display");
      DisplayMenuHandler dmh  = new DisplayMenuHandler(this);

      item = new JMenuItem("Unsorted");    //Unsorted
      item.addActionListener( dmh );
      fileMenu.add( item );

      fileMenu.addSeparator(); //add a horizontal separator line
    
      item = new JMenuItem("Sorted");       //Sorted
      item.addActionListener( dmh );
      fileMenu.add( item );

      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
    
   } //createDisplayMenu
   
   /************************************************************************************************
    * Utilizes an iterator to traverse the unsorted list and display to the GUI 
    * when called (by the DisplayMenuHandler and EditMenuHandler).
    */
   public void displayUnsorted() {
      // clear lists
      sortedList.setText("");
      unsortedList.setText("");
      // reset iterator to traverse the list
      rnli = rnList.listIterator(0);
      // fill left column of GUI with unsortedList
      for (int i=0; i <rnList.size(); i++)
         unsortedList.append((rnList.get(i)) + "\n");
   
   } // displayUnsorted method
   
   /************************************************************************************************
    * Utilizes an iterator to traverse the sorted list and display to the GUI 
    * when called (by the DisplayMenuHandler and EditMenuHandler).
    */
   public void displaySorted() {
      // clear lists
      sortedList.setText("");
      unsortedList.setText("");
      
      LinkedList <RomanNumeral> sl = new LinkedList <RomanNumeral> (rnList);

      Collections.sort(sl);
      rnli = sl.listIterator(0);
      for (int i= 0; i<sl.size(); i++)
         sortedList.append((sl.get(i)) + "\n");
   } // displaySorted method
   
   
} // class RomanNUmeralGUI

