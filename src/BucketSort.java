import java.util.Arrays;
import java.util.Scanner;

public class BucketSort {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("配列の要素数は？");
		int n = stdIn.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("要素[" + i + "]を入力");
			nums[i] = stdIn.nextInt();
		}
		System.out.println("配列は以下の通りです。");
		System.out.println(Arrays.toString(nums));

		int max = max(nums);
		System.out.println("配列の最大値は" + max + "です。");

		int[] b = bucketSort(max, nums, n);

		System.out.println("バケットソート後の配列は以下の通りです。");
		System.out.println(Arrays.toString(b));
	}

	public static int max(int[] x) {
		int max = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] > max) {
				max = x[i];
			}
		}
		return max;
	}

	public static int[] bucketSort(int max, int[] x, int n) {
		int[] bucket = new int[max];// バケットソート様の配列
		Arrays.fill(bucket, -1);// 配列bucketの全ての要素に初期値-1（Empty値）をセット

		int y = 0;// データを移し替える為の変数
		for (int i = 0; i < x.length; i++) {// 配列xを走査し値と同じになっているbucketの添え字に値をセット
			y = x[i];
			bucket[y - 1] = y;
		}
		int[] nums2 = new int[n];// Empty値を除いた数の配列を定義
		int idx = 0;// nums2の為の添え字
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] != -1) {// bucket[i]がEmpty値でなければ
				nums2[idx] = bucket[i];// nums2にbucket[i]の値を代入
				idx++;
			}
		}
		return nums2;
	}

}
