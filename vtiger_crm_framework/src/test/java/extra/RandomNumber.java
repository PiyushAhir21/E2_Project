package extra;

import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		Random ran = new Random();
		int random = ran.nextInt(100000000);
		System.out.println(random);
		System.out.println("all is well and hell");
		

		
		
		System.out.println((int)(Math.random()*1000));
	}
}
