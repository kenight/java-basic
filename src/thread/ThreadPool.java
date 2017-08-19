package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.junit.Test;

public class ThreadPool {

	// 创建一个固定数量的线程池 pool-1
	Executor executor = Executors.newFixedThreadPool(10);

	Runnable task = new Runnable() {
		@Override
		public void run() {
			System.out.println("当前线程:" + Thread.currentThread().getName());
		}
	};

	@Test
	public void runTask() {
		for (int i = 0; i < 15; i++) {
			executor.execute(task);
			// new Thread(task).start();
		}
	}

}
