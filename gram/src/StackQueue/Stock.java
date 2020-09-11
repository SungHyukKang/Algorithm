package StackQueue;

public class Stock {
	
	public int[] solution(int[] prices){
		LinkedLisT LL = new LinkedLisT();
		int[] answer = new int[prices.length];
		int count = 0;
		int z =0;
		for(int i =0 ;i<prices.length;i++){
			answer[i]=prices.length-i-1;
		}
		
		for(int x : prices){
			LL.add(x);
		}
		Node nd = LL.head.next;
		Node nd2 =nd;
		while(z<prices.length){
			while(nd2!=null){
				count++;
				if(nd.data>nd2.data){
					break;
				}
				
				nd2=nd2.next;
				
			}
			nd=nd.next;
			nd2=nd;
			answer[z]=count-1;
			if(answer[z]==0&&z!=prices.length-1)
				answer[z]=1;
			z++;
			count=0;
		}
		for(int i = 0 ;i<prices.length;i++)
			System.out.println(answer[i]);
		
		return answer;
	}
	public static void main(String[] args) {
		Stock stock = new Stock();
		stock.solution(new int[]{1,2,3,2,3});
	}

}

class Node{
	Integer data ;
	Node next;
	
	Node(Integer data , Node next){
		this.data=data;
		this.next =next;
	}
	
}

class LinkedLisT{
	Node head = null;
	Node tail = null;
	
	LinkedLisT(){
		this.head=new Node(null,null);
		this.tail = head;
	}
	
	LinkedLisT add(Integer i){
		tail.next=new Node(i,null);
		tail=tail.next;
		return this;
	}
}


