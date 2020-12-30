import java.util.*;
import java.io.*;

public class Baek1759 {
	static int L;
	static int C;
	static String mo;
	static String[] alp;
	static String[] moeum;
	static HashMap<String,Boolean> hsmap =new HashMap<>();
	static HashMap<String,Boolean> visited =new HashMap<>();
	static Set<String> hsset = new HashSet<>();
	static Stack<String> stack  =new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alp = new String[C];
		st = new StringTokenizer(br.readLine());
		hsmap.put("a",false);
		hsmap.put("e",false);
		hsmap.put("i",false);
		hsmap.put("o",false);
		hsmap.put("u",false);
		int size=0;
		for(int i =0;i<C;i++) {
			alp[i]=st.nextToken();
			visited.put(alp[i],false);
			if(hsmap.get(alp[i])!=null&&!hsmap.get(alp[i])) {
				hsmap.put(alp[i],true);
				size++;
			}
		}
		moeum=new String[size];
		int c=0;
		for(String X : hsmap.keySet()) {
			if(hsmap.get(X))
				moeum[c++]=X;
		}
		Arrays.sort(alp);
		dfs(0);
		
	}
	//a c i s t w
	public static void dfs(int x) {
		if(stack.size()==L) {
			int jaeum=0;
			int mo=0;
			Collections.sort(stack);
			StringBuilder sb= new StringBuilder();
			for(String X :stack) {
				if(!X.equals("a")&&!X.equals("e")&&!X.equals("i")&&!X.equals("o")&&!X.equals("u")) {
					jaeum++;
				}else {
					mo++;
				}
				sb.append(X);
			}
			if(jaeum>=2&&mo>=1)
				System.out.println(sb);
			return;
		}
		for(int i =x;i<C;i++) {
			if(!visited.get(alp[i])) {
				visited.put(alp[i],true);
				stack.push(alp[i]);
				dfs(i);
				stack.pop();
				visited.put(alp[i],false);
			}
		}
		
	}
	
}
