package thread._16_4;



/**
 * 线程优先级 setPriority / getpriority
 * 1.每个线程默认的优先级都与创建它的父线程的优先级相同，在默认情况下，main 线程具有普通优先级，
 * 由main线程创建的子线程也具有普通优先级。
 * 2.setPriority()方法的参数可以是一个整数，范围是1~10之间，也可以使用Thread类的三个静态常量：
 * （1）max_priority：其值是 10
 * （2）min_priority：其值是 1
 * （3）norm_priority：其值是 5
 */
public class PriorityTest extends Thread
{
	// 定义一个有参数的构造器，用于创建线程时指定name
	public PriorityTest(String name)
	{
		super(name);
	}
	public void run()
	{
		for (int i = 0 ; i < 50 ; i++ )
		{
			System.out.println(getName() +  ",其优先级是："
				+ getPriority() + ",循环变量的值为:" + i);
		}
	}
	public static void main(String[] args)
	{
		// 改变主线程的优先级
		Thread.currentThread().setPriority(6);
		for (int i = 0 ; i < 30 ; i++ )
		{
			if (i == 10)
			{
				PriorityTest low  = new PriorityTest("低级");
				low.start();
				System.out.println("创建之初的优先级:"
					+ low.getPriority());
				// 设置该线程为最低优先级
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if (i == 20)
			{
				PriorityTest high = new PriorityTest("高级");
				high.start();
				System.out.println("创建之初的优先级:"
					+ high.getPriority());
				// 设置该线程为最高优先级
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}
}
