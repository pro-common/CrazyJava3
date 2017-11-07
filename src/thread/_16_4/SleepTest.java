package thread._16_4;

import java.util.*;

/**
 * 线程睡眠 sleep
 * 1.让当前正在执行的线程暂停一段时间，并进入阻塞状态，则可以通过调用 Thread 类的静态 sleep()方法来实现。
 */
public class SleepTest
{
	public static void main(String[] args)
		throws Exception
	{
		for (int i = 0; i < 10 ; i++ )
		{
			System.out.println("当前时间: " + new Date());
			// 调用sleep方法让当前线程暂停1s。
			Thread.sleep(1000);
		}
	}
}

