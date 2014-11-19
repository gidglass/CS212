/************************************************************************************************
 * This class constructs the Roman Numeral Nodes for use in linked lists.
 * @author Gideon Glass
 *
 */
public class RomanNumeralNode {
   // declare Roman Numeral object
   RomanNumeral data;
   // declare RomanNumeralNode "next"
   RomanNumeralNode next;
   
   /************************************************************************************************
    * Constructor for class RomanNumeralNode instantiates the node for use in linked lists.
    * @param rn
    */
   public RomanNumeralNode(RomanNumeral rn) {
      data = rn;
      next = null;
   } // constructor 
   
} // class RomanNumeralNode