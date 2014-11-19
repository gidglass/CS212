/**
 * This class constructs linked lists of RomanNumeralNodes by either appending or inserting (in ascending sorted order).
 * @author Gideon Glass
 *
 */
public class RomanNumeralList {
   // declare first node, last node and length count
   RomanNumeralNode ln = new RomanNumeralNode(null);
   private RomanNumeralNode first = ln;
   private RomanNumeralNode last = ln;
   private int length = 0;
   
   public RomanNumeralList(){
   } // constructor
   
   public int getLength(){
      return length;
   } // get length of list method
   
   /**
    *Appends the data into a linked list in the order that they are given. 
    * @param rn RomanNumeral object
    */
   public void append (RomanNumeral rn) {
      RomanNumeralNode n = new RomanNumeralNode(rn);
      last.next = n;
      last = n;
      length++;
   } // append method
   /**
    * Inserts the data into a linked list in ascending sorted order.
    * @param rn RomanNumeral object.
    */
   public void insert(RomanNumeral rn){
      RomanNumeralNode n = new RomanNumeralNode(rn);
      if (first.next == null) {
         last.next = n;
         last = n;
         length++;
         return;
      } // append first node
      
      RomanNumeralNode i = first;
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
   } // insert method
   /**
    * Returns a String containing the data of each node of the list separated with new line (\n).
    */
   public String toString(){
      RomanNumeralNode p = first.next;
      String returnString = "";
      while (p!=null){
         returnString+=p.data + "\n";
         p = p.next;
      }
      return returnString;
   } // to string method
   /**
    * Override of inherited method from class Object.
    */
   public boolean equals(Object other) {
      if (other == null || getClass() != other.getClass()
              || length != ((RomanNumeralList) other).length)
          return false;

      RomanNumeralNode nodeThis = first;
      RomanNumeralNode nodeOther = ((RomanNumeralList) other).first;
      while (nodeThis != null) {
          // Since the two linked lists are the same length,
          // they should reach null on the same iteration.

          if (nodeThis.data != nodeOther.data)
              return false;

          nodeThis = nodeThis.next;
          nodeOther = nodeOther.next;
      } // while
      return true;
   } // method equals
   /**
    * Creates an iterator for the linked list to traverse the list safely without access to pointers by the user.
    * @return
    */
   public RNLinkedListIterator reset() {
      return new RNLinkedListIterator(first.next);
   }  // reset iterator method

} // class RomanNumeralList
