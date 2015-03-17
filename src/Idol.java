

import java.util.Arrays;
import java.util.Scanner;

public class Idol {

	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);
		String str = stdIn.nextLine();// 会員数N、イベント数M
		String[] s = str.split(" ", -1);// それらを配列に格納

		int sum = 0;// イベントの最大利益を足し込む変数

		int N = Integer.parseInt(s[0]);// 会員数N
		int M = Integer.parseInt(s[1]);// イベント数M

		int[][] live = new int[M][N];// イベント事の損益を格納

		if (N == 0 || M == 0) {// 会員数もしくはイベント数が０なら何もしない

		} else {
			for (int i = 0; i < M; i++) {// イベントの回数M分各会員の損益を入力
				str = stdIn.nextLine();
				s = str.split(" ", -1);
				for (int j = 0; j < s.length; j++) {
					int x;
					x = Integer.parseInt(s[j]);
					live[i][j] = x;

				}
			}

			// System.out.println(Arrays.deepToString(live));

			// イベント事の損益を集計し、マイナスならsumに足さない
			for (int i = 0; i < M; i++) {
				int cnt = 0;// イベント事の損益
				for (int j = 0; j < N; j++) {
					cnt += live[i][j];
				}
				if (cnt > 0) {
					sum += cnt;
				}
			}
		}

		System.out.println(sum);
	}

}