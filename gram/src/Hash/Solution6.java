package Hash;

import java.util.*;
import java.util.Map.Entry;

public class Solution6 {
	public static String Solution(String[] participant , String[] completion){
		String answer="";
		HashMap<String,Integer> hsmap = new HashMap<>();
		for(String part : participant){
			hsmap.put(part,hsmap.getOrDefault(part,0)+1);
			System.out.println(part+","+(hsmap.getOrDefault(part,0)+1));
		}
		
		for(String comp:completion){
			hsmap.put(comp,hsmap.get(comp)-1);
			System.out.println(comp+","+(hsmap.get(comp)-1));
		}
		for(Entry<String, Integer> key : hsmap.entrySet()){
			if(key.getValue()!=0)
				answer = key.getKey();
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String[] participant={"mislav","stanko","mislav","ana"};
		String[] completion={"stanko","ana","mislav"};
		System.out.println(Solution6.Solution(participant, completion));
		

	}

}


/*
 * List<String> lr = new ArrayList<String>();
		for(String part : participant){
			lr.add(part);
		}
		int count = 0;
		for(String part : completion){
			if(completion[count++].equals(part)){
				lr.remove(part);
			}
		}
		String answer=lr.toString().replace("[","").replace("]","");
		
 * 
 * */
 /*
	Arrays.sort(participant);
		Arrays.sort(completion);
		int i =0;
		for(i = 0 ;i<completion.length;i++){
			if(!participant[i].equals(completion[i])){
				return participant[i];
			}
			
		}
		return participant[i];
*/