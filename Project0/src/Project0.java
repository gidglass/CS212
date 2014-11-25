import javax.swing.*;

// CS212 Java: Project 0 by Gideon Glass
	
public class Project0  { 
   public static int checkLetters (String wordInput, int correctLetters){
      // The loop scans the string for valid Roman Numeral characters
      for (int i=0; i < wordInput.length(); i++){ 
         int letter= wordInput.charAt(i);
         // Check conditions
         if (letter == 'M' || letter == 'D' || letter == 'C' || letter == 'L' || letter == 'X' || letter == 'V' || letter == 'I')
            correctLetters++; // If a match was found, increment the count of matching letters.
      }
      return correctLetters; 
      // Return the count value of correct letters found by the above condition.
   }
   
   public static void main (String[] args) {
   // Loop main method infinitely until a break condition is met.
      while (true){	
         int correctCount=0;
         String inputWord= JOptionPane.showInputDialog(null, "Please enter a Roman Numeral:"); //Prompt user
         correctCount=checkLetters(inputWord, correctCount); // Call method to check conditions
		
      // If the user inputs "stop," in any combination of upper or lower case, the program exits
         if (inputWord.equalsIgnoreCase("STOP"))
            return;
      // Error count equals the array length minus correct count.  If equals zero, then error free.
         if(inputWord.length() - correctCount==0)
            JOptionPane.showMessageDialog(null, inputWord + " has no errors.");
      // Otherwise, the difference represents the number of errors  
         else if (inputWord.length() - correctCount==1)
            JOptionPane.showMessageDialog(null, inputWord + " has " + (inputWord.length() - correctCount) + " error.");
         else
            JOptionPane.showMessageDialog(null, inputWord + " has " + (inputWord.length() - correctCount) + " errors.");
      }
   }
}
