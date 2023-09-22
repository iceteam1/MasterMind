import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;
class Main {
  //makes the user enter an input between a certain pair of numbers
  public static int inputRange(int min, int max, Scanner input){
    boolean validating = true;
    int userInput = 0;
    while(validating){
      userInput = input.nextInt();
      if(userInput <= max && userInput >= min){
        validating = false;
      }else{
        System.out.println("Input out of range");
      }
    }
    return userInput;
  }

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the size of your list (3-8): ");
    int listSize = inputRange(3, 8, input); 

    System.out.print("Enter the number range for your pegs (2 - 9)");
    int listRange = inputRange(2, 9, input);
    
    int[] randomBoard = new int[listSize];
    
    for (int i = 0; i < listSize; i++) {
      int randomIndex = (int)(Math.random() * listRange);
      randomBoard[i] = randomIndex;
    }
    
    //System.out.println(Arrays.toString(randomBoard));
    
  
    MasterMindBoard m = new MasterMindBoard(randomBoard);

    int guesses = 1;
    boolean inGame = true;
    int[] userCode = new int[listSize];
    while(inGame){
      System.out.print("Enter the numbers in your board separated by spaces: ");
      //takes in a list of integers separated by spaces within 0 and a selected max
      for(int i = 0; i < userCode.length; i++){
        userCode[i] = inputRange(0,listRange,input);
      }
      
      //checks if the code the user entered is correct. 
      if(Arrays.equals(userCode, m.getBoard())){
        inGame = false;
        break;
        
      }else{
        //outputs how much pegs are in the correct spot and colour
        System.out.println("Pegs Correct: " + m.getCorrectPegs(userCode));
        System.out.println("Correct Colours: " + m.getCorrectColours(userCode));
        
        guesses++;
      }
        
    }
  System.out.println("You broke the code in " + guesses + " guesses.");
  input.close();
  
  }//end main
}//end class
