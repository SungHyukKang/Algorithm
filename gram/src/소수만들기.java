import java.util.Arrays;
public class 소수만들기 {
	static int cnt = 0;
	static boolean[] visited;
	static boolean[] visited2;
	static int[] arr;
	static int answer;
	public static int solution(int[] nums) {
		arr = nums;
		Arrays.sort(arr);
		visited2 =new boolean[2999];
		visited2[0]=true;
		visited2[1]=true;
		for (int i = 2; i <= Math.sqrt(2998); i++) {
			if(!visited2[i]) {
				for(int j=i*i;j<=2998;j+=i) {
					visited2[j]=true;
				}
			}
		}
		visited=  new boolean[arr.length];
		dfs(0,0,0);
		return answer;
	}
	
	static void dfs(int cnt,int sum,int idx) {
		if(cnt==3) {
			if(!visited2[sum])
				answer++;
			return;
		}
		for(int i =idx;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(cnt+1,sum+arr[i],i+1);
				visited[i]=false;
			}
		}
	}

	public static void main(String[] args) {
		solution(new int[] {2,3,4,5,6,9});
	}

}
