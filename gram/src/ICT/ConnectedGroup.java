package ICT;
import java.util.*;
public class ConnectedGroup {

	public static int countGroups(List<String> related) {
		StringBuilder sb =new StringBuilder();
		int cnt =0;
		
		return cnt;
	    }
	
	public static void main(String[] args) {
		List<String> related= new ArrayList<>();
//		//
		related.add(new String("1000001000"));
		related.add(new String("0100010001"));
		related.add(new String("0010100000"));
		related.add(new String("0001000000"));
		related.add(new String("0010100000"));
		related.add(new String("0100010000"));
		related.add(new String("1000001000"));
		related.add(new String("0000000100"));
		related.add(new String("0000000010"));
		related.add(new String("0100000001"));
		
		
		System.out.println(ConnectedGroup.countGroups(related));
	}

}
