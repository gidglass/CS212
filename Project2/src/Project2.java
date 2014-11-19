/**
 * CS212: Project 2 (main).
 * The program instantiates two linked lists, one sorted, one not, and appends each to two respective columns in a GUI.
 * @author Gideon Glass
 *
 */
public class Project2 {
   public static void main(String[] args){
      // declare each list
      RomanNumeralList inOrder, sorted;
      // declare an iterator
      RNLinkedListIterator rnIterator;
      // create the empty lists
      inOrder = new RomanNumeralList();
      sorted = new RomanNumeralList();
      
      // read in RN data from file
      TextFileInput in = new TextFileInput(args[0]);
      String inputLine = in.readLine();
      while (inputLine != null) {
         try {
             RomanNumeral rn = new RomanNumeral(inputLine);
             inOrder.append(rn); // create inOrder list
             sorted.insert(rn); // create sorted list
         }
         catch (IllegalArgumentException iae) {
            System.out.println("Illegal Roman numeral: "+inputLine);
            
         }
         finally {
            inputLine = in.readLine();
         }
      }  // while
      
      // reset iterator to traverse the list
      rnIterator = inOrder.reset();
      // create GUI object
      RomanNumeralGUI myRNGUI = new RomanNumeralGUI("Project 2");
      // fill left column of GUI with unsortedList
      while (rnIterator.hasNext()) 
         myRNGUI.unsortedList.append(rnIterator.next() + "\n");
      // reset iterator to traverse list
      rnIterator = sorted.reset();
      // fill right column of GUI with sortedList
      while (rnIterator.hasNext())
           myRNGUI.sortedList.append(rnIterator.next() + "\n");       
   } // main
} // class Project2