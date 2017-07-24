package thread;

// 实现线程有两种方法
// 1. 继承 Thread 类, 重新 run 方法, 调用类的 start 方法启动线程
// 2. 实现 Runnable 接口, 实现 run 方法, 通过 new Thread(Runnable).start() 启动线程
// 线程有五种状态, 创建、就绪、运行、阻塞、死亡
// 创建: 实例化对象
// 就绪: 实例化对象, 调用 start 方法
// 运行: 线程调度器将就绪的线程设置为当前线程
// 阻塞: 线程正在运行时, 被暂停之后再继续运行, 如 sleep suspend wait 等方法导致线程阻塞
// 死亡: run 执行完毕或调用 stop 方法
// start 和 run 方法区别: 
// start 方法启动线程, 实现多线程运行(并行)
// run 方法为普通方法调用, 程序按调用顺序执行
public class ExtendThread extends Thread {

	private String str;

	public ExtendThread(String str) {
		this.str = str;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(str + ":" + i);
		}
	}

	public static void main(String[] args) {
		new ExtendThread("T1").start();
		new ExtendThread("T2").start();
	}

}
