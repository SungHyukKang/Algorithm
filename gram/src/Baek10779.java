import java.util.*;
import java.io.*;

class Pair10779{
	int idx;
	char c;
	
	Pair10779(int idx,char c){
		this.idx=idx;
		this.c=c;
	}
}

public class Baek10779 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X = br.readLine();
		Stack<Pair10779> stack = new Stack<>();
		Stack<Character> s = new Stack<>();
		int sum=0;
		for(int i =0;i<X.length();i++) {
			char x =X.charAt(i);
			stack.push(new Pair10779(i,x));
			s.push(x);
			if(x==')') {
				Pair10779 p1=stack.pop();
				Pair10779 p2=stack.pop();
				s.pop();
				s.pop();
				if(p1.idx-p2.idx==1) {
					sum+=stack.size();
				}else {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}

}
