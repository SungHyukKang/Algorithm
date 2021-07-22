import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node072102 {
	public int data;
	public Node072102 prev;
	public Node072102 next;

	public Node072102(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

class UserSolution072102 {

	private final static int MAX_NODE = 10000;

	private Node072102[] node = new Node072102[MAX_NODE];
	private int nodeCnt = 0;
	private Node072102 head;
	private Node072102 tail;

	public Node072102 getNode(int data) {
		node[nodeCnt] = new Node072102(data);
		return node[nodeCnt++];
	}

	public void init() {
		node = new Node072102[MAX_NODE];
		nodeCnt = 0;
		head = null;
		tail = null;
		head = tail;
		tail = head;
	}

	public void addNode2Head(int data) {
		Node072102 newNode = getNode(data);
		Node072102 temp = head;
		head = newNode;
		head.next = temp;
		if (head.next == null)
			tail = head;
		else {
			temp.prev = head;
		}
		return;
	}

	public void addNode2Tail(int data) {
		if (nodeCnt == 0) {
			addNode2Head(data);
			return;
		}
		Node072102 newNode = getNode(data);
		Node072102 temp = tail;
		tail = newNode;
		newNode.prev = temp;
		temp.next = newNode;
	}

	public void addNode2Num(int data, int num) {
		if (nodeCnt == 0) {
			addNode2Head(data);
			return;
		}
		if (num == 1) {
			addNode2Head(data);
			return;
		}
		Node072102 newNode = getNode(data);
		Node072102 prev = search(num - 1);
		Node072102 next = search(num);
		if (prev != null)
			prev.next = newNode;
		if (next != null)
			next.prev = newNode;

		newNode.prev = prev;
		newNode.next = next;
		if (newNode.next == null) {
			tail = newNode;
		}
	}

	public Node072102 search(int num) {
		Node072102 n = head;
		for (int i = 1; i < num; i++) {
			n = n.next;
		}
		return n;
	}

	public int findNode(int data) {
		int index = 1;
		Node072102 node = head;
		while (true) {
			if (node == null) {
				index = 0;
				break;
			}
			if (node.data == data) {
				break;
			}
			index++;
			node = node.next;
		}
		return index;
	}

	public Node072102 findData(int data) {
		Node072102 node = head;
		while (true) {
			if (node == null)
				return null;
			if (node.data == data) {
				return node;
			}
			node = node.next;
		}
	}

	public void removeNode(int data) {
		Node072102 preNode = findData(data);
		if (preNode == null)
			return;
		Node072102 prev = preNode.prev;
		Node072102 next = preNode.next;
		if (preNode == tail) {
			tail = prev;
		}
		if (preNode == head) {
			head = next;
		}
		if (prev != null)
			prev.next = next;
		if (next != null)
			next.prev = prev;
		nodeCnt--;
	}

	public int getList(int[] output) {
		Node072102 node = head;
		for (int i = 0; i < nodeCnt; i++) {
			output[i] = node.data;
			node = node.next;
		}
		return nodeCnt;
	}

	public int getReversedList(int[] output) {
		Node072102 n = tail;
		int index = 0;
		while (true) {
			if (n == null)
				break;
			output[index++] = n.data;
			n = n.prev;
		}
		return nodeCnt;
	}

}

public class SWEA_2021_07_21_2 {

	private final static int MAX_NODE = 10000;
	private final static int ADD_HEAD = 1;
	private final static int ADD_TAIL = 2;
	private final static int ADD_NUM = 3;
	private final static int FIND = 4;
	private final static int REMOVE = 5;
	private final static int PRINT = 6;
	private final static int PRINT_REVERSE = 7;
	private final static int END = 99;

	private final static UserSolution072102 usersolution = new UserSolution072102();

	private static BufferedReader br;

	public static void run() throws Exception {
		int cmd, data, num, ret;
		int[] output = new int[MAX_NODE];
		String str;
		StringTokenizer st;

		while (true) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			cmd = Integer.parseInt(st.nextToken());

			switch (cmd) {
			case ADD_HEAD:
				data = Integer.parseInt(st.nextToken());
				usersolution.addNode2Head(data);
				break;

			case ADD_TAIL:
				data = Integer.parseInt(st.nextToken());
				usersolution.addNode2Tail(data);
				break;

			case ADD_NUM:
				data = Integer.parseInt(st.nextToken());
				num = Integer.parseInt(st.nextToken());
				usersolution.addNode2Num(data, num);
				break;

			case FIND:
				data = Integer.parseInt(st.nextToken());
				num = usersolution.findNode(data);
				System.out.println(num);
				break;

			case REMOVE:
				data = Integer.parseInt(st.nextToken());
				usersolution.removeNode(data);
				break;

			case PRINT:
				ret = usersolution.getList(output);
				for (int i = 0; i < ret; i++) {
					System.out.print(output[i] + " ");
				}
				System.out.println();
				break;

			case PRINT_REVERSE:
				ret = usersolution.getReversedList(output);
				for (int i = 0; i < ret; i++) {
					System.out.print(output[i] + " ");
				}
				System.out.println();
				break;

			case END:
				return;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		int TC;
		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		TC = Integer.parseInt(str);

		for (int tc = 1; tc <= TC; tc++) {
			System.out.println("#" + tc);
			usersolution.init();
			run();
			System.out.println();
		}
	}
}