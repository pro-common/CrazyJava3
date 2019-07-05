package thread._16_3;

/**
 * 不要对于死亡状态的线程调用 start() 方法，程序只能对新建状态的线程调用 start() 方法，
 * 对新建状态的线程两次调用 start() 方法也是错误的，这都会引入 IllegalThreadStateException 异常。
 */
public class StartDead extends Thread
{
	private int i ;
	// 重写run方法，run方法的方法体就是线程执行体
	public void run()
	{
		for ( ; i < 100 ; i++ )
		{
			System.out.println(getName() +  " " + i);
		}
	}
	public static void main(String[] args)
	{
		// 创建线程对象
		StartDead sd = new StartDead();
		for (int i = 0; i < 300;  i++)
		{
			// 调用Thread的currentThread方法获取当前线程
			System.out.println(Thread.currentThread().getName()
				+  " " + i);
			if (i == 20)
			{
				// 启动线程
				sd.start();
				// 判断启动后线程的isAlive()值，输出true
				System.out.println(sd.isAlive());
			}
			// 只有当线程处于新建、死亡两种状态时isAlive()方法返回false。
			// 当i > 20，则该线程肯定已经启动过了，如果sd.isAlive()为假时，
			// 那只能是死亡状态了。
			if (i > 20 && !sd.isAlive())

			{
				// 试图再次启动该线程
				sd.start();
			}
		}
	}
}

