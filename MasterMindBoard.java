import java.util.ArrayList;
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

  /*creates an arrayList and fills it with each new colour that isn't a 
  duplicate. The outputs the length*/
  public int getCorrectColours(int[] List){
    ArrayList<Integer> cList = new ArrayList<Integer>(); //creates an empty arraylist that will have each correct colour in it when the code executes.
    for(int i = 0; i < List.length; i++){
      if(!(cList.contains(List[i]))){
        cList.add(List[i]);
      }
    }
    return cList.size();
  }

}
