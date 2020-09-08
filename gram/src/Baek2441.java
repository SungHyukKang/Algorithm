import java.util.*;
public class Baek2441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        for(int i =N;i>0;i--){
        	for(int z = 0;z<N-i;z++)
        		System.out.print(" ");
            for(int j =N-i;j<N;j++){
                System.out.print("*");
            }
            System.out.println();
        }
	}

}
