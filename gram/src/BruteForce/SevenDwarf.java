package BruteForce;

import java.util.*;

public class SevenDwarf {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		ArrayList<Integer> arr =new ArrayList<>();
		int sum =-100;
		boolean tf =true;
		for(int i = 0 ;i<9;i++){
			arr.add(sc.nextInt());
			sum+=arr.get(i);
		}
		Collections.sort(arr);
		int x= 0;
		for(int i = 0;i<arr.size();i++){
			if((arr.get(i)+arr.get(arr.size()-1))>=sum){
				x=i;
				break;
			}
		}
		
		for(int i = x;i<arr.size()&&tf;i++){
			for(int j=i;j<arr.size();j++){
				if(arr.get(i)+arr.get(j)==sum){
					arr.set(i, -1);
					arr.set(j, -1);
					tf=false;
					break;
				}
			}
		}
		for(int i =0;i<9;i++){
			if(arr.get(i)!=-1)
			System.out.println(arr.get(i));
		}
		
		
		
}
}