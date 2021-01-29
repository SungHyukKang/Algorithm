import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class NHNcode1 {
	static int min;
	static String target;
	static int target_num;
	static boolean[] btn = {true, true, true, true, true, true, true, true, true, true};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = br.readLine();
		target_num = Integer.parseInt(target);

		int broken = Integer.parseInt(br.readLine());
		String[] broken_num;
		min = Integer.MAX_VALUE;

		// 1. 고장난 버튼이 있는 경우에만 입력 받기
		if(broken != 0){
			broken_num = br.readLine().split(" ");
			for(int i=0; i<broken_num.length; i++)
				btn[Integer.parseInt(broken_num[i])] = false;
		}
	
		// 2. 타겟이 100번인 경우
		if(target.equals("100")){
			System.out.println(0);
			return;
		}

		// 3. 100번 채널에서 +, -로만 이동해보기
		int cnt = Math.abs(100 - target_num);
		min = min > cnt ? cnt : min;

		// 4. 모든 경우의 버튼 눌러보기
		dfs(0, "");
		System.out.println(min);
	}

	public static void dfs(int idx, String click){		
		for(int i=0; i<10; i++){
			if(btn[i]){
				String newStr = click + Integer.toString(i);
				int cnt = Math.abs(target_num - Integer.parseInt(newStr)) + newStr.length();	// 원하는 채널로 돌리기 위해 눌러야 하는 버튼 수
				min = min > cnt ? cnt : min;
				if(idx < 6)
					dfs(idx+1, newStr);
			}
		}
	}
}