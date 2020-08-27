package jvvv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Baek1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<String,Integer> hsmap = new HashMap<>();

        ArrayList<String> ans = new ArrayList<>();

        for(int i=0;i<(N+M);i++){
            String Z = sc.next();
            hsmap.put(Z,hsmap.getOrDefault(Z,0)+1);
            if(hsmap.get(Z)==2){
                ans.add(Z);
            }
        }
        System.out.println(ans.size());
        Collections.sort(ans);
        for(String X : ans){
            System.out.println(X);
        }

    }
}
