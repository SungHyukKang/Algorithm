package Brandi;

public class No_1TT {

	 public static void main(String[] args) {
	        
	        System.out.println("메서드 호출하기 전");
	        
	        No_1TT mainClass = new No_1TT();
	        mainClass.doSomething();
	        
	        System.out.println("메서드 호출 이후");
	    }

	    
	    public void doSomething() {
	        
	        System.out.println("프로세스 시작");
	        
	        // 현재 Thread 를 변수에 저장
	        final Thread currentThread = Thread.currentThread();
	        
	        // 일정시간 지나면 현재 Thread 를 종료
	        Thread killerThread = new Thread() {
	            
	            @Override
	            public void run() {
	                try {
	                    // 1분 후 종료
	                    Thread.sleep(1500);
	                    
	                } catch (InterruptedException e) {
	                    // 킬러 Thread 종료(killerThread.interrupt())하면 이곳에 도달
	                    System.out.println("프로세스 종료");
	                    return;
	                    
	                } catch (Exception e) {
	                    // 무시
	                }
	                
	                try {
	                    // 일정시간이 지나면 이곳에 도달
	                    System.out.println("시간초과로 인해 종료합니다.");
	                    
	                    // 현재 Thread 를 종료
	                    currentThread.interrupt();
	                    
	                } catch (Exception e) {
	                    // 무시
	                }
	            }
	        };
	            
	            
	        try {
	            // 일정시간 지나면 현재 Thread 를 종료
	            killerThread.start();
	            
	            int limit = 999999;
	            for (int i=0; i<limit; i++) {
	                System.out.println("진행중... (" + (i+1) + " / " + limit + ")");
	                Thread.sleep(30);
	            }
	            
	        } catch (InterruptedException e) {
	            System.out.println("프로세스가 너무 오래 실행되고 있습니다. 프로세스를 종료합니다.");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        } finally {
	            // 킬러 Thread 종료
	            try {
	                killerThread.interrupt();
	            } catch (Exception e) {
	                // 무시
	            }
	        }
	    }

}
