package noCategory;
import java.util.*;
public class FourBlock {

	public int solution(int m , int n , String[] board){
		ArrayList<Character> arr = new ArrayList<>();
		
		for(String t : board){
			for(int i = 0;i<n;i++){
				arr.add(t.charAt(i));
			}
		}
		int a =-1;
		int b =-1;
		
		System.out.println(arr);
		
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		FourBlock fb = new FourBlock();
		fb.solution(4, 5,new String[]{"CCBDE","AAADE","AAABF","CCBBF"} );
		
		
	}

}
