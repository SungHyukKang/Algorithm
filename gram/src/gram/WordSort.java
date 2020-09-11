package gram;
import java.util.Arrays;
import java.util.Comparator;
public class WordSort {

	class Wordcomp implements Comparator<String>{
		int n;
		
		Wordcomp(int n){
			this.n=n;
		}
		@Override
		public int compare(String o1, String o2) {
			if(o1.substring(n,n+1).charAt(0)>o2.substring(n,n+1).charAt(0)){
				return 1;
			}else if(o1.substring(n,n+1).charAt(0)<o2.substring(n,n+1).charAt(0))
				return -1;
			else
				return 0;
		}		
	}
	
	
	public String[] solution(String[] strings , int n){
		//Wordcomp wc =new Wordcomp(n);
		Arrays.sort(strings);
		//Arrays.sort(strings,wc);
		Arrays.sort(strings,new Comparator<String>(){
			@Override
			public int compare(String o1,String o2){
				if(o1.charAt(n)>o2.charAt(n)){
					return 1;
				}else if(o1.charAt(n)<o2.charAt(n))
					return -1;
				else
					return 0;
			}
		});
		
		for(String mm : strings){
			System.out.println(mm);
		}
		
		
		
		
		return strings;
	}
	
	public static void main(String[] args) {
		
		WordSort ws =new WordSort();
		
		ws.solution(new String[]{"abce","abcd","cdx"}, 2);
		
	}

}
