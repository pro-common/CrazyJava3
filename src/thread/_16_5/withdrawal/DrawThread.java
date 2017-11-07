package thread._16_5.withdrawal;



/**
 * 《模拟两个人使用同一个账户并发取钱的问题》
 * 
 * 取钱的线程类
 * 1.该线程类根据执行账户、取钱数量进行取钱操作，取钱的逻辑是当其余额不足时无法提取现金，
 * 当余额足够时系统吐出钞票，余额减少。
 */
public class DrawThread extends Thread
{
	// 模拟用户账户
	private Account account;
	// 当前取钱线程所希望取的钱数
	private double drawAmount;
	public DrawThread(String name , Account account
		, double drawAmount)
	{
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	// 当多条线程修改同一个共享数据时，将涉及数据安全问题。
	public void run()
	{
		// 账户余额大于取钱数目
		if (account.getBalance() >= drawAmount)
		{
			// 吐出钞票
			System.out.println(getName()
				+ "取钱成功！吐出钞票:" + drawAmount);
			try
			{
				//sleep会让线程变为“阻塞”状态，释放资源，其他线程会抢到资源执行。
				Thread.sleep(1);
			}
			catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
			// 修改余额
			account.setBalance(account.getBalance() - drawAmount);
			System.out.println("\t余额为: " + account.getBalance());
		}
		else
		{
			System.out.println(getName() + "取钱失败！余额不足！");
		}
		
	}
}
