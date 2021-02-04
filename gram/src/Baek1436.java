import java.util.*;

public class Baek1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		for (int i = 666; i <= 150000000; i++) {
			String X = String.valueOf(i);
			if (X.contains("666")) {
				list.add(Integer.parseInt(X));
				if(list.size()-1==n) {
					System.out.println(list.get(n));
					break;
				}
					
			}
		}

	}

}
