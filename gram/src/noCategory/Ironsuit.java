package noCategory;

public class Ironsuit {

	public int solution(int n){
		int num =n;
		int i =1;
		while(num%2==0){
			num=num/2;
		}
		int count = 1;
		boolean tf =true;
		System.out.println(num);
		while(i!=n){
			i=i*2;
			if(i>=num&&tf){
				count+=num-i/2;
				i=num;
				System.out.println(i);
				tf=false;
			}
		}
		System.out.println(count);
		return count;
	}
	
	public static void main(String[] args) {
		Ironsuit is = new Ironsuit();
		
		is.solution(5000);

	}

}
