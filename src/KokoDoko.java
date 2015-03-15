

import java.util.Arrays;
import java.util.Scanner;

public class KokoDoko {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		String s = stdIn.nextLine();// マップの横幅w、マップの縦幅h、移動ログの個数n
		String[] s1 = s.split(" ", -1);// それらを配列に格納

		int w = Integer.parseInt(s1[0]);// マップの横幅
		int h = Integer.parseInt(s1[1]);// マップの縦幅
		int n = Integer.parseInt(s1[2]);// 移動ログの個数

		s = stdIn.nextLine();
		s1 = s.split(" ", -1);

		int x;// 現在地x左右方向
		int y;// 現在地y上下方向

		x = Integer.parseInt(s1[0]);// 現在地xの初期値
		y = Integer.parseInt(s1[1]);// 現在地yの初期値

		String[] way = new String[n];// 移動方向を格納
		int[] dist = new int[n];// 移動距離を格納

		// 移動ログを入力
		for (int i = 0; i < n; i++) {
			s = stdIn.nextLine();// 移動方向way[i]移動距離dist[i]を入力
			s1 = s.split(" ", -1);
			way[i] = s1[0];// 移動方向を配列に格納
			dist[i] = Integer.parseInt(s1[1]);// 移動距離を配列に格納
		}

		for (int i = 0; i < n; i++) {// 移動ログの個数n分移動
			
			if (way[i].equals("U")) {// もし上に動いたら y+方向
				for (int j = 0; j < dist[i]; j++) {// 移動距離dist[i]分動く
					y++;
					if (y >= h) {// もしマップの上端に達したら下端0に移動
						y = 0;
					}
				}
			}
			if (way[i].equals("D")) {// もし下に動いたら y-方向
				for (int j = 0; j < dist[i]; j++) {// 移動距離dist[i]分動く
					y--;
					if (y < 0) {// もしマップの下端に達したら上端hに移動
						y = h - 1;
					}
				}
			}
			if (way[i].equals("R")) {// もし右に動いたら x+方向
				for (int j = 0; j < dist[i]; j++) {// 移動距離dist[i]分動く
					x++;
					if (x >= w) {// もしマップの右端に達したら左端に移動
						x = 0;
					}
				}
			}
			if (way[i].equals("L")) {// もし左に動いたら x-方向
				for (int j = 0; j < dist[i]; j++) {// 移動距離dist[i]分動く
					x--;
					if (x < 0) {// もしマップの左端に達したら右端wに移動
						x = w - 1;
					}
				}
			}
			
		}
		
		System.out.println(x + " " + y);

	}

}