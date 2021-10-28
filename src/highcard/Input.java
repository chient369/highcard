<<<<<<< HEAD:src/game/highcard/Input.java
<<<<<<< HEAD:src/game/highcard/Input.java
<<<<<<< HEAD:src/game/highcard/Input.java
<<<<<<< HEAD
=======
>>>>>>> parent of d0400a3 (add gamepoker):src/highcard/Input.java
=======
>>>>>>> parent of d0400a3 (add gamepoker):src/highcard/Input.java
package game.highcard;
=======
package highcard;
>>>>>>> parent of 942a95f (rename and add gamepoker pj):src/highcard/Input.java

import java.util.Scanner;

import game.common.GameInput;

public final class Input extends GameInput {
	private static Scanner sc = new Scanner(System.in);
=======
<<<<<<< HEAD:src/game/common/GameInput.java
package game.common;
=======
package game.highcard;
>>>>>>> parent of d0400a3 (add gamepoker):src/game/highcard/Input.java

import java.util.Scanner;

public class GameInput {
	private static Scanner sc = new Scanner(System.in);

	public static int inputKakekin() {
		int kakekin = 0;
		String input = sc.next();
		boolean check = true;
		while (check) {
			try {
				kakekin = Integer.parseInt(input);
				check = false;
				if (kakekin < 0) {
					System.err.println("非負の掛け金を入力してください");
					input = sc.next();


				}

			} catch (Exception e) {
				System.err.println("正しく入力してください");
				input = sc.next();

			}
		}
		return kakekin;
	}
>>>>>>> parent of d0400a3 (add gamepoker)
	public static int inputCard() {
		int card = 0;
		String input = sc.next();
		boolean check = true;
		while (check) {
			try {
				card = Integer.parseInt(input);
				check = false;
				if (card < 1 || card > 13) {
					System.err.println("予測のカードは1以上、13以下を入力すること！");
					input = sc.next();
					check = true;

				}

			} catch (Exception e) {
				System.err.println("正しく入力してください");
				input = sc.next();
				check = true;
			}
		}
		return card;
	}

	public static int inputSentaku() {
		int sentaku = 0;
		String input = sc.next();
		boolean check = true;
		while (check) {

			try {
				sentaku = Integer.parseInt(input);
				check = false;
				if (sentaku < 0 || sentaku > 2) {
					System.err.println("正しく選択してください");
					input = sc.next();
					check = true;
				}
			} catch (Exception e) {
				System.err.println("正しく入力してください");
				input = sc.next();
				check = true;

			}
		}
		return sentaku;
	}
	public static int inputChoose() {
		int choose = 0;
		String input = sc.next();
		boolean check = true;
		while (check) {

			try {
				choose = Integer.parseInt(input);
				check = false;

			} catch (Exception e) {
				System.err.println("正しく入力してください");
				input = sc.next();
				check = true;

			}
		}
		return choose;
	}


}