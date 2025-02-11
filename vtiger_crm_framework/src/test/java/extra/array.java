package extra;

import java.util.Iterator;

public class array {

	public static void main(String[] args) {
		Object[] arr = new Object[3];

		arr[0] = "m1";
		arr[1] = 134;
		arr[2] = "m3";

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		Object[][] arr2 = new Object[3][3];
		arr2[0][0] = "0,0";
		arr2[0][1] = "0,1";
		arr2[0][2] = "0,2";
		
		arr2[1][0] = "1,0";
		arr2[1][1] = "1,1";
		arr2[1][2] = "1,2";
		
		arr2[2][0] = "2,0";
		arr2[2][1] = "2,1";
		arr2[2][2] = "2,2";
	
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(arr2[i][j]);
			}
		}
	}
}
