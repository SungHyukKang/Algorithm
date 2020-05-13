package gram;

import java.util.ArrayList;
import java.util.Collections;

public class Descending {

	public static long solution(long n){
		long z = n;
		ArrayList<Long> lr =new ArrayList<Long>();
		while(z>0){
			lr.add(z%10);
			z=z/10;
		}
		Collections.sort(lr);
		Collections.reverse(lr);
		StringBuffer sb =new StringBuffer();
		for(long k :lr){
			sb.append(k);
		}
		
		return Long.parseLong(sb.toString());
	}
	public static void main(String[] args) {

		Descending.solution(118372);
		
	}

}
