package extra;

import java.util.Random;

public class RandomNumber {
	public static void main(String[] args) {
		Random ran = new Random();
		int random = ran.nextInt(100000000);
		System.out.println(random);
		
		
		
		String s="my name is ankush";
		char c1=s.charAt(3);
		System.out.println(c1);
		
		System.out.println((int)(Math.random()*1000));
	}
}
