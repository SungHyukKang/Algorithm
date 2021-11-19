import java.util.*;
import java.io.*;

public class Baek1076 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> key = new HashMap<>();
		key.put("black", 0);
		key.put("brown", 1);
		key.put("red", 2);
		key.put("orange", 3);
		key.put("yellow", 4);
		key.put("green", 5);
		key.put("blue", 6);
		key.put("violet", 7);
		key.put("grey", 8);
		key.put("white", 9);
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		long answer = Long.parseLong(key.get(a) + "" + key.get(b)) * (long) Math.pow(10, key.get(c));
		System.out.println(answer);

	}

}
