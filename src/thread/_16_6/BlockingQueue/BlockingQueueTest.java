package thread._16_6.BlockingQueue;


import java.util.concurrent.*;
/**
 * 当生产者线程，试图向BlockingQueue队列中放入元素时，如果该队列已满，则该线程被阻塞
 */
public class BlockingQueueTest
{
	public static void main(String[] args)
		throws Exception
	{
		// 定义一个长度为2的阻塞队列
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
		bq.put("Java"); // 与bq.add("Java"、bq.offer("Java")相同
		bq.put("Java"); // 与bq.add("Java"、bq.offer("Java")相同
		bq.put("Java"); // ① 阻塞线程。
	}
}
