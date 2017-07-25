package thread;

public class SynchronizedThread extends Thread {

	private Account account;
	private int cash;

	public SynchronizedThread(String name, Account account, int cash) {
		super(name);
		this.account = account;
		this.cash = cash;
	}

	@Override
	public void run() {
		account.plus(cash);
	}

	public static void main(String[] args) {
		Account at = new Account(100);
		for (int i = 0; i < 5; i++) {
			new SynchronizedThread("A" + i, at, -10).start();
		}
	}

}
