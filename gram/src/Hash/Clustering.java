package Hash;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;
public class Clustering {

	public int solution(String str1,String str2){
			String pattern = "^[a-zA-Z]*$";
			HashMap<String,Integer> hsmap1 = new HashMap<>();
			HashMap<String,Integer> hsmap2 = new HashMap<>();
			int length=0;
			int gyo =0;
			String input =null;
			if(str1.toUpperCase().equals(str2.toUpperCase()))
				return 65536;
			boolean tf =true;
			for(int i = 0;i<str1.length()-1;i++){
				input=str1.substring(i,i+2).toUpperCase();
				tf=Pattern.matches(pattern, input);
				if(tf){
					hsmap1.put(input, hsmap1.getOrDefault(input, 0)+1);
				}
			}
			for(int i = 0;i<str2.length()-1;i++){
				input=str2.substring(i,i+2).toUpperCase();
				tf=Pattern.matches(pattern, input);
				
				if(tf){
					hsmap2.put(input, hsmap2.getOrDefault(input, 0)+1);
				}
			}
			
			for(Entry<String,Integer> entry : hsmap1.entrySet()){
				if(hsmap2.containsKey(entry.getKey())){
					length=length+Math.max(hsmap1.get(entry.getKey()),hsmap2.get(entry.getKey()));
					gyo=gyo+Math.min(hsmap1.get(entry.getKey()),hsmap2.get(entry.getKey()));
					hsmap2.put(entry.getKey(), 0);
					hsmap1.put(entry.getKey(), 0);
				}else
					length=length+hsmap1.get(entry.getKey());
			}
			for(Entry<String,Integer> entry : hsmap2.entrySet()){
				length=length+hsmap2.get(entry.getKey());
			}
			
			double ans = ((double)gyo/(double)length)*65536;
			int answer=(int)ans;

			if(length==0)
				return 65536;
			
			return answer;
	}
	
	public static void main(String[] args) {
		Clustering clu = new Clustering();
		
		clu.solution("FRANCE", "FRENCH");

	}

}
