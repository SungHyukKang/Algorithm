import java.util.*;
import java.io.*;
public class Baek9012 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		for(int i =0;i<N;i++) {
			String X = br.readLine();
			Stack<Character> stack =new Stack<>();
			boolean tf = true;
			for(int j =0;j<X.length();j++) {
				char c =X.charAt(j);
				if(c==')') {
					if(stack.isEmpty()) {
						System.out.println("NO");
						tf=false;
						break;
					}
					stack.pop();
				}else {
					stack.push(c);
				}
			}
			if(tf)
			if(stack.isEmpty()) {
				System.out.println("YES");
				continue;
			}else
				System.out.println("NO");
		}
	}

}
