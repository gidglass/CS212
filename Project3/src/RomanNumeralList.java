/************************************************************************************************
 * This class constructs linked lists of RomanNumeralNodes by either appending or inserting (in ascending sorted order).
 * @author Gideon Glass
 *
 */
public abstract class RomanNumeralList {
   
   // declare first node, last node and length count
   RomanNumeralNode ln = new RomanNumeralNode(null);
   protected RomanNumeralNode first = ln; // protected so can be accessed from extending classes
   protected RomanNumeralNode last = ln; // protected so can be accessed from extending classes
   protected int length = 0; // protected so can be accessed from extending classes
   
   /************************************************************************************************
    * Constructor for a Roman Numeral list
    */
   public RomanNumeralList(){
   } // constructor
   
   /************************************************************************************************
    * Abstract add method.  The extending classes utilize add for their respective purposes.
    * @param rn
    */
   abstract void add(RomanNumeral rn);
   
   /************************************************************************************************
    * Find the length of the nodes associated with the list.
    * @return Size of the list (number of nodes).
    */
   public int getLength(){
      return length;
   } // get length of list method
   
   /************************************************************************************************
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
   
   /************************************************************************************************
    * Override of inherited method from class Object.
    */
   public boolean equals(Object other){
      if(other==null || getClass()!=other.getClass() || length!=((RomanNumeralList)other).length)
         return false;
      RomanNumeralNode p=first.next;
      RomanNumeralNode q=((RomanNumeralList)other).first.next;
      for(int i=0;i<length;i++){
         if(p.data!=q.data)  return false;
         p=p.next;
         q=q.next;
      }
      return true;
   }//equals method
   
   /************************************************************************************************
    * Creates an iterator for the linked list to traverse the list safely without access to pointers by the user.
    * @return
    */
   public RNLinkedListIterator reset() {
      return new RNLinkedListIterator(first.next);
   }  // reset iterator method

} // class RomanNumeralList
