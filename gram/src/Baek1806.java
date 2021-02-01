import java.util.*;
import java.io.*;

public class Baek1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		int j = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int x = 0; x < N; x++)
			arr[x] = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int sum = 0;
		int INF=2100000000;
		int min = INF;
		while (true) {
			if (sum >= M) {
				sum -= arr[i];
				i++;
				min = Math.min(cnt, min);
				cnt--;
			} else if (j == arr.length)
				break;
			else {
				sum += arr[j];
				j++;
				cnt++;
			}
		}
		bw.write(min==INF ? "0":min+"");
		bw.flush();
		bw.close();
		br.close();
	}

}
