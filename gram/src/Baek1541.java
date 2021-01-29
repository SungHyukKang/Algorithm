import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
public class Baek1541 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X =br.readLine();
		String pattern = "^[0-9]*$";
		ArrayList<Integer> list =new ArrayList<>();
		ArrayList<Character> ope =new ArrayList<>();
		StringTokenizer st= new StringTokenizer(X,"[+-]");
		for(int i =0;i<X.length();i++) {
			if(!Pattern.matches(pattern,Character.toString(X.charAt(i)))) {
				list.add(Integer.parseInt(st.nextToken()));
				ope.add(X.charAt(i));
			}
		}
		list.add(Integer.parseInt(st.nextToken()));
		int j=0;
		for(int i =0;i<ope.size();i++) {
			if(ope.get(i)=='+') {
				list.set(j,list.get(j)+list.get(j+1));
				list.remove(j+1);
				j--;
				System.out.println(list);
			}
			j++;
		}
		int sum=list.get(0);
		for(int i =1;i<list.size();i++) {
			sum-=list.get(i);
		}
		System.out.println(sum);
	}
}
