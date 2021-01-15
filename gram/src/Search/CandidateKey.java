package Search;
import java.util.*;
public class CandidateKey {
	public static boolean[] visited;
	public static HashMap<String, Integer> hsmap = new HashMap<>();
	public static ArrayList<HashSet<Integer>> keys = new ArrayList<>();
	public static Stack<String> stack = new Stack<>();
	static int answer=0;
	public int solution(String[][] relation) {
		visited = new boolean[relation[0].length];
		for (int i = 0; i < relation.length; i++) {
			for (int j = 0; j < relation[i].length; j++) {
				dfs(relation, 0, i, j+1, new HashSet<>());
			}
		}
		System.out.println(answer);
		return keys.size();
	}

	public boolean isPossible(String[][] arr , HashSet<Integer> hsset) {
		ArrayList<String> list = new ArrayList<>();
		for(int i =0;i<arr.length;i++) {
			String temp ="";
			for(int x : hsset) {
				temp+=arr[i][x];
			}
			if(!list.contains(temp)) {
				list.add(temp);
			}else
				return false;
		}
		return true;
	}
	
	public void dfs(String[][] arr, int x, int r, int size,HashSet<Integer> hsset) {
		if (size == hsset.size()) {
			System.out.println(hsset);
			if(!isPossible(arr , hsset)) {
				return;
			}
			for (HashSet<Integer> key : keys) {
				if(hsset.containsAll(key)) {
					return;
				}
			}
			keys.add(hsset);
			answer++;
			System.out.println(keys);
			return;
		}
		for (int i = x; i < arr[0].length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				HashSet<Integer> set = new HashSet<>(hsset);
				set.add(i);
				dfs(arr, i, r, size, set);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		CandidateKey ck = new CandidateKey();
		ck.solution(new String[][] {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}
);
	}
}
