/************************************************************************************************
 * This class manages the input, output, evaluation, and comparison of Roman Numeral values.
 * @author Gideon Glass
 *
 */
public class RomanNumeral {
   
   private String RN; //set RN object
   
   /************************************************************************************************
    * Constructor for the class RomanNumeral checks validity of the input and throws exception if invalid.
    * @param rn The input String.
    * @throws java.lang.IllegalArgumentException if invalid input.
    */
   public RomanNumeral (String rn){
      for (int i=0; i< rn.length(); i++){
         char c = rn.charAt(i);
         if (c!='M' && c!='D' && c!='C' && c!='L' && c!='X' && c!='V' && c!='I')
            throw new IllegalArgumentException("Invalid Roman Numeral");
      } // checks conditions
         RN = rn;
   } // constructor
   
   /************************************************************************************************
    * The "get" method to return the private RomanNumeral object, RN.
    * @return RN
    */
   public String getRomanNumeral() {
      return RN;
   } //get method
   
   /************************************************************************************************
    * Convert RomanNumeral to a String, which overrides the toString method of class Object.
    * @return RN as a String.
    */
   public String toString() {
      return RN;
   } // overwritten toString method
   
   /************************************************************************************************
    * Method finds the value of a single RomanNumeral character using a switch statement.
    * @param rn Individual RomanNumeral characters.
    * @return The decimal value of the single character.
    */
   public int getSingleValue(char rn){
      switch (rn){
         case 'I':  return 1;
         case 'V':  return 5;
         case 'X':  return 10;
         case 'L':  return 50;
         case 'C':  return 100;
         case 'D':  return 500;
         case 'M':  return 1000;
         default: return 0;
      } // legend of the decimal values of single RN characters
   } // single character decimal value
   
   /************************************************************************************************
    * Using the single character values of getSingleValue(), this method evaluates the total decimal value of each RomanNumeral object.
    * @return The resulting total value of the RN.
    */
   public int getDecimalValue() {
      int result= getSingleValue(RN.charAt(RN.length()-1)); // set farthest right RN char decimal value
      for (int i = RN.length()-2; i>-1; i--){
         if (getSingleValue(RN.charAt(i)) < getSingleValue(RN.charAt(i+1))) // if left char is less than right, subtract decimal value
            result-= getSingleValue(RN.charAt(i));
         else
            result+= getSingleValue(RN.charAt(i)); // if left char is greater, then add value to result
      } 
      return result;
   } // find value of each Roman Numeral
   
   /************************************************************************************************
    * Compares the decimal values of two RomanNumeral objects and determines.
    * @param rn 
    * @return The difference in value (positive or negative) between the two RomanNumeral objects being compared.
    */
   public int compareTo(RomanNumeral rn){
      return getDecimalValue() - rn.getDecimalValue(); // returns either positive or negative value
   } //compare method
   
   /************************************************************************************************
    * Overwrites the class Object equals() method and tests the equality of two RomanNumeral objects.
    * @param rn
    * @return True if the two RomanNumeral objects are equal in decimal value, otherwise false.
    */
   public boolean equals(RomanNumeral rn) {
      if (getDecimalValue() == rn.getDecimalValue())
         return true;
      else 
         return false;
   } // equals method
   
} //class RomanNumeral
   

