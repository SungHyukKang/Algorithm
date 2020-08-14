package jvvv;
import java.util.*;
public class Baek1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Baek1158 ba = new Baek1158();
		Linked ll = ba.new Linked(1);
		for(int i =2;i<=N;i++){
			ll.add(i);
		}
		
		ll.Num=N;
		ll.K=K;
		ll.tail.next=ll.head;
		
		ll.print();
	}
	class Node{
		int X ;
		Node next=null;
		
		Node(int X ){
			this.X=X;
		}
	}
	class Linked{
		Node head=null;
		Node tail=null;
		int cnt =1;
		int Z =0;
		int Num =0;
		int K =0;
		StringBuilder sb =new StringBuilder();
		Linked(int num){
			head = new Node(num);
			tail=head;
		}
		Linked add(int num){
			tail.next=new Node(num);
			tail=tail.next;
			return this;
		}
		void print(){
			sb.append("<");
			for(Node N = head;N!=null;N=N.next){
				if(Z>Num)
					break;
				if(N.X==-1){
					Z++;
					continue;
				}else{
					Z=0;
				}
				if(cnt%K==0){
					sb.append(N.X+", ");
					N.X=-1;
				}cnt++;
			}
			sb.append(">");
			System.out.println(sb.toString().replace(", >", ">"));
		}
	}
}

