import java.util.*;
import java.io.*;

class Pair2504 {
	int idx;
	char c;

	public Pair2504(int idx, char c) {
		this.idx = idx;
		this.c = c;
	}
	
}

class Ans2504 {
	int idx;
	int d;

	public Ans2504(int idx, int d) {
		this.idx = idx;
		this.d = d;
	}

	@Override
	public String toString() {
		return " d=" + d + "";
	}
	
}

public class Baek2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X = br.readLine();
		Stack<Pair2504> stack = new Stack<>();
//		System.out.println("( [ ( ) ( ( ) ) ] ( ( ) ) ( [ [ ] ] ( ) ) ) ( ) [ ( ) ]");
		ArrayList<Ans2504> list = new ArrayList<>();
		for (int i = 0; i < X.length(); i++) {
			char c = X.charAt(i);
			stack.push(new Pair2504(i, c));
			if (c == ')' || c == ']') {
				Pair2504 p1 = stack.pop();
				if(stack.isEmpty()) {
					System.out.println("0");
					return;
				}
				Pair2504 p2 = stack.pop();
				if (p1.c == ')' && p2.c == '(') {
					if (p2.idx - p1.idx == -1) {
						list.add(new Ans2504(p2.idx,2));
					}else {
						for(int j =list.size()-1;j>=0;j--) {
							if(list.get(j).idx<p2.idx) {
								break;
							}
							list.get(j).d=list.get(j).d*2;
						}
					}
				} else if (p1.c == ']' && p2.c == '[') {
					if (p2.idx - p1.idx == -1) {
						list.add(new Ans2504(p2.idx,3));
					}else {
						for(int j =list.size()-1;j>=0;j--) {
							if(list.get(j).idx<p2.idx) {
								break;
							}
							list.get(j).d=list.get(j).d*3;
						}
					}
				} else {
					System.out.println("0");
					return;
				}
			}
		}
		int x =0;
		if(!stack.isEmpty()) {
			System.out.println("0");
			return;
		}
		for(Ans2504 z : list) {
			x+=z.d;
		}
		System.out.println(x);
	}
}
