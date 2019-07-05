package thread._16_5.withdrawal;



/**
 * 《模拟两个人使用同一个账户并发取钱的问题》
 * 
 * 测试类
 * 
 */
public class DrawTest
{
	public static void main(String[] args)
	{
		// 创建一个账户
		Account acct = new Account("1234567" , 1000);
		// 模拟两个线程对同一个账户取钱
		new DrawThread("甲" , acct , 800).start();
		new DrawThread("乙" , acct , 800).start();
	}
}

