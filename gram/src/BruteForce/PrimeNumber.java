package BruteForce;

import java.util.*;

public class PrimeNumber {
	public static HashMap<Integer, Boolean> hsmap = new HashMap<>();
	public static HashSet<String> hsset = new HashSet<>();
	static String numb;
	static boolean[] visit=new boolean[10];
	public int solution(String numbers) {
		int answer = 0;
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < numbers.length(); i++) {
			list.add(numbers.charAt(i));
		}
		
		Collections.sort(list, (x, y) -> {
			return x >= y ? -1 : 1;
		});
		StringBuilder sb = new StringBuilder();
		for (char x : list)
			sb.append(x);
		int num = Integer.parseInt(sb.toString());
		numb=String.valueOf(num);
		boolean[] visited = new boolean[num + 1];
		visited[0] = true;
		visited[1] = true;
		for (int i = 2; i < Math.sqrt(num); i++) {
			for (int j = i * i; j <= num; j += i) {
				if (!visited[j])
					visited[j] = true;
			}
		}
		dfs("");
		for(String X : hsset) {
			StringBuilder sb2 =new StringBuilder();
			for(int i =0;i<X.length();i++) {
				sb2.append(list.get(Integer.parseInt(Character.toString(X.charAt(i)))));
			}
			hsmap.put(Integer.parseInt(sb2.toString()),true);
		}
		for (int i = 2; i <= num; i++) {
			if (!visited[i]&&hsmap.get(i)!=null) {
				answer++;
			}
		}
		
		
		return answer;
	}
	
	public static void dfs(String X) {
		for(int i =0;i<numb.length();i++) {
			if(!visit[i]) {
				visit[i]=true;
				hsset.add(X+i);
				dfs(X+i);
				visit[i]=false;
			}
		}
	}

	public static void main(String[] args) {

		PrimeNumber pn = new PrimeNumber();
		System.out.println(pn.solution("011"));

	}
}
