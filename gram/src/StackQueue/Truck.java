package StackQueue;
public class Truck {
	
	class Node{
		int time;
		int weight;
		Node next=null;
		
		Node(int t ,int w , Node n){
			time=t;
			weight=w;
			next=n;
		}
	}
	
	class Queue{
		Node head = null;
		Node tail =null;
		
		Queue(int time ,int weight){
			head = new Node(time,weight,null);
			tail=head;
		}
		
		Queue add(int time , int weight){
			tail.next=new Node(time,weight,null);
			tail=tail.next;
			return this;
		}
		
		void print(){
			for(Node n = head;n!=null;n=n.next){
				System.out.println(n.weight);
			}
		}
		
		Queue poll(){
			if(head.next==null)
				return this;
			else{
				head=head.next;
				return this;
			}
		}
	}
	
	
	
	public int solution(int bridge_length, int weight , int[] truck_weights){
		int answer = 0;
		Queue qu = null;
		int x =0;
		for(int i = 0;i<truck_weights.length;i++){
			if(qu==null){
				qu=new Queue(bridge_length, truck_weights[i]);
				continue;
			}
			qu.add(bridge_length, truck_weights[i]);
			}
		
		qu.print();
		
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		Truck truck = new Truck();
		
		truck.solution(2, 10, new int[]{7,4,5,6});

	}



}