package Greedy;
public class BigNum {	
	public static String Solution(String number,int k){
		StringBuffer answer=new StringBuffer();
		int length = number.length()-k;
		int length2 = number.length()-k;
		int idx =1;
		boolean tf = true;
		int[] arr=new int[number.length()];
		for(int i=0;i<arr.length;i++){
			arr[i]=Integer.parseInt(Character.toString(number.charAt(i)));
			System.out.println(arr[i]);
		}
		int big=arr[0];
		while(tf){
		for(int i = idx ;i<=arr.length-length2;i++){
			if(big<arr[i]){
				big=arr[i];
				arr[i]=-1;
				idx=i;			
				}
			}
		length2=length2-1;
		answer.append(big);
		System.out.println("answer"+answer);
		big=0;
		if(answer.length()==length)
			tf=false;
		}
		return answer.toString();
	}
	public static void main(String[] args) {
		BigNum.Solution("4177252841", 4);
	}
}
