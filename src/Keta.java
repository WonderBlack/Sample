import java.util.Scanner;


public class Keta {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int x;
		System.out.println("正の数値を入力してください。");
		x = stdIn.nextInt();
		while (x < 0) {
			System.out.println("正の数値を入力してください。");
			x = stdIn.nextInt();
		}
		int cnt = 1;
		
		for (int i = 0; x > 9; i++) {
			x = x / 10;
			cnt++;
		}
		
		System.out.println("桁数は" + cnt);
		
	}
}
