package StackQueue;

public class Printer2 {
	public int solution(int[] priorities,int location){
		Linked queue = new Linked(0,priorities[0]);
		int count = 0;
		int idx = 1;
		int answer = 1;
		for(int z : priorities){
			if(count!=0)
				queue.add(idx++,z);
			count=1;
		}
		Prior first = null;
		while(queue.head.next!=null){
			first=queue.head;
			for(Prior n = queue.head.next;n!=null;n=n.next){
				if(first.num<n.num){
					queue.add(first.idx, first.num);
					queue.poll();
					break;
				}
				if(n==queue.tail){
					if(first.idx==location)return answer;
					queue.poll();
					answer++;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Printer2 ptr = new Printer2();		
		System.out.println(ptr.solution(new int[]{4,3,6,1,2,9,2,9,1},3));
	}

	class Prior{
		Integer idx = null;
		Integer num=null;
		Prior next = null;
		
		Prior(Integer i , Integer num , Prior n){
			idx=i;
			this.num=num;
			next=n;
		}
		
	}
	
	class Linked{
		Prior head = null;
		Prior tail = null;
		
		Linked(Integer idx,Integer num){
			head = new Prior(idx,num,null);
			tail = head;
		}
		
		Linked add(Integer idx ,Integer num){
			tail.next=new Prior(idx , num,null);
			tail = tail.next;
			return this;
		}
		
		Linked poll(){
			head=head.next;
			if(head.next==null)
				return null;
			return this;
		}
		
		void print2(){
			for(Prior n = head; n!=null;n=n.next){
				System.out.println("idx : "+n.idx+","+"num : "+ n.num);
			}
		}
	}
}
