import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node072101 {
	public int data;
	public Node072101 next;

	public Node072101(int data) {
		this.data = data;
		this.next = null;
	}
}

class UserSolution072101 {

	private final static int MAX_NODE = 10000;

	private Node072101[] node = new Node072101[MAX_NODE];
	private int nodeCnt = 0;
	private Node072101 head;
	private Node072101 tail;

	public Node072101 getNode(int data) {
		node[nodeCnt] = new Node072101(data);
		return node[nodeCnt++];
	}

	public void init() {
		node = new Node072101[MAX_NODE];
		nodeCnt = 0;
		head = null;
		tail = head;
	}

	public void addNode2Head(int data) {
		Node072101 newNode = getNode(data);
		Node072101 temp = head;
		head = newNode;
		head.next = temp;
		if (head.next == null) {
			tail = head;
		}
	}

	public void addNode2Tail(int data) {
		if (nodeCnt == 0) {
			addNode2Head(data);
			return;
		}
		Node072101 newNode = getNode(data);
		tail.next = newNode;
		tail = newNode;
	}

	public void addNode2Num(int data, int num) {
		if (num == 1) {
			addNode2Head(data);
			return;
		}
		Node072101 pre = search(num - 1);
		Node072101 newNode = getNode(data);
		Node072101 temp = pre.next;
		pre.next = newNode;
		newNode.next = temp;

		if (newNode.next == null) {
			tail = newNode;
		}

	}

	public Node072101 search(int idx) {
		Node072101 n = head;
		for (int i = 1; i < idx; i++) {
			n = n.next;
		}
		return n;
	}

	public void removeNode(int data) {
		Node072101 target = head;
		Node072101 pre = null;
		boolean tf = false;
		// remove 시 생각해야할 것
		// 지우려는 노드가 head인가?
		// 지우려는 노드가 tail인가?
		while (true) {
			if (target == null)
				break;
			if (target.data == data) {
				tf = true;
				break;
			}
			pre = target;
			target = target.next;
		}
		if (tf) {
			if (target == head) {
				head = head.next;
				if (head == null) {
					tail = null;
				}
			} else {
				if (target == tail) {
					tail = pre;
					pre.next = null;
				} else {
					pre.next = target.next;
					if (pre.next == null) {
						pre = tail;
					}
				}
			}
		} else {
			return;
		}
		nodeCnt--;
	}

	public int getList(int[] output) {
		Node072101 n = head;
		int idx = 0;
		while (true) {
			output[idx++] = n.data;
			n = n.next;
			if (n == null)
				break;
		}
		return nodeCnt;
	}
}

public class SWEA_2021_07_21_1 {

	private final static int MAX_NODE = 10000;
	private final static int ADD_HEAD = 1;
	private final static int ADD_TAIL = 2;
	private final static int ADD_NUM = 3;
	private final static int REMOVE = 4;
	private final static int PRINT = 5;
	private final static int END = 99;

	private final static UserSolution072101 usersolution = new UserSolution072101();

	private static BufferedReader br;

	private static void run() throws Exception {

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