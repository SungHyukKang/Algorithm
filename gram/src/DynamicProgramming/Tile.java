package DynamicProgramming;
import java.util.*;
		
		
public class Tile {

	public long solution(int N){
		ArrayList<Long> arr2 =new ArrayList<>();
		arr2.add((long)4);
		arr2.add((long)6);
		for(int i =2;i<N;i++){
			arr2.add((long)arr2.get(i-2)+(long)arr2.get(i-1));
		}
		return arr2.get(arr2.size()-1);
	}
	
	public static void main(String[] args) {
		Tile tile = new Tile();
			
		System.out.println(tile.solution(5));
	}

}
