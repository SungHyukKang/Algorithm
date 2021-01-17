import java.math.BigInteger;

public class 멀쩡한사각형 {
	public static int gcd(int big ,int small){
        if(big%small==0){
            return small;
        }
        return gcd(small,big%small);
    }
    public static long solution(int w, int h) {
        
        int x = gcd(Math.max(w,h),Math.min(h,w));
        int c = (w+h)-x;
        BigInteger bi = new BigInteger(Integer.toString(w));
        BigInteger bi2 = new BigInteger(Integer.toString(h));
        BigInteger bi3 = new BigInteger(Integer.toString(c));
        return bi.multiply(bi2).subtract(bi3).longValue();
    }
	public static void main(String[] args) {
		System.out.println(solution(99999999,89581231));
	}

}
