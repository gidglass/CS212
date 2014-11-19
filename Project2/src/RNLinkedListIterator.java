/**
 * This class creates an iterator to safely traverse the linked list without user access to pointers.
 * @author Gideon Glass
 *
 */
public class RNLinkedListIterator {
   // declare node object
   private RomanNumeralNode node;
   /**
    * Constructor to reset the iterator.
    * @param first node
    */
   public RNLinkedListIterator (RomanNumeralNode first){
      node = first;
   } // constructor
   /**
    * Determines if there is another node in the list.
    * @return true (if there is another node in list)
    * otherwise, false.
    */
   public boolean hasNext() {
      return (node != null);
   } // has next method
   /**
    * Finds the data contained in the node.
    * @return data of the node.
    */
   public RomanNumeral next() {
      if (node == null)
         throw new NullPointerException("Linked List is empty");
      RomanNumeral currentData = node.data;
      node = node.next;
      return currentData;
   } // find data of node method
   
} // class RNLinkedListIterator