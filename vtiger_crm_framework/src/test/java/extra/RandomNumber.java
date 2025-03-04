package extra;

import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		Random ran = new Random();
		int random = ran.nextInt(100000000);
		System.out.println(random);
		
		System.out.println((int)(Math.random()*10000));
		System.out.println("change");
	}
}
