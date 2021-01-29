import java.util.*;
public class clas123 {
	public static void main(String[] args) {
		int[] arr =new int[8];
		int n= 10;
		int i=0;
		while(n>0) {
			arr[i++]=n%2;
			n/=2;
		}
		for(int x=7;x>=0;x--) {
			System.out.print(arr[x] + " ");
		}
		
	}
}
