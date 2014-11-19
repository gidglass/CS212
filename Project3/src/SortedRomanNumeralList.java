/************************************************************************************************
 * Extended class from abstract RomanNumeralList
 * to insert nodes in ascending sorted order as they are read.
 * @author Gideon Glass
 *
 */
public class SortedRomanNumeralList extends RomanNumeralList {
   
   public void add(RomanNumeral rn){
      
      RomanNumeralNode n = new RomanNumeralNode(rn); // instantiate RN node
      
      if (first.next == null) {
         last.next = n;
         last = n;
         length++;
         return;
      } // append first node if empty list
      
      RomanNumeralNode i = first; // temporary node
      
      // find location to insert node
      while (i.next != null && i.next.data.compareTo(rn)<0)
         i = i.next;
      if (i.next == null) {
         last.next = n;
         last = n;
         length++;
      } // append to end if the location is last node
      else {
         n.next = i.next;
         i.next = n;
         length++;
      } // otherwise insert into list in the appropriate location
   
   } // add method (sorted)
   
} // class SortedRomanNumeralList