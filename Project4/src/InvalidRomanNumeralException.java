/************************************************************************************************
 * Extends IllegalArgumentException and creates an exception to be be thrown when an 
 * Invalid Roman Numeral is read-in/entered by the user.
 * @author Gideon Glass
 *
 */
public class InvalidRomanNumeralException extends IllegalArgumentException {
   public InvalidRomanNumeralException (String message) {
      super(message);
   }
} // class InvalidRomanNumeralException extension