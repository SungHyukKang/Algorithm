import java.util.*;
import java.io.*;
class Pair1339{
	char word;
	int X;
	
	Pair1339(char w, int x){
		this.word=w;
		this.X=x;
	}
}
public class Baek1339 {
	static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Character,Integer> hsmap = new HashMap<>();
		for(int i =0;i <N;i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			sb=sb.reverse();
			for(int j =0;j<sb.length();j++) {
				hsmap.put(sb.charAt(j),hsmap.getOrDefault(sb.charAt(j),0)+(int)Math.pow(10,j));
			}
		}
		ArrayList<Pair1339> list= new ArrayList<>();
		for(char X : hsmap.keySet()) {
			list.add(new Pair1339(X,hsmap.get(X)));
		}
		Collections.sort(list , new Comparator<Pair1339>() {
			@Override
			public int compare(Pair1339 arg0, Pair1339 arg1) {
				return arg0.X<=arg1.X ? 1 : -1;
			}
		});
		int i =9;
		int answer=0;
		for(Pair1339 p : list) {
			answer+=p.X*i;
			i--;
		}
		System.out.println(answer);
		
		
	}

}
