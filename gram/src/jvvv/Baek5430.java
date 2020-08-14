	package jvvv;
	
	import java.util.*;
	
	public class Baek5430 {
	
		public static void main(String[] args) {
			Scanner sc= new Scanner(System.in);
			int N = sc.nextInt();
			boolean tf = true;
			boolean tf2 = true;
			int dSize=0;
			sc.nextLine();
			StringBuilder sb = new StringBuilder();
			Queue<String> command = null;
			LinkedList<Integer> queue =null;
			for(int i = 0;i<N;i++){		
				queue=new LinkedList<>();
				command=new LinkedList<>();
				String str =sc.next();
				command.add(str);
				
				int nono =sc.nextInt();
				sc.nextLine();
				String nums = sc.next();
				nums=nums.substring(1,nums.length()-1);
				tf=true;
				tf2=true;
				
				for(String ZZ : nums.split(",")){
					if("".equals(ZZ))
						continue;
					queue.add(Integer.parseInt(ZZ));
				}
				for(String X : command.poll().split("")){
					if("R".equals(X)){
						tf=!tf;
						continue;
					}
					if(tf){
						if(queue.isEmpty()){
							sb.append("error\n");
							tf2=false;
							break;
						}
						queue.poll();
					}else{
						if(queue.isEmpty()){
							sb.append("error\n");
							tf2=false;
							break;
						}
						queue.pollLast();
					}
				}
				sc.nextLine();
				if(!tf){
					Collections.reverse(queue);
				}	
				if(tf2)
					sb.append(queue.toString().replace(" ","")+"\n");
			}
		System.out.println(sb);	
		}
	
	}
