import java.io.*;
import java.util.ArrayList;
import java.util.*;

class Parent {
	public void paint() {
		draw();
	}
	
	public void draw() {
		draw();
		System.out.println("Parent");
	}
}


class Child extends Parent{
	
	public void paint() {
		super.draw();
	}
	
	public void draw() {
		System.out.println("Child");
	}
	
}


public class gaehaeng {

	public static void main(String[] args)throws IOException {
		Parent cp = new Child();
		cp.paint();
		
		
			}

}
