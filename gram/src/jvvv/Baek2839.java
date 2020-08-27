package jvvv;
import java.util.Scanner;

public class Baek2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt =0;
        while(N!=0){
            if(N%5==0){
               N-=5;
               cnt++;
            }else if(N%3==0){
                N-=3;
                cnt++;
            }else if(N>5){
                N-=5;
                cnt++;
            }else {
                System.out.println("-1");
                return;
            }
        }
        System.out.println(cnt);
    }
}
