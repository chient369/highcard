package highcard;

import common.Card;
import common.CardHandler;
import common.GameInput;
import common.GameProcess;
import common.player.GamePlayer;

public class HighCardGameProcess {
	private GameProcess gameProcess;
	private GamePlayer player;

	public HighCardGameProcess() {
	}

	public HighCardGameProcess(GameProcess gameProcess) {
		super();
		this.setGameProcess(gameProcess);
		this.player = gameProcess.getPlayer();

	}

	public GamePlayer getPlayer() {
		return gameProcess.getPlayer();
	}

	public void gameProccess() {
		boolean keizoku = true;
		System.out.println("ゲーム開始");
		System.out.println("🥀🥀🥀🥀🥀🥀🥀🥀🥀🥀");
		player.showPlayer();
		while (keizoku) {
			System.out.print("掛け金を入力してください : ");
			int kakekin = GameInput.inputKakekin();

			if (kakekin == 9999) {
				System.out.println("ゲーム終了");
				System.out.println("+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			while (kakekin > player.getShojikin()) {
				System.out.println("所持金以下の掛け金を入力してください　");
				kakekin = GameInput.inputKakekin();

			}

			CardHandler card_1 = new CardHandler();
			System.out.println("一枚目 : " + card_1.getCardFull());

			System.out.println("二枚目 は 一枚目1 より： \n 0. 弱い \n 1. 強い \n 2. ピタリ賞を狙う");
			int sentaku = GameInput.inputSentaku();
			CardHandler card_2 = new CardHandler();
			if (sentaku != 2) {
				System.out.println("二枚目 : " + card_2.getCardFull());
			}
			kekka(sentaku, card_1, card_2, kakekin);
			GamePlayer player = getPlayer();
			if (player.getShojikin() < 100 || player.getShojikin() > 100000) {
				if (player.getShojikin() < 0) {
					player.saigo(kakekin);
				}
				System.out.println("ゲーム終了");
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+");

				keizoku = false;
			}

		}

	}

	public void kekka(int sentaku, CardHandler card_1, CardHandler card_2, int kakekin) {
		if (sentaku == 0) {
			if (card_1.isBiggerThan(card_2)) {
				player.kachi(kakekin);
				player.showPlayer();

			} else {
				player.make(kakekin);
				player.showPlayer();
			}

		} else if (sentaku == 1) {
			if (card_2.isBiggerThan(card_1)) {
				player.kachi(kakekin);
				player.showPlayer();
			} else {
				player.make(kakekin);
				player.showPlayer();
			}
		} else if (sentaku == 2) {
			pitari(card_2, kakekin);
		} else {
			System.err.println("正しく選択してください");
		}
	}

	public void pitari(CardHandler card_2, int kakekin) {
		Card sentakuCard = subPitari();
		System.out.println("あなたの選択したカードは " + sentakuCard.getCardFull());
		System.out.println("結果。。。。  二枚目　は " + card_2.getCardFull());
		if (sentakuCard.getCardFull().equals(card_2.getCardFull())) {
			System.out.println("おめでとうございます！🎆🎆🎆");
			System.out.println("BIGピタリ賞  :  \n" + 20 * kakekin);
			player.pitari(kakekin);
			player.showPlayer();

		}
		if (card_2.getCardNum() == sentakuCard.getCard_num()) {
			System.out.println("おめでとうございます！🎆🎆🎆");
			System.out.printf("ピタリ賞 : %d \n", 12 * kakekin);
			player.pitari(kakekin);
			player.showPlayer();
		} else {
			System.out.println("惜しかったね！\n");
		}
	}

	private static Card subPitari() {
		Card pitariCard = null;
		System.out.print("次のカードはどの数値と思いますか : ");
		int yosoku = GameInput.inputCard();
		boolean loopCheck = true;
		System.out.println("絵柄は: 1. ♥  2. ♣  3. ♦  4. ♠");
		int sentk = GameInput.inputChoose();
		while (loopCheck) {
			switch (sentk) {
			case 1:
				pitariCard = new CardHandler().setCard(yosoku, "♥");
				break;
			case 2:
				pitariCard = new CardHandler().setCard(yosoku, "♣");
				break;
			case 3:
				pitariCard = new CardHandler().setCard(yosoku, "♦");
				break;
			case 4:
				pitariCard = new CardHandler().setCard(yosoku, "♠");
				break;
			default:
				System.out.println("正しく選択してください");
				sentk = GameInput.inputChoose();
				break;

			}
			if (pitariCard != null) {
				loopCheck = false;
			}

		}
		return pitariCard;
	}

	public GameProcess getGameProcess() {
		return gameProcess;
	}

	public void setGameProcess(GameProcess gameProcess) {
		this.gameProcess = gameProcess;
	}

//	public static void main(String[] args) {
//		System.out.println(subPitari().getCardFull());
//	}

}
