/**
 * Class to sort Roman Numeral objects based on their decimal value.
 * @author Gideon Glass.
 *
 */
public class RomanNumeralSort {
   /**
    * Selection sort method using the decimal values of the Roman Numerals.
    * @param RomanNumeralArray The list of Roman Numerals read from the file and stored in an array.
    * @param size The size of the array and how many Roman Numeral Objects are being sorted.
    */
   public static void sort (RomanNumeral RomanNumeralArray[], int size){
      for (int i=0; i< size-1; i++){ // initialize lowest index value
         int lowestRN = i;
         for (int j= i+1; j<size; j++){
            if (RomanNumeralArray[j].compareTo(RomanNumeralArray[lowestRN]) < 0) // compare elements to determine lowest index
               lowestRN = j;
         } // find the lowest index in rest of array
         if (RomanNumeralArray[lowestRN] != RomanNumeralArray[i]){
            RomanNumeral temp = RomanNumeralArray[lowestRN];
            RomanNumeralArray[lowestRN] = RomanNumeralArray[i];
            RomanNumeralArray[i] = temp;
         } // swap the array element with the lowest index if there is one
      }
   }
} // Roman Numeral selection sort