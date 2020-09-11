package Hash;
import java.util.*;
public class Archive {

	public int[] solution(String msg){
		HashMap<String,Integer> hsmap = new HashMap<>();
		ArrayList<Integer> arr =new ArrayList<>();
		LinkedList<String> msgCopy = new LinkedList<>();
		for(int i = 0;i<msg.length();i++){
			msgCopy.add(Character.toString(msg.charAt(i)));
		}
		for(int i = 0 ;i<26;i++){
			hsmap.put(Character.toString((char) ('A'+i)),i+1);
		}
		String x =null;
		String y = null;
		int length = 0;
		int z =0;
		z=msg.length()-1;
		while(length!=msg.length()){
			x=msgCopy.poll();
			z--;
			length++;
			y=msgCopy.peek();
			if(!hsmap.containsKey(x+y))
				arr.add(hsmap.get(x));
			if(!hsmap.containsKey((x+y))){
				hsmap.put(x+y, hsmap.size()+1);
				msgCopy.add(x+y);
			}else{
				y=msgCopy.poll();
				msgCopy.push(x+y);
				
			}
			if(z==0){
				arr.add(hsmap.get(msgCopy.peek()));
				break;
			}
		}	
		int[] answer = new int[arr.size()];
		int cnt=0;
		for(int X : arr){
			answer[cnt++]=X;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Archive ar = new Archive();
		
		ar.solution("THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS");
		

	}

}
