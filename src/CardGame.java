import java.util.Scanner;

public class CardGame {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String s = stdIn.nextLine();// 親カードの読み取り
		String[] s1 = s.split(" ", -1);// それらを配列に格納

		int[] pc = change(s1);
		Parent p = new Parent(pc[0], pc[1]);

		int n = stdIn.nextInt();

		Child[] cds = new Child[n];// 小カードを納める配列

		for (int i = 0; i < n; i++) {// 小カードの読み取り
			s = stdIn.nextLine();// 子カードの読み取り
			String[] s3 = s.split(" ", -1);// 分割し一時的に配列に格納
			int[] cc = change(s3);// 文字列から数値に変換
			Child c = new Child(cc[0], cc[1]);// 小カードのインスタンス生成
			cds[i] = c;// 配列に格納
		}

		for (int i = 0; i < cds.length; i++) {
			if (p.first > cds[i].first) {
				System.out.println("High");
			} else if (p.first == cds[i].first) {
				if (p.second > cds[i].second) {
					System.out.println("High");
				} else {
					System.out.println("Low");
				}
			} else {
				System.out.println("Low");
			}
		}

	}

	// String[]をint[]に変換
	static int[] change(String[] x) {
		int[] y = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			y[i] = Integer.parseInt(x[i]);
		}
		return y;
	}

	public static class Parent {
		int first;
		int second;

		public Parent(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static class Child {
		int first;
		int second;

		public Child(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}