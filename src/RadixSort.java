import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RadixSort {

	public static void main(String[] args) {

		// int[] x = makeArray();
		int[] x = arrayMaker();
		int max = max(x);
		int digit = digit(max);
		int[] y = bucketSort(x, max);
		radixSort(x, digit);

		System.out.println(Arrays.toString(takeDigit(1548)));

	}

	// 配列を作成
	static int[] makeArray() {
		System.out.println("配列の要素数：");
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("要素[" + i + "]");
			num[i] = stdIn.nextInt();
		}
		System.out.println("出来上がった配列は" + Arrays.toString(num));
		return num;
	}

	// 指定した要素数で配列を作成
	static int[] arrayMaker() {
		System.out.println("配列の要素数：");
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] num = new int[n];
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			num[i] = rnd.nextInt(10000);
		}
		System.out.println("出来上がった配列は" + Arrays.toString(num));
		return num;
	}

	// 最大値を調べる
	public static int max(int[] x) {
		int max = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] > max) {
				max = x[i];
			}
		}
		System.out.println("最大値は" + max + "です。");
		return max;
	}

	// 桁数を調べる
	public static int digit(int max) {
		int cnt = 0;
		int x = max;
		while (x > 0) {
			x = x / 10;
			cnt++;
		}
		System.out.println(max + "の桁数は" + cnt + "です。");
		return cnt;
	}

	// バケットソート
	public static int[] bucketSort(int[] x, int max) {
		int[] y = new int[max];// 最大値と同じ数の配列を作成
		Arrays.fill(y, -1);// いったん配列yのすべての要素に-1（空値）を代入する
		for (int i = 0; i < x.length; i++) {
			y[x[i] - 1] = x[i];// 該当するインデックスに値を入力
		}
		int[] z = new int[x.length];
		int idx = 0;// z[]のインデックス
		for (int i = 0; i < y.length; i++) {
			if (y[i] != -1) {// y[i]が空値じゃなければ
				z[idx] = y[i];// z[idx]にy[i]を代入
				idx++;
			}
		}
		System.out.println("バケットソート後の配列は" + Arrays.toString(z));
		return z;
	}
	
	// ソート
	static int[] sort(int[] x) {
		int max;
		for (int i = 0; i < x.length; i++) {
			max = x[i];// maxにx[0]を代入
			for (int j = 0; j < x.length; j++) {
				if (max < x[j]) {// maxよりx[j]が大きいなら
					max = x[j];// maxにx[j]を代入
					x[j] = x[i];// x[i]とx[j]を交換
					x[i] = max;// x[i]とx[j]を交換
				}
			}
		}
		return x;
	}

	// 各桁の数値を配列にして返す
	public static int[] takeDigit(int n) {// 調査対象の数値n
		int d = digit(n);// digit()を使って桁数を調べる
		int[] num = new int[d];// 桁数分の数値を格納できる配列を作成
		for (int i = 0; i < d; i++) {
			num[i] = n % 10;
			n = n / 10;
		}
		// reverse(num);
		return num;
	}

	// 配列中の２値を交換
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];// 配列の最初の値をtに代入
		a[idx1] = a[idx2];// 配列の最初の要素に最後の要素の値を代入
		a[idx2] = t;// tに入れておいた配列の最初の値を最後の要素に代入
	}

	// 配列の中身を反転
	static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			swap(a, i, a.length - i - 1); // aは配列、iは最初の要素、a.length - i -1は最後の要素
		}
	}

	// 基数ソート（小さい順に並び替える）
	public static void radixSort(int[] x, int digit) { // １桁目でソート int[][]
		int[][] y = new int[10][x.length];// 基数ソートの為の２次元配列を用意
		// いったん配列yのすべての要素に-1（空値）を代入する
		for (int i = 0; i < y.length; i++) {
			for (int j = 0; j < y[i].length; j++) {
				y[i][j] = -1;
			}
		}
		System.out.println("配列に空値-1の挿入が完了しました。" + Arrays.deepToString(y));
		
		int[] a;
		int idx;// y[idx][idx2]
		
		for (int i = 0; i < x.length; i++) {
			int digi = 0;
			int idx2 = 0;// y[idx][idx2]
			a = takeDigit(x[i]);// x[i]を１桁ずつ配列に格納したものを取得
			idx = a[digi];// i + 1桁目を取得
			while (y[idx][idx2] != -1) {// y[idx][idx2]が埋まっていたらidx2を++
				idx2++;
			}
			y[idx][idx2] = x[i];
		}
		System.out.println("配列の状態は" + Arrays.deepToString(y));
		//ひとつの位がおわったら次の位に移る前に２次元目の配列を小さい順にソート

		
	}
	// // 基数ソート（小さい順に並び替える）
	// public static void radixSort(int[] x, int digit) { // １桁目でソート int[][]
	// int[][] y = new int[10][x.length];// 基数ソートの為の２次元配列を用意
	// // いったん配列yのすべての要素に-1（空値）を代入する
	// for (int i = 0; i < y.length; i++) {
	// for (int j = 0; j < y[i].length; j++) {
	// y[i][j] = -1;
	// }
	// }
	// System.out.println("配列に空値-1の挿入が完了しました。" + Arrays.deepToString(y));
	//
	// int n;// 〜桁目の数値が入る変数
	// int d = 10;// 割る数
	//
	// for (int i = 0; i < x.length; i++) {// x[]の全ての要素に対して走査
	// int idx = 0;// ２次元目の配列のインデックス
	// // 　１桁目を取り出す
	// n = x[i] % d;
	// System.out.println("剰余nは" + n);
	// System.out.println("現在の着目要素は" + y[n][idx]);
	// while (y[n][idx] != -1) {// idxが空値の-1でなければidxを++する
	// idx++;// y[n][idx]の埋まっていない所を探す
	// System.out.println("idxを++");
	// }
	// y[n][idx] = x[i];// y[n][idx]にx[i]の値を格納
	//
	// }
	// System.out.println(Arrays.deepToString(y));
	// }

}
