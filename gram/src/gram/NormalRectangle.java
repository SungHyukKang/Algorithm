package gram;
	

public class NormalRectangle {

	long solution(int w , int h ){
		for(int i = 0;i<h;i++){
			for(int j=0;j<w;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		Integer x =1;
		Double z = 2.0;
		if(x instanceof Integer)
			System.out.println();
		return 1;
	}
	public static void main(String[] args) {
		NormalRectangle nr = new NormalRectangle();
		nr.solution(5, 6);
	}

}
