package thread._16_4;



/**
 * 1.join()方法：让一个线程等待另一个线程完成的方法。
 * 2.join()方法通常由使用线程的程序调用，以将大问题划分成许多小问题，每个小问题分配一个线程。
 * 当所有的小问题都得到处理后，再调用主线程来进一步操作。
 * 3.join()方法有如下三种重载形式：
 * （1）join() 等待被join的线程执行完成。
 * （2）join(long millis) 等待被join的线程的时间最长为millis毫秒。如果在millis毫秒内被join的线程还没有执行结束，则不再等待。
 * （3）join(long millis, int nanos) 等待被join的线程的时间最长为millis毫秒加nanos毫微秒。
 */
public class JoinThread extends Thread
{
	// 提供一个有参数的构造器，用于设置该线程的名字
	public JoinThread(String name)
	{
		super(name);
	}
	// 重写run()方法，定义线程执行体
	public void run()
	{
		for (int i = 0; i < 3 ; i++ )
		{
			System.out.println(getName() + "  " + i);
		}
	}
	public static void main(String[] args)throws Exception
	{
		// 启动子线程
		new JoinThread("新线程").start();
		for (int i = 0; i < 10 ; i++ )
		{
			if (i == 5)
			{
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				// main线程调用了jt线程的join()方法，main线程必须等jt执行结束才会向下执行
				jt.join();
			}
			System.out.println(Thread.currentThread().getName()
				+ "  " + i);
		}
	}
}
