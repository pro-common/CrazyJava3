package thread._16_4;



/**
 * 线程让步：yield
 * 1.让当前正在执行的线程暂停，但它不会阻塞改线程，它只是将该线程转入就绪状态。
 * 只是让当前线程暂停一下，让系统的线程调度器重新调度一次，王权可能的情况是：当
 * 某个线程调用了yield()方法暂停之后，线程调度又将其调度出来重新执行。
 * 2.当某个线程调用了yeild()方法暂停之后，只有优先级与当前线程相同，或者
 * 优先级比当前线程更高的处于就绪状态的线程才会获得执行的机会
 */
public class YieldTest extends Thread
{
	public YieldTest(String name)
	{
		super(name);
	}
	// 定义run方法作为线程执行体
	public void run()
	{
		for (int i = 0; i < 50 ; i++ )
		{
			System.out.println(getName() + "  " + i);
			// 当i等于20时，使用yield方法让当前线程让步
			if (i == 20)
			{
				Thread.yield();
			}
		}
	}
	public static void main(String[] args)throws Exception
	{
		// 启动两条并发线程
		YieldTest yt1 = new YieldTest("高级");
		// 将ty1线程设置成最高优先级
		yt1.setPriority(Thread.MAX_PRIORITY);
		yt1.start();
		YieldTest yt2 = new YieldTest("低级");
		// 将yt2线程设置成最低优先级
		yt2.setPriority(Thread.MIN_PRIORITY);
		yt2.start();
	}
}
