import java.util.*;
import java.io.*;

public class codecup1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		System.out.println(K == 2 || K == 6 ? "Kali" : "Ringo");
		// 1=Ringo
		// 2=Kali 1->2
		// 3=Ringo 1->2->3
		// 4=Ringo1->2->4
		// 5=Ringo 1->2->3->4->5
		// 6=Kali 1->2->3->6 , 1 -> 2 -> 4 -> 6? ->
		// 7=Ringo 1->2->4->6->7 1->2->

	}
	/// 1-> 2 , 이건 고정
	// 2-> 3 or 2-> 4
	// 3-> 4 or 6 4-> 5 or 6 or 8
}
