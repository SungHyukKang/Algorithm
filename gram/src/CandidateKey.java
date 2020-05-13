import java.util.*;

public class CandidateKey {

	public int solution(String[][] relation){
		LinkedList ll = new LinkedList();
		HashMap<String,Integer> hakbun =new HashMap<>();
		HashMap<String,Integer> name =new HashMap<>();
		HashMap<String,Integer> major =new HashMap<>();
		HashMap<String,Integer> grade =new HashMap<>();
		ArrayList<Node> arr = new ArrayList<>();
		for(int i = 0 ;i<relation.length;i++){			
			hakbun.put(relation[i][0], hakbun.getOrDefault(relation[i][0], 0)+1);
			name.put(relation[i][1], name.getOrDefault(relation[i][1], 0)+1);
			major.put(relation[i][2], major.getOrDefault(relation[i][2], 0)+1);
			grade.put(relation[i][3], grade.getOrDefault(relation[i][3], 0)+1);
		}
		
		
		for(int i =0 ; i<relation.length;i++){
			if(hakbun.size()!=relation.length){
				ll.add(Integer.parseInt(relation[i][0]),relation[i][1],relation[i][2],Integer.parseInt(relation[i][3]));
			}else if(name.size()!=relation.length){
				ll.add(relation[i][1],relation[i][2],Integer.parseInt(relation[i][3]));
			}else if(major.size()!=relation.length){
				ll.add(relation[i][2],Integer.parseInt(relation[i][3]));
			}else
				ll.add(Integer.parseInt(relation[i][3]));
		}
		
		
		for(Node n = ll.head.next;n!=null;n=n.next){
		}
		
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		CandidateKey ck = new CandidateKey();
		ck.solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});
	}
	class Node{
		Integer hakbun;
		String name=null;;
		String major=null;
		Integer grade=null;
		Node next = null;

		Node(Integer grade , Node next){
			this.grade = grade;
			this.next =next;
		}
		
		Node(String major , Integer grade , Node next){
			this.major = major;
			this.grade = grade;
			this.next =next;
		}
		
		Node(String name , String major , Integer grade , Node next){
			this.name = name;
			this.major = major;
			this.grade = grade;
			this.next =next;
		}
		Node(Integer hakbun , String name , String major , Integer grade , Node next){
			this.hakbun=hakbun;
			this.name = name;
			this.major = major;
			this.grade = grade;
			this.next =next;
		}
		Node send(){
			if(hakbun==null){
				return new Node(this.name,this.major,this.grade,this.next);
			}else if(major==null){
				return new Node(this.major,this.grade,this.next);
			}else if(grade==null){
				return new Node(this.grade,this.next);
			}else
				return new Node(this.hakbun,this.name,this.major,this.grade,next);
		}
		
	}
	
	class LinkedList{
		Node head =null;
		Node tail = null;
		
		LinkedList(){
			this.head = new Node(null,null,null,null,null);
			this.tail=head;
		}
		LinkedList add(String major,Integer grade){
			tail.next=new Node(major,grade,null);
			tail=tail.next;
			return this;
		}
		
		LinkedList add(Integer grade){
			tail.next=new Node(grade,null);
			tail=tail.next;
			return this;
		}
		
		LinkedList add(String name,String major,Integer grade){
			tail.next=new Node(name,major,grade,null);
			tail=tail.next;
			return this;
		}
		
		LinkedList add (Integer hakbun , String name , String major , Integer grade){
			tail.next=new Node(hakbun,name,major,grade,null);
			tail=tail.next;
			return this;
		}
		void print(){
			for(Node n = head.next;n!=null;n=n.next){
				System.out.println(n.hakbun);
				System.out.println(n.name);
				System.out.println(n.major);
				System.out.println(n.grade);
			}
		}
		
	}
	
	
	
	

}
