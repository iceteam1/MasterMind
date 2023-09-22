import java.util.ArrayList;
import java.util.Arrays;
public class MasterMindBoard{
  private int[] boardList;

  /*constructor takes in a pre-made list made outside of the class, and sets the boardList to it. This allows the usage
  of a fixed board or random board*/
  public MasterMindBoard(int[] List){
    boardList = List;
  }

  //returns the board in the object
  public int[] getBoard(){
    return boardList;
  }

  //returns how many pegs are in correct spots.
  public int getCorrectPegs(int[] List){
    int output = 0;
    for(int i = 0; i < boardList.length; i++){
      if(List[i] == boardList[i]){
        output++;
      }
    }
    return output;
  }

//chatGPT created this method
public int getCorrectColours(int[] userCode) {
    int output = 0;

    // Create copies of the arrays to track matched elements
    int[] boardCopy = Arrays.copyOf(boardList, boardList.length);
    int[] userCopy = Arrays.copyOf(userCode, userCode.length);

    for (int i = 0; i < userCopy.length; i++) {
        for (int j = 0; j < boardCopy.length; j++) {
            if (userCopy[i] == boardCopy[j]) {
                // Found a correct color, mark it as matched
                userCopy[i] = -1;
                boardCopy[j] = -1;
                output++;
                break; // Exit inner loop after finding a match
            }
        }
    }

    return output;
}

}
