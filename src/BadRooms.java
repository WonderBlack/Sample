

import java.util.Scanner;

public class BadRooms {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String n = stdIn.next();// 嫌いな数字
		int m = stdIn.nextInt();// 病室の総数

		String[] room = new String[m];

		// 病室の番号を配列に格納
		for (int i = 0; i < m; i++) {
			String r = stdIn.next();
			room[i] = r;
		}

		String[] gr = new String[m];// 　可能な部屋リスト

		int idx = 0;// grのインデックス
		int cnt = 0;// 希望部屋の個数
		for (int i = 0; i < m; i++) {

			if (room[i].matches(".*" + n + ".*")) {// 部屋番号に嫌いな数を含んでいたら

			} else {
				gr[idx] = room[i];
				idx++;
				cnt++;
			}
		}

		if (cnt == 0) {
			System.out.println("none");
		} else {
			for (int i = 0; i < cnt; i++) {
				System.out.println(gr[i]);
			}
		}

	}

}