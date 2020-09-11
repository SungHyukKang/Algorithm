import java.util.*;
import java.io.*;

public class Baek10757 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<String> arr= new ArrayList<>();
        String[] A =st.nextToken().split("");
        for(int i =A.length-1;i>=0;i--) {
        	arr.add(A[i]);
        }
        A=new String[arr.size()];
        for(int i =0;i<arr.size();i++) {
        	A[i]=arr.get(i);
        }
        String[] B =st.nextToken().split("");
        arr =new ArrayList<>();
        for(int i =B.length-1;i>=0;i--) {
        	arr.add(B[i]);
        }
        for(int i =0;i<arr.size();i++) {
        	B[i]=arr.get(i);
        }
        int aSize=A.length;
        int bSize=B.length;
        int min = aSize >= bSize ? bSize : aSize;
        int max = aSize >= bSize ? aSize : bSize;
        int[] sum = new int[max+1];
        int num1=0;
        int num2=0;
        for(int i =0;i<max;i++) {
        	if(i<aSize)
        	num1 = Integer.parseInt(A[i]);
        	else
        		num1=0;
        	if(i<bSize)
        	num2 = Integer.parseInt(B[i]);
        	else
        		num2=0;
        	int j=0;
        	int x =(num1+num2)%10;
        	if(num1+num2>=10) {
        		j=(num1+num2)/10;
        	}
        	sum[i]=sum[i]+x;
        	sum[i+1]=j+sum[i+1];
        	if(sum[i]>=10) {
        		sum[i]=sum[i]%10;
        		sum[i+1]=sum[i+1]+1;
        	}
        	
        }
        for(int i =sum.length-1;i>=0;i--) {
        	if(i==sum.length-1&&sum[i]==0)
        		continue;
        	System.out.print(sum[i]);
        }
        
        
	}

}
