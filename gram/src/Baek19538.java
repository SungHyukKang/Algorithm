import java.util.*;
import java.io.*;

class Rumor{
	int index;
	ArrayList<Integer> ni = new ArrayList<>();
	double naver;
	double rum;
	int time = -1;
	boolean yupo=false;
	
	Rumor(int index , double naver,double rum){
		this.index=index;
		this.naver=naver;
		this.rum=rum;
	}
	public void add(ArrayList<Integer> q) {
		this.ni = q ;
	}
	
	public void setTime(int t) {
		this.time=t;
	}
}

public class Baek19538 {
	static int N;
	static int M;
	static Rumor[] rumor;
	static int t=1;
	static Queue<Rumor> queue =new LinkedList<>();
	public static void main(String[] args)throws IOException {
	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer st;
	N = Integer.parseInt(br.readLine());
	rumor = new Rumor[N+1];
	for(int i=1;i<=N;i++ ) {
		st=new StringTokenizer(br.readLine());
		int num= Integer.parseInt(st.nextToken());
		int cnt=0;
		ArrayList<Integer> q = new ArrayList<>();
		while(num!=0) {
			q.add(num);
			num= Integer.parseInt(st.nextToken());
			cnt++;
		}
		rumor[i]=new Rumor(i ,cnt,0 );
		rumor[i].add(q);
	}
	M= Integer.parseInt(br.readLine());
	st = new StringTokenizer(br.readLine());
	for(int i =0;i<M;i++) {
		int yupo =Integer.parseInt(st.nextToken());
		rumor[yupo].yupo=true;
		rumor[yupo].time=0;
		if(rumor[yupo].naver!=0)
			queue.offer(rumor[yupo]);
	}
	bfs();

	
	for(int i =1;i<=N;i++) {
		bw.write(rumor[i].time+" ");
	}
	bw.flush();
	bw.close();
	br.close();
	}
	public static void bfs() {
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i =0;i<size;i++) {
			Rumor r = queue.poll();
			ArrayList<Integer> yupoja = new ArrayList<>();
			int index =r.index;
//			System.out.println("현재 유포자 "+ index +" 현재 시간 : "+t);
			for(int ni : r.ni) {
				rumor[ni].rum++;
				if(!rumor[ni].yupo) {
					double rum = rumor[ni].rum;
					double naver = rumor[ni].naver;
//					System.out.println("index : "+ni+" "+rum+" "+naver);
					if(rum/naver>=0.5) {
//						System.out.println("yupoja"+ni);
						yupoja.add(ni);
						queue.offer(rumor[ni]);
						rumor[ni].time=t;
					}
				}
			}
			for(int x : yupoja) {
				rumor[x].yupo=true;
			}
			}
			t++;
//			System.out.println("--------------------------");
		}
	}
}
