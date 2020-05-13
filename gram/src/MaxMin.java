import java.util.ArrayList;
import java.util.Collections;

public class MaxMin {

	public String solution(String s){
		ArrayList<Integer> arr =new ArrayList<>();
		s=s.replace(" ", ",");
		int cnt =0;
		try{
			while(true){
				arr.add(Integer.parseInt((s.split(",")[cnt++])));
			}
		}catch(ArrayIndexOutOfBoundsException e){
		}
		Collections.sort(arr);
		StringBuffer sb =new StringBuffer();
		sb.append(arr.get(arr.size()-1)+" "+arr.get(0));		
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MaxMin mm = new MaxMin();
		
		mm.solution("-1 -2 -3 -4");
		
	}

}
