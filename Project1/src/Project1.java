import javax.swing.JOptionPane; 
/******************************************************************************************
 * 
 *   Roman Numeral Application
 *   Computer Science 212, Spring 2013
 *   
 *   An input file name should be given on the command line.
 *   Its contents will be read, converted to Roman numerals, stored in an array, 
 *   sorted and printed.
 *   Invalid Roman numerals will be printed to the console and discarded.
 *   @author Gideon Glass
 *
 ******************************************************************************************/

public class Project1 {
   public static final int MAX_ROMAN_NUMERALS = 100;  
   public static void main (String[] args) {
      String inputLine;
      int arrayLength =0;
      RomanNumeral myRomanNumeral;
      RomanNumeral[] romanNumeralList = new RomanNumeral[MAX_ROMAN_NUMERALS];
      //
      //  If there is no command line argument for the file name a message will be
      //  displayed and the program terminated.
      //
      if (args.length == 0) {
         JOptionPane.showMessageDialog(null," There is no input file given on the command line.");
         System.exit(0);
      }
      // 
      //  The file is opened and each line is read, converted to a Roman Numeral and
      //  stored in the array.
      //
      TextFileInput in = new TextFileInput("project1.txt");
      inputLine = in.readLine();
      while (inputLine != null) {
         try {
             myRomanNumeral = new RomanNumeral(inputLine);
             romanNumeralList[arrayLength++] = myRomanNumeral;
         }
         catch (IllegalArgumentException iae) {
            System.out.println("Illegal Roman numeral: "+inputLine);
            
         }
         finally {
            inputLine = in.readLine();
         }
      }  // while
      //
      //   Print out all the valid Roman numerals in the order in which they were read.
      //
      for(int i=0;i<arrayLength;i++)
         System.out.println(romanNumeralList[i]+" ("+romanNumeralList[i].getDecimalValue()+")");
      //
      //  Sort the array of Roman numerals in ascending order.
      //
      RomanNumeralSort.sort(romanNumeralList, arrayLength);
      //
      //  Print out all the valid Roman numerals in ascending order.
      //
      for(int i=0;i<arrayLength;i++)
         System.out.println(romanNumeralList[i]);
      
   }  //main  
} // Project1