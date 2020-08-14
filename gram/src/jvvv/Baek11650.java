package jvvv;
import java.util.*;
class Pair3{
	int x;
	int y;
	Pair3(int x , int y){
		this.x=x;
		this.y=y;
	}
}

public class Baek11650 {

	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		int N =sc.nextInt();
		ArrayList<Pair3> arr = new ArrayList<>();
		for(int i =0;i<N;i++){
			arr.add(new Pair3(sc.nextInt(),sc.nextInt()));
		}
		
		Collections.sort(arr,new Comparator<Pair3>(){

			@Override
			public int compare(Pair3 o1, Pair3 o2) {
				if(o1.x>o2.x){
					return 1;
				}else if(o1.x<o2.x){
					return -1;
				}else{
					if(o1.y>o2.y){
						return 1;
					}else if(o1.y<o2.y)
					return -1;
				}
				return 0;
			}
		});
		for(int i =0;i<arr.size();i++){
			System.out.println(arr.get(i).x+" "+arr.get(i).y);
		}
		
	}

}
