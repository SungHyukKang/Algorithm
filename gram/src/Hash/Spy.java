package Hash;

import java.util.*;

public class Spy {

	public int solution(String[][] clothes){
		int answer=1;
		HashSet<String> hsset = new HashSet<>();
		for(int i =0;i<clothes.length;i++)
			hsset.add(clothes[i][1]);
		String[] li = new String[hsset.size()];
		ArrayList<Integer> arr = new ArrayList<>();
		int x = 0;
		for(String z : hsset){
			li[x]=z;
			System.out.println(li[x]);
			x++;
		}
		int cnt=0;
		for(int i = 0 ;i<hsset.size();i++){
			for(int j =0;j<clothes.length;j++){
				if(li[i].equals(clothes[j][1])){
					cnt++;
				}
			}
			arr.add(cnt);
			cnt=0;
		}
		for(int X : arr){
			answer*=(X+1);
		}
		answer=answer-1;
		
		return answer;
	}
	public static void main(String[] args) {
		Spy spy =new Spy();
		spy.solution(new String[][]{{"1","headgear"},{"2","eyewear"},{"3","headgear"},{"4","pants"},{"5","headgear"},{"6","face"},{"7","face"},{"8","face"},{"9","eyewear"}});
	}

}
