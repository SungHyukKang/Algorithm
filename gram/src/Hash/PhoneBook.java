package Hash;

import java.util.*;
public class PhoneBook {

	public boolean solution(String[] phone_book){
		HashMap<Integer,String> hsmap =new HashMap<>();
		int cnt =0;
		for(String t : phone_book){
			hsmap.put(cnt++, t);
		}
		for(int i = 0 ;i<hsmap.size();i++){
			for(int j = 0 ;j<hsmap.size();j++){
				System.out.println("!");
				if(i!=j&&hsmap.get(i).length()<=phone_book[j].length()){
					if(hsmap.get(i).startsWith(phone_book[j])){
						return false;
					}
				}
					
			}
		}
		return true;
	}
	public static void main(String[] args) {
		PhoneBook pb =new PhoneBook();
		System.out.println(pb.solution(new String[]{"444","451","12344451"}));	
	}
}