package Search;

public class TargetNumber {
	public static int answer=0;
	
	public static int solution(int[] numbers , int target){
		dfs(numbers,0,target);
		return answer;
	}
	public static void dfs(int[] numbers ,int node, int target){
		if(node==numbers.length){
			int sum =0;
			for(int i = 0;i<numbers.length;i++)
				sum+=numbers[i];
			if(sum==target)
				answer++;
			return;
		}else{
			numbers[node]=numbers[node]*1;
			dfs(numbers,node+1,target);
			
			numbers[node]=numbers[node]*-1;
			dfs(numbers,node+1,target);
		}
		
		
	}
	public static void main(String[] args) {	
		System.out.println(TargetNumber.solution(new int[]{1,1,1,1,1}, 3));
	}
}