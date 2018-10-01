
public class Tip {
	private int tips=0;
	private int ten_tips;
	private int tip;
	public Tip(int tips){
		addTips(tips);
	}
	public void addTips(int add_tips) {
		this.tips+=add_tips;
		ten_tips=tips/10;
		tip=tips%10;
	}
	public int getTips() {
		return tips;
	}
	public int getTen_tips() {
		return ten_tips;
	}
	public int getTip() {
		return tip;
	}
	public void display_tips() {
		System.out.println("保有点"+tips+"[10]:"+ten_tips+"[1]:"+tip);
	}

}
