package Hash;

import java.util.*;

public class OpenChat {

	public String[] solution(String[] record){
		HashMap<String,String> hsmap = new HashMap<>();
		
		for(String Z : record){
			if(!Z.split(" ")[0].equals("Leave"))
				hsmap.put(Z.split(" ")[1], Z.split(" ")[2]);
		}
		ArrayList<String> arr = new ArrayList<>();
		
		for(int i = 0 ; i <record.length;i++){
			if(record[i].split(" ")[0].equals("Enter")){
				arr.add(hsmap.get(record[i].split(" ")[1])+"´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
			}else if(record[i].split(" ")[0].equals("Leave")){
				arr.add(hsmap.get(record[i].split(" ")[1])+"´ÔÀÌ ³ª°¬½À´Ï´Ù.");
			}
		}
		String[] answer = new String[arr.size()];
		int cnt = 0;
		for(String Z :arr){
			answer[cnt++]=Z;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {

		OpenChat oc = new OpenChat();
		oc.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
		
	}

}
