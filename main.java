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

    //Fixed list and variables (Remove later)
    int[] TestBoard = {1,2,3,4,5};
    int listSize = 5; //size of list
    int listRange = 5;// Max value of colour range starting at 0
    int[] RandomBoard = new int[listSize];
    int numElement = 5;
    for (int i = 0; i < numElement; i++); {
      int randomIndex = (int)(Math.random() * listRange);
      int randomElement = TestBoard[randomIndex];
      System.out.println(randomIndex);
    }
    
    
    
    MasterMindBoard m = new MasterMindBoard(TestBoard);

    Scanner input = new Scanner(System.in);
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
      }else{
        //outputs how much pegs are in the correct spot and colour
        System.out.println("Pegs Correct: " + m.getCorrectPegs(userCode));
        System.out.println("Correct Colours: " + m.getCorrectColours(userCode));
      }
        
    }
  }//end main
}//end class
