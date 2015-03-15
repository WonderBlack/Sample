import java.util.Arrays;



public class Tes {
	public static void main(String[] args) {

		double x = 1.6;
		System.out.println(x);
		int y = (int) Math.round(x);
		
		System.out.println(y);
		
		int[] test = new int[5];
		System.out.println(Arrays.toString(test));
		System.out.println("配列の長さは" + test.length);

	}
}
