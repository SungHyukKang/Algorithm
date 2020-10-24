import java.util.*;

class NHN_1 {
	
  private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
	  Character[] mem = new Character[numOfAllPlayers];
	  HashMap<Character,Integer> hsmap = new HashMap<>();
	  HashMap<Character,Boolean> mujuk = new HashMap<>();
	  for(int i =0;i<numOfAllPlayers-1;i++) {
		  mem[i]=(char)('B'+i);
		  hsmap.put(mem[i],0);
		  mujuk.put(mem[i],false);
	  }
	  
	  int N =numOfAllPlayers-1;
	  for(int i =0 ;i<numOfQuickPlayers;i++) {
		  mujuk.put(namesOfQuickPlayers[i],true);
	  }
	  mujuk.put('A',false);
	  int pre=0;
	  hsmap.put('A',1);
	  char sulae='A';
	  for(int i = 0;i<numOfMovesPerGame.length;i++) {
		  if(numOfMovesPerGame[i]>0) {
			  pre=(pre+numOfMovesPerGame[i])%N;
			  int X = pre;
			  if(mujuk.get(mem[X])) {
				  hsmap.put(sulae,hsmap.get(sulae)+1);
			  }else {
				  char temp =mem[X];
				  mem[X]=sulae;
				  sulae=temp;
				  hsmap.put(sulae,hsmap.get(sulae)+1);
			  }
		  }
		  else {
			  pre=(pre+N-Math.abs(numOfMovesPerGame[i]))%N;
			  int X = pre;
			  if(mujuk.get(mem[X])) {
				  hsmap.put(sulae,hsmap.get(sulae)+1);
			  }else {
				  char temp =mem[X];
				  mem[X]=sulae;
				  sulae=temp;
				  hsmap.put(sulae,hsmap.get(sulae)+1);
			  }
		  }
	  }
	  for(int i =0;i<mem.length-1;i++) {
		  System.out.println(mem[i]+" "+hsmap.get(mem[i]));
	  }
	  	System.out.println(sulae+" "+hsmap.get(sulae));
  }

  private static class InputData {
    int numOfAllPlayers;
    int numOfQuickPlayers;
    char[] namesOfQuickPlayers;
    int numOfGames;
    int[] numOfMovesPerGame;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
      System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

      inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.numOfMovesPerGame = new int[inputData.numOfGames];
      String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
      for(int i = 0; i < inputData.numOfGames ; i++){
        inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
  }
}