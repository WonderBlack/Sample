import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortSample {

	public static void main(String[] args) {

		int[] num3 = { 5, 4, 3, 2, 1 };

		int[] num = arrayMaker();
		//System.out.println(Arrays.toString(num3));
		int[] num2 = simpleSort(num);
		System.out.println(Arrays.toString(num2));

	}

	// 指定した要素数で配列を作成
	static int[] arrayMaker() {
		System.out.println("配列の要素数：");
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] num = new int[n];
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			num[i] = rnd.nextInt(100);
		}
		System.out.println("出来上がった配列は");
		System.out.println(Arrays.toString(num));
		return num;
	}

	// ソート
	static int[] sort(int[] x) {
		int max;
		for (int i = 0; i < x.length; i++) {
			System.out.println("外側のfor文" + i + "周目");
			System.out.println("配列は" + Arrays.toString(x));
			max = x[i];// maxにx[0]を代入
			System.out.println("maxにx[" + i + "]" + x[i] + "を代入");
			for (int j = 0; j < x.length; j++) {

				System.out.println("max" + max + "とx[j]" + x[j] + "を比べます。");
				if (max < x[j]) {// maxよりx[j]が大きいなら
					System.out.println("max" + max + "よりx[j]" + x[j]
							+ "が大きいので交換します。");
					max = x[j];// maxにx[j]を代入
					x[j] = x[i];// x[i]とx[j]を交換
					x[i] = max;// x[i]とx[j]を交換
				}
			}
		}
		return x;
	}

	static int[] simpleSort(int[] x) {
		for (int i = 0; i < x.length; i++) {
			int max = x[i];
			int j;
			int y = 0;
			for (j = y; j < x.length; j++) {
				if (max < x[j]) {// minよりx[j]が大きかったら
					max = x[j];
					x[j] = x[i];
					x[i] = max;
				}
				y++;
			}
		}
		return x;
	}
}
