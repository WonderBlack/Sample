import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String s = stdIn.nextLine();// 座席数nとグループ数m
		String[] s1 = s.split(" ", -1);// それらを配列に格納

		int n = Integer.parseInt(s1[0]);// 座席数
		int m = Integer.parseInt(s1[1]);// グループ数

		int[] pnum = new int[m];// グループの人数を格納
		int[] snum = new int[m];// 着座開始位置を格納

		for (int i = 0; i < m; i++) {// 各グループの人数と、着席開始座席番号を入力
			s = stdIn.nextLine();
			String[] s2 = s.split(" ", -1);
			pnum[i] = Integer.parseInt(s2[0]);
			snum[i] = Integer.parseInt(s2[1]);
		}
		
		// 座席の配列を作成
		int[] seet = new int[n];// 席が空なら０、埋まったら１
		
		//　試しにひと組着席
		for (int i = 0; i < m; i++) {
			int snum2 = snum[i];// 着座開始位置を変数に格納
			int pnum2 = pnum[i];// グループの人数を変数に格納
			if (seet[snum2] == 1) {// そのシートが埋まっていたら何もしない
				
			}
		}

		
		
		
//		System.out.println(Arrays.toString(pnum));
//		System.out.println(Arrays.toString(snum));
		
		


	}

	// String[]をint[]に変換
	static int[] change(String[] x) {
		int[] y = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			y[i] = Integer.parseInt(x[i]);
		}
		return y;
	}

}