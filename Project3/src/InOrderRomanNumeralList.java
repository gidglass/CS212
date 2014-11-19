/************************************************************************************************
 * Extended class from abstract RomanNumeralList
 * to append nodes to the end of a list (unsorted- as they are read).
 * @author Gideon Glass
 *
 */
public class InOrderRomanNumeralList extends RomanNumeralList {
   
   public void add (RomanNumeral rn) {
      RomanNumeralNode n = new RomanNumeralNode(rn);
      last.next = n;
      last = n;;
      length++;
   } // add method (unsorted)
   
} // class InOrderRomanNumeralList