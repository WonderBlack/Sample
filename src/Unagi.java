

import java.util.Arrays;
import java.util.Scanner;

public class Unagi {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String s = stdIn.nextLine();// 座席数nとグループ数m
		String[] s1 = s.split(" ", -1);// それらを配列に格納

		int n = Integer.parseInt(s1[0]);// 座席数
		int m = Integer.parseInt(s1[1]);// グループ数

		System.out.println("座席数は" + n);
		System.out.println("グループ数は" + m);

		int[] nump = new int[m];// 各グループの人数を格納
		int[] seet = new int[m];// 各グループの着座開始位置を格納

		for (int i = 0; i < m; i++) {// 各グループの人数と、着席開始座席番号を入力
			s = stdIn.nextLine();
			String[] s2 = s.split(" ", -1);
			nump[i] = Integer.parseInt(s2[0]);// 各グループの人数を取得
			seet[i] = Integer.parseInt(s2[1]);// 各グループの着座開始位置を取得
		}

		System.out.println("グループの人数の配列" + Arrays.toString(nump));
		System.out.println("着座開始位置の配列" + Arrays.toString(seet));

		for (int i = 0; i < nump.length; i++) {
			System.out.println(i + "番目のグループ");
			System.out.println("人数は" + nump[i]);
			System.out.println("着座開始位置は" + seet[i]);
		}

		// 座席の配列を作成
		int[] seetflg = new int[n];// 空席状況を保存。席が空なら０、埋まったら１。nは座席の総数

		System.out.println("空席状況を保持する配列seetflg" + Arrays.toString(seetflg));
		// ここまでＯＫ

		int idx;// 走査対象のシートの位置を保持

		for (int i = 0; i < m; i++) {// グループの数分、空席状況の確認と着席の処理をする
			// iは走査対象のグループのインデックス
			System.out.println("グループ" + i + "を調べます。");
			if (seetCheck(seetflg, nump[i], seet[i])) {// もしこれから座る席が全て空席なら
				idx = seet[i] - 1;// シートのインデックスに、着座開始位置を代入
				for (int j = 0; j < nump[i]; j++) {// グループの人数分席を埋める
					if (idx >= seetflg.length) {
						idx = 0;// 走査する座席が最後尾まで達したら最初の座席に戻る
					}
					seetflg[idx] = 1;// 座席表の現在捜査対象の場所を埋める
					idx++;// idxを一つずらす
				}
			} else {// これから座る席に一つでも埋まっている席があるなら何もせず次のグループへ

			}
		}

		int sum = 0;
		for (int i = 0; i < seetflg.length; i++) {
			if (seetflg[i] == 1) {
				sum++;
			}
		}

		System.out.println(sum);

	}

	// 座席の空席状況を確認
	static boolean seetCheck(int[] seetflg, int nump, int seet) {
		boolean flg = true;
		int idx = seet - 1;
		System.out.println("座席のインデックスは" + idx);
		System.out.println("ここから" + nump + "人分席を調べます");
		System.out.println("空席状況は" + Arrays.toString(seetflg));

		for (int i = 0; i < nump; i++) {
			if (idx >= seetflg.length) {
				idx = 0;// 走査する座席が最後尾まで達したら最初の座席に戻る
			}
			System.out.println("席" + idx + "をチェック");
			if (seetflg[idx] == 1) {
				System.out.println("席" + idx + "は埋まっています。");
				flg = false;
				break;// 捜査中に埋まっている席を発見したら直ちに走査中止
			} else {
				System.out.println("席は空席です。");
			}
			idx++;
		}
		if (flg == true) {
			System.out.println("このグループが座りたい全ての席は空席です。");
		}
		if (flg == false) {
			System.out.println("座れない人がいるのでこのグループは帰ります。");
		}

		return flg;

	}

}