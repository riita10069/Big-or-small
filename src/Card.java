
public class Card {
	private int mark;
	private int number;

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Card(int mark,int number) {
		this.mark = mark;
		this.number = number;
	}

	public String toString() {
		String card_mark="";
		switch(getMark()) {
		case 0:
			card_mark="スペード";
			break;
		case 1:
			card_mark="ハート";
			break;
		case 2:
			card_mark="ダイヤ";
			break;
		case 3:
			card_mark="クラブ";
			break;
		}
		return card_mark+getNumber();
	}


}
