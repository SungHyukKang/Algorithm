import java.util.*;
public class 단체사진찍기 {
	static HashMap<Character,Integer> hsmap =new HashMap<>();
	static boolean[] visited=new boolean[8];
	static int[] arr;
	static int answer=0;
	public static int solution(int n, String[] data) {
		char[] Z =new char[] { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
		arr=new int[8];
		for(int i=0;i<Z.length;i++) {
			hsmap.put(Z[i],i);
		}
		dfs(0,data);
		System.out.println(answer);
		return answer;
	}
	public static void dfs(int cnt, String[] data) {
		if(cnt==8) {
			int  x;
			int y;
			char operator;
			int num;
			for(int i=0;i<data.length;i++) {
				x = arr[hsmap.get(data[i].charAt(0))];
				y= arr[hsmap.get(data[i].charAt(2))];
				operator=data[i].charAt(3);
				num=data[i].charAt(4)-'0';
				System.out.println(x-y);
				if(operator=='>') {
					if(Math.abs(x-y)-1<=num) {
						return;
					}
				}else if(operator=='<') {
					if(Math.abs(x-y)-1>=num) {
						return;
					}
				}else {
					if(Math.abs(x-y)-1!=num) {
						return;
					}
				}
			}
			answer++;
			return;
		}
		for(int i =0;i<visited.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[cnt]=i;
				dfs(cnt+1,data);
				visited[i]=false;
			}
		}
		
	}
	public static void main(String[] args) {
		solution(2,new String[] {"N~F=0", "R~T>2"});
	}

}
