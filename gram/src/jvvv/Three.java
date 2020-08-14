	package jvvv;
	
	import java.util.Scanner;
	
	public class Three {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String Z = sc.next();
			int num=0;
			int sum =0;
			int cnt=1;
			if(Z.length()==1){
				System.out.println("0");
				if(Integer.parseInt(Z)%3==0&&Integer.parseInt(Z)!=0){
					System.out.println("YES");
				}else
					System.out.println("NO");
				return;
			}
			
			for(String X : Z.split("")){
				sum+=Integer.parseInt(X);
			}
			num=sum;
			sum=0;
			while(num>0){
				sum+=num%10;
				num=num/10;
				if(num==0){
					if(sum/10!=0){
						num=sum;
						sum=0;
						cnt++;
					}else{
						cnt++;
						break;
					}
				}
			}
			
			System.out.println(cnt);
			if(sum%3==0){
				System.out.println("YES");
			}else
				System.out.println("NO");
	
		}
	
	}
