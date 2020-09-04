import java.util.*;
public class Baek11047 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt =0;
		int sum=0;
		for(int i =0;i<N;i++) {
			int num = sc.nextInt();
			if(num<=K)
			arr.add(num);
		}
		Collections.reverse(arr);
		int i =0;
		while(K!=sum) {
			int Z = arr.get(i);
			if(sum+Z>K)
				i++;
			else {
				sum+=Z;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
