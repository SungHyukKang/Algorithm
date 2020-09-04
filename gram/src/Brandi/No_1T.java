package Brandi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No_1T {
	public static int[] arr;
	public static Scanner sc = new Scanner(System.in);
	public static String input ="";
	public static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
public static void main(String[] args)throws IOException {
        No_1T mainClass = new No_1T();
        mainClass.doSomething();
        return;
    }
    public void doSomething()throws IOException {
        final Thread currentThread = Thread.currentThread();
        Thread killerThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    
                } catch (InterruptedException e) {
                    return;
                    
                } catch (Exception e) {
                    // 무시
                }
                
                try {
                    currentThread.interrupt();
                    for(int i =0;i<arr.length;i++) {
                    	System.out.print(arr[i]+" ");
                    }
                    System.exit(0);
                    
                } catch (Exception e) {
                }
            }
        };
            
            
        try {
            killerThread.start();
    		arr = new int[6];
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		double age = Double.parseDouble(st.nextToken());
    		double maximum = 220-age;
    		while((input = br.readLine())!=null) {
    			int X = Integer.parseInt(input);
    			if(X>=maximum*0.9) {
    				arr[0]++;
    			}else if(X>=maximum*0.8) {
    				arr[1]++;
    			}else if(X>=maximum*0.75) {
    				arr[2]++;
    			}else if(X>=maximum*0.68) {
    				arr[3]++;
    			}else if(X>=maximum*0.6) {
    				arr[4]++;
    			}else {
    				arr[5]++;
    			}
    		}
        }  catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            // 킬러 Thread 종료
            try {
                killerThread.interrupt();
            } catch (Exception e) {
                // 무시
            }
        }
        return;
    }
} 


