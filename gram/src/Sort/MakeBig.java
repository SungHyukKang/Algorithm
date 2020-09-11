package Sort;

import java.util.Collections;
import java.util.*;

public class MakeBig {
	class Node{
		Integer data=null;
		Node next=null;
		Node(Integer data , Node next){
			this.data=data;
			this.next = next;
			
		}
	}
	class Linked{
		Node head = null;
		Node tail = null;	
		Linked(){
			this.head = new Node(null,null);
			this.tail=head;
		}
		
		Linked add(Integer data){
			Node temp = tail;
			tail=new Node(data, null);
			tail.next=temp;
			return this;
		}
		
		
		void print(){
			for(Node n = tail;n.next!=null;n=n.next){
				System.out.println(n.data);
			}
		}
	}
	
	
	public String solution(int[] numbers){
		Linked[] ll = new Linked[numbers.length];
		
		ArrayList<Linked> arr = new ArrayList<>();
		Integer number;
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ;i<numbers.length;i++){
			number=numbers[i];
			ll[i]=new Linked();
			while(number>0){
				ll[i].add(number%10);
				number=number/10;
			}
			arr.add(ll[i]);
		}
		Collections.sort(arr , new Comparator<Linked>(){
			@Override
			public int compare(Linked o1, Linked o2) {
				if(o1.tail.data<o2.tail.data){
					return 1;
				}else if (o1.tail.data>o2.tail.data){
					return -1;
				}else{
					/*if(o1.tail.next!=null)
						o1.tail=o1.tail.next;
					if(o2.tail.next!=null)
						o2.tail=o2.tail.next;
					*/
					return 0;
				}
			}
		});
			
		for(int i = 0 ;i<arr.size();i++){
			if(arr.get(i).tail.data==arr.get(i+1).tail.data){
			}
		}
		return "";
	}
	
	public static void main(String[] args){
		MakeBig mb = new MakeBig();
		mb.solution(new int[]{2,23,26,24});
	}
}
