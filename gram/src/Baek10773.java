import java.io.*;

public class Baek10773 {

	static int stoi(String X) {
		return Integer.parseInt(X);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		Stack10773 stack = new Stack10773();
		for (int i = 0; i < n; i++) {
			int data =stoi(br.readLine());
			if(data==0) {
				stack.pop();
			}else
				stack.add(data);
		}
		int sum =stack.print();
		System.out.println(sum);
	}

}

class Stack10773 {
	Node10773 top;
	Node10773 head;

	Stack10773() {
		this.head = new Node10773(null);
		this.top = head;
	}

	public Stack10773 add(int i) {
		Node10773 node = new Node10773(i);
		node.next=top;
		top=node;
		return this;
	}
	
	public void pop() {
		if(top.next==null) {
			return;
		}
		this.top=top.next;
	}
	
	public int print() {
		int sum=0;
		for(Node10773 n = top;n.next!=null;n=n.next) {
			sum+=n.data;
		}
		return sum;
	}
	
}

class Node10773 {
	Integer data;
	Node10773 next;

	Node10773(Integer data) {
		this.data = data;
		this.next = null;
	}
}