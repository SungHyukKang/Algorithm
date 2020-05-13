import java.util.*;

public class LeastCommonMulitple {
	
	public int solution(int[] arr){
		ArrayList<Integer> array =new ArrayList<>();
		ArrayList<Integer> array2 =new ArrayList<>();
		int mul=1;
		for(int X : arr){
			array.add(X);
		}
		Collections.sort(array);
		for(int i=0;i<array.size();i++){
			for(int j = i;j<array.size();j++){
				if((array.get(j)%array.get(i)==0)&&j!=i){
					array.set(j, array.get(j)/array.get(i));
				}
			}
			
			mul*=array.get(i);
			array.set(i, 1);
			System.out.println(array);
			System.out.println(mul);
		}
		return mul;
	}
	
	public static void main(String[] args) {
		LeastCommonMulitple lcm = new LeastCommonMulitple();

		lcm.solution(new int[]{6,8,10,48,88,100});
	}

}
