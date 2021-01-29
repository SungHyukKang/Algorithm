	public class Naverno1 {
		static int cnt;
		static int size;
		static int[] arr;
		static int answer=0;
		String X = "";
		public long solution(int k ) {
			arr =new int[]{6,2,5,5,4,5,6,3,7,6};
			if(k==6) {
				answer++;
			}
			size = k;
			for(int i =1 ;i<arr.length;i++) {
				cnt=0;
				dfs(k,cnt+arr[i]);
				}
			return answer;
		}
		public static void dfs(int pre,int cnt) {
			if(pre==cnt) {
				answer++;
			return;
			}
			for(int i =0;i<arr.length;i++) {
				if(cnt>pre)
					return;
				dfs(pre,cnt+arr[i]);
			}
		}
		public static void main(String[] args) {
			Naverno1 no1 = new Naverno1();
			for(int i =1;i<40;i++)
			System.out.println(i+" "+no1.solution(i));
		}
	}