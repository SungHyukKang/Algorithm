package KAKAO2019BLINDRECRUITMENT;
import java.util.*;


public class Navigator {
	boolean[] visited= new boolean[10001];
	int[] preArr;
	int[] postArr;
	static int idx =0;
	
	
	class Node{
		Node left =null;
		int idx;
		int x ;
		int y;
		Node right=null;
		
		Node(int idx , int x ,int y){
			this.idx=idx;
			this.x=x;
			this.y=y;
		}
	}
	
	class Pos{
		int x ;
		int y;
		int idx;
		
		Pos(int x, int y ,int idx){
			this.x=x;
			this.y=y;
			this.idx=idx;
		}
	}
	
	
	public int[][] solution(int[][] nodeinfo){
		int [][] answer={};
		ArrayList<Pos> arr =new ArrayList<>();
		
		for(int i= 0;i<nodeinfo.length;i++){
			arr.add(new Pos(nodeinfo[i][0],nodeinfo[i][1],i+1));
		}
		
		Collections.sort(arr,new Comparator<Pos>(){
			@Override
			public int compare(Pos o1, Pos o2) {
				if(o1.y>o2.y)
					return -1;
				else if(o1.y<o2.y){
					return 1;
				}else{
					if(o1.x>o2.x){
						return 1;
					}else if(o1.x<o2.x)
						return -1;
					else
						return 0;
				}
			}
		});
		Node root = new Node(arr.get(0).idx,arr.get(0).x,arr.get(0).y);
		Node node =null;
		for(int i = 1;i<arr.size();i++){
			node =root;
			while(true){
				if(arr.get(i).x<node.x){
					if(node.left!=null){
						node=node.left;
						continue;
					}else{
						node.left=new Node(arr.get(i).idx,arr.get(i).x,arr.get(i).y);
						break;
					}
				}else{
					if(node.right!=null){
						node=node.right;
						continue;
					}else{
						node.right=new Node(arr.get(i).idx,arr.get(i).x,arr.get(i).y);
						break;
					}
				}
				
			}
		}
		preArr=new int[arr.size()];
		postArr=new int[arr.size()];
		preorder(root);
		idx=0;
		visited =new boolean[10001];
		postorder(root);
		answer = new int[2][];
		answer[0]=preArr;
		answer[1]=postArr;
		return answer;
	}
	void preorder(Node node){
		if(node!=null){
			if(!visited[node.idx]){
				preArr[idx++]=node.idx;
				visited[node.idx]=true;
			}
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	void postorder(Node node){
		if(node!=null){
			postorder(node.left);
			postorder(node.right);
			if(!visited[node.idx]){
				postArr[idx++]=node.idx;
				visited[node.idx]=true;
			}
		}
	}
	
	public static void main(String[] args) {
		Navigator n = new Navigator();
		
		n.solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});

	}

}
