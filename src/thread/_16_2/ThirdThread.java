package thread._16_2;

import java.util.concurrent.*;

/**
 * 使用 Callable 和 Future 创建线程
 * 总结：
 * 	1.有返回值、可抛出异常
 * 	2.Callable 不是 Runnable 接口的子接口，故不能直接作为 Thread 的 target
 * 	3.通过Future接口获取 call() 方法的返回值
 * 	4.FutureTask实现 Future 接口，并实现了 Runnable 接口，可作为 Thread 类的 target，代表 Callable 接口里 call() 方法的返回值
 */
public class ThirdThread
{
	public static void main(String[] args)
	{
		// 创建Callable对象
		ThirdThread rt = new ThirdThread();
		// 先使用Lambda表达式创建Callable<Integer>对象
		// 使用FutureTask来包装Callable对象
		FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() -> {
			int i = 0;
			for ( ; i < 3 ; i++ )
			{
				System.out.println(Thread.currentThread().getName()
					+ " 的循环变量i的值：" + i);
			}
			// call()方法可以有返回值
			return i;
		});
		for (int i = 0 ; i < 10 ; i++)
		{
			System.out.println(Thread.currentThread().getName()
				+ " 的循环变量i的值：" + i);
			if (i == 5)
			{
				// 实质还是以Callable对象来创建、并启动线程
				new Thread(task , "有返回值的线程").start();
			}
		}
		try
		{
			// 获取线程返回值
			System.out.println("子线程的返回值：" + task.get());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

