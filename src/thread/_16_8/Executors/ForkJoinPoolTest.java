package thread._16_8.Executors;

import java.util.concurrent.*;

/**
 * ForkJoinPool是一个抽象类，有两个子类，RecursiveAction、RecursiveTash
 * 
 * 继承RecursiveAction来实现"可分解"的任务，没有返回值
 * 例子：
 * 	执行没有返回值的“大任务”（简单地打印0-300的数值）为例，程序将一个“大任务”拆分成多个“小任务”，并将任务交给ForkJoinPool来执行。
 * 
 */
class PrintTask extends RecursiveAction
{
	// 每个“小任务”只最多只打印50个数
	private static final int THRESHOLD = 50;
	private int start;
	private int end;
	// 打印从start到end的任务
	public PrintTask(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	@Override
	protected void compute()
	{
		// 当end与start之间的差小于THRESHOLD时，开始打印
		if(end - start < THRESHOLD)
		{
			for (int i = start ; i < end ; i++ )
			{
				System.out.println(Thread.currentThread().getName()
					+ "的i值：" + i);
			}
		}
		else
		{
			// 如果当end与start之间的差大于THRESHOLD时，即要打印的数超过50个
			// 将大任务分解成两个小任务。
			int middle = (start + end) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			// 并行执行两个“小任务”
			left.fork();
			right.fork();
		}
	}
}
public class ForkJoinPoolTest
{
	public static void main(String[] args)
		throws Exception
	{
		ForkJoinPool pool = new ForkJoinPool();
		// 提交可分解的PrintTask任务
		pool.submit(new PrintTask(0 , 300));
		pool.awaitTermination(2, TimeUnit.SECONDS);
		// 关闭线程池
		pool.shutdown();
	}
}

