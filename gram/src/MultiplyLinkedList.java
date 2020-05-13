
public class MultiplyLinkedList {
	class Node{
		Node prev=null;
		Character group=null;
		Integer data =null;
		Node next =null;
	}
	
	class LinkedList{
		Node header=null;
		Integer data =null;
		Character group=null;
		Node tail=null;
		LinkedList(){
		}
		LinkedList(Integer data){
			this.data=data;
		}
		LinkedList(Character group){
			this.group=group;
		}
	}
	LinkedList[] GroupInitShare(){
		LinkedList[] groups=new LinkedList[26];
		Node node =null;
		for(int i = 0;i<groups.length;i++){
			node=new Node();
			groups[i]=new LinkedList();
			groups[i].header=node;
			groups[i].tail=node;
			node.next=node;
		}
		return groups;
	}
	LinkedList[] ElementInitShare(){
		LinkedList[] elements=new LinkedList[100];
		Node node =null;
		for(int i = 0;i<elements.length;i++){
			node=new Node();
			elements[i]=new LinkedList();
			elements[i].header=node;
			elements[i].tail=node;
			node.next=node;
		}
		return elements;
	}
	public static void main(String[] args){
		MultiplyLinkedList mp =new MultiplyLinkedList();
		LinkedList[] groups =mp.GroupInitShare();
		LinkedList[] elements =mp.ElementInitShare();
		int cnt =0;
		
		
		
	}	
}

