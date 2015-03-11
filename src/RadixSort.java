import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {

	public static void main(String[] args) {

		int[] x = makeArray();
		int max = max(x);
		int digit = digit(max);
		int[] y = bucketSort(x, max);
		int[] bk = radixSort(x, digit);

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
		int cnt = 1;
		int x = max;
		while (x > 9) {
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
		int z = 0;// 配列の値を仮置きする変数
		for (int i = 0; i < x.length; i++) {
			z = x[i];
			y[z - 1] = z;// 該当するインデックスに値を入力
		}
		int idx = 0;// x[]のインデックス
		for (int i = 0; i < y.length; i++) {
			if (y[i] != -1) {// y[i]が空値じゃなければ
				x[idx] = y[i];// x[idx]にy[i]を代入
				idx++;
			}
		}
		System.out.println("バケットソート後の配列は" + Arrays.toString(x));
		return x;
	}

	// 基数ソート（小さい順に並び替える）
	public static int[] radixSort(int[] x, int digit) {
		// １桁目でソート
		int[] bk = new int[9];// ソート用の配列
		int z = 0;// 配列の値を仮置きする変数
		int mlt = 10;
		for (int i = 0; i < digit; i++) {// 桁数分繰り返す
			for (int j = 0; j < x.length; j++) {
				z = (x[j] % mlt);
				bk[z - 1] = z;// 該当のインデックスに値を格納
			}
			System.out.println("現在の配列は" + Arrays.toString(bk));
			x = bk;
			System.out.println("配列をコピーしました。" + Arrays.toString(x));
			mlt *= 10;// １つ上の位に移る
		}

		return bk;

	}

}
