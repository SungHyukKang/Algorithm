	package jvvv;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.Scanner;
	class Pair1{
		int start;
		int end;
		
		Pair1(int start ,int end){
			this.start=start;
			this.end=end;
		}
	}
	public class Baek1931 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N =sc.nextInt();
			ArrayList<Pair1> arr =new ArrayList<>();
			for(int i =0 ;i<N;i++){
				arr.add(new Pair1(sc.nextInt(),sc.nextInt()));
			}
			Collections.sort(arr,new Comparator<Pair1>() {
				@Override
				public int compare(Pair1 o1, Pair1 o2) {
					if(o1.end>o2.end){
						return 1;
					}else if(o1.end<o2.end){
						return -1;
					}else{
						if(o1.start>o2.start){
							return 1;
						}else if(o1.start<o2.start){
							return -1;
						}
						return 0;
					}
				}
			});
			int cnt= 0;
			int end=arr.get(0).end;
			for(int i =1;i<arr.size();i++){
				if(end<=arr.get(i).start){
					cnt++;
					end=arr.get(i).end;
				}
			}
			System.out.println(cnt+1);
		}
	}
	/*
	 * 
	 * 
	 * 
	 * 
	11
	1 4
	3 5
	0 6
	5 7
	3 8
	5 9
	6 10
	8 11
	8 12
	2 13
	12 14
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	 