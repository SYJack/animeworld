package animeworld;

public class DrawThread extends Thread {
	private String name;//操作人
	private MyCount myCount;//账户
	private int x;//取款金额
		
	
	public DrawThread(String name, MyCount myCount, int x) {
		this.name = name;
		this.myCount = myCount;
		this.x = x;
	}


	@Override
	public void run() {
		myCount.drawing(name, x);
	}
}
