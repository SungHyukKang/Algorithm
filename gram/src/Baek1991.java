import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Baek1991 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i, n = Integer.parseInt(in.readLine());
		char[] data = in.readLine().replaceAll(" ", "").toCharArray();

		Tree t = new Tree(data[0], data[1], data[2]);

		for (i = 1; i < n; i++) {
			data = in.readLine().replaceAll(" ", "").toCharArray();
			t.add(data[0], data[1], data[2]);
		}

		t.preorder(t.root);
		System.out.println();
		t.inorder(t.root);
		System.out.println();
		t.postorder(t.root);
	}
}

class TreeNode {
	char data;
	TreeNode left;
	TreeNode right;

	public TreeNode(char data) {
		this.data = data;
	}
}

class Tree {
	TreeNode root;
	
	public Tree(char data , char left ,char right){
		root = new TreeNode(data);
		
		if(data!='.')
			root=new TreeNode(data);
		if(left!='.')
			root.left=new TreeNode(left);
		if(right!='.')
			root.right=new TreeNode(right);
	}
	
	void add(char data , char left ,char right) {
		next(root.left,data , left ,right);
		next(root.right,data , left ,right);
	}
	
	void next(TreeNode node,char data,char left ,char right) {
		if(node ==null)
			return;
		if(node.data==data) {
			if(left!='.') {
				node.left=new TreeNode(left);
			}
			if(right!='.') {
				node.right=new TreeNode(right);
			}
		}else {
			next(node.left,data,left,right);
			next(node.right,data,left,right);
		}
	}
	void preorder(TreeNode node) {
		System.out.print(node.data);
		if(node.left!=null)
			preorder(node.left);
		if(node.right!=null)
			preorder(node.right);
	}
	void inorder(TreeNode node) {
		if(node.left!=null)
			inorder(node.left);
		System.out.print(node.data);
		if(node.right!=null)
			inorder(node.right);
	}
	void postorder(TreeNode node) {
		if(node.left!=null)
			postorder(node.left);
		if(node.right!=null)
			postorder(node.right);
		System.out.print(node.data);
	}
	
}
