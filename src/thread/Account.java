package thread;

public class Account {

	private int money;

	public Account(int money) {
		this.money = money;
	}

	// 业务方法
	public void plus(int cash) {
		try {
			synchronized (this) {
				int last = money;
				Thread.sleep(1); // 模拟一个延迟
				money += cash;
				System.out.println(Thread.currentThread().getName() + ": 钱包: " + last + " 消费: " + cash + " 余额: " + money);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
