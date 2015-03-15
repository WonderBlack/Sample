import java.util.Scanner;

public class EuclideanAlgorithm {
	public static void main(String[] args) {

		int x;
		int y;
		int r = 1;

		Scanner stdIn = new Scanner(System.in);
		System.out.println("ｘの値は？");
		x = stdIn.nextInt();
		System.out.println("ｙの値は？");
		y = stdIn.nextInt();
		int x2 = x;
		int y2 = y;

		while (r != 0) {
			r = x % y;
			x = y;
			y = r;
		}

		System.out.println(x2 + "と" + y2 + "の最大公約数は" + x);
	}

}
