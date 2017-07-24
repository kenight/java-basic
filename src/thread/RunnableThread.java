package thread;

public class RunnableThread implements Runnable {

	private String str;

	public RunnableThread(String str) {
		this.str = str;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(str + ":" + i);
		}
	}

	public static void main(String[] args) {
		new Thread(new RunnableThread("T1")).start();
		new Thread(new RunnableThread("T2")).start();
	}

}
