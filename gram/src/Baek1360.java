import java.util.*;
import java.io.*;
public class Baek1360 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<>();
		for(int i =1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String func = st.nextToken();
			String data= st.nextToken();
			int inputTime = Integer.parseInt(st.nextToken());
			if(inputTime!=i) {
				i++;
				stack.push("!");
				if(inputTime==i) {
					if(func.equals("type")) {
						stack.push(data);
					}else {
						for(int j =0;j<Integer.parseInt(data);j++) {
							stack.pop();
						}
					}
					continue;
				}
			}else {
				if(inputTime==i) {
					if(func.equals("type")) {
						stack.push(data);
					}else {
						for(int j =0;j<Integer.parseInt(data);j++) {
							stack.pop();
						}
					}
				}
			}
		}
	
		System.out.println(stack);
	}
}
