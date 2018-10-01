import java.util.Scanner;

public class BigOrSmall {

	public BigOrSmall() {

	}
	public boolean judge(Card card1,Card card2) {
		if(card1.getNumber()>card2.getNumber()) {
			return false;
		}else if(card1.getNumber()<card2.getNumber()) {
			return true;
		}else {
			if(card1.getMark()<card2.getMark()) {
				return false;
			}else {
				return true;
			}
		}


	}
	public void game() {
		Tip tip = new Tip(20);
		System.out.println("*******チップ枚数とカード********");
		tip.display_tips();
		System.out.println("********カードを配ります********");
		Deck deck = new Deck();
		Card first_card = deck.take();
		System.out.println(first_card);
		Scanner scn = new Scanner(System.in);
		int next_game;
		int bet;
		do {
			do {
				System.out.println("*****ベットするチップを1~20枚で選択してください******");
				bet = scn.nextInt();
			} while (bet <= 0 && bet > 20 && tip.getTips() < 0);
			int num;
			int proceed;
			do {
				tip.addTips(-bet);
				do {
					System.out.println("[Big or Small]: 0:Big 1:Small");
					num = scn.nextInt();
				} while (num != 0 && num != 1);
				if (deck.getRest() == 0) {
					System.out.println("デッキに残っているカードがないので、山札を初期化します。");
					deck.initialization();
				}
				Card bet_card = deck.take();
				boolean act = judge(first_card, bet_card);
				System.out.println("*****Big or Small*********");
				System.out.println("ベット数:"+bet);
				System.out.println("現在のカード:"+first_card);
				System.out.println("引いたカード:"+bet_card);
				first_card = bet_card;
				if ((num == 0 && act) || (num == 1 && !act)) {
					System.out.println("Win!!");
					bet *= 2;
					tip.addTips(bet);
				} else {
					System.out.println("Lose");
					tip.display_tips();

					break;
				}
				do {
					System.out.println("獲得したチップ" + bet + "枚でゲームを続けますか。 0:yes 1:no");
					proceed = scn.nextInt();
				} while (proceed != 0 && proceed != 1);
			} while (proceed == 0);
			do {
				if (tip.getTips() == 0) {
					System.out.println("チップが0枚になりました。ゲームを終了します。");
					return;
				}
				System.out.println("もう一度ゲームを行いますか。0:yes 1:no");
				next_game = scn.nextInt();
			} while (next_game != 0 && next_game != 1);
		} while (next_game == 0);
	}
}
