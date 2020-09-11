package Sort;
import java.util.*;

public class Agesort {
	public class Member{
		int idx;
		String name=null;
		int age ;
		
		Member(int i ,int a,String n){
			this.idx=i;
			this.name =n;
			this.age = a;
		}		
	}	
	public Member solution(int i , int a,String n){
		Member mem = new Member(i,a,n);
		return mem;
	}
	
	public static void main(String[] args) {
	
		Agesort as = new Agesort();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> arr =new ArrayList<>();
		int n = sc.nextInt();
		for(int i = 0;i<n;i++){
			arr.add(as.solution(i,sc.nextInt(),sc.nextLine()));
		}
		Collections.sort(arr,new Comparator<Member>(){
			@Override
			public int compare(Member arg0, Member arg1) {
				if(arg0.age>arg1.age){
					return 1;
				}else if(arg0.age<arg1.age)
					return -1;
				else{
					if(arg0.idx>arg1.idx)
						return 1;
					else if(arg0.idx<arg1.idx)
						return-1;
					else
						return 0;
				}
			}
		});
		for(int i = 0;i<arr.size();i++){
			System.out.println(arr.get(i).age+""+arr.get(i).name);
		}
	}

}
