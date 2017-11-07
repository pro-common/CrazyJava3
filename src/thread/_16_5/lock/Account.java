package thread._16_5.lock;

import java.util.concurrent.locks.*;

/**
 * 账户类：
 *  同步锁 - Lock
 *  1.java5开始，提供一种更强大的线程同步机制 —— 通过“显式”定义同步锁对象来实现同步，同步锁由 Lock 对象充当。
 *  2.每次只能有一个线程对 Lock 对象加锁，线程开始访问共享资源之前应先获得 Lock 对象。
 *  3.两个根接口：Lock、ReadWriteLock
 *  （1）Lock 的实现类 - ReentrantLock（可重入锁）
 *  （2）ReadWriteLock 的实现类 - ReentrantReadWriteLock
 *  4.在不同的作用范围内时，通常建议使用 finally 块来确保在必要时释放锁。
 */
public class Account
{
	// 定义锁对象（可重入锁）
	private final ReentrantLock lock = new ReentrantLock();
	// 封装账户编号、账户余额的两个成员变量
	private String accountNo;
	private double balance;
	public Account(){}
	// 构造器
	public Account(String accountNo , double balance)
	{
		this.accountNo = accountNo;
		this.balance = balance;
	}

	// accountNo的setter和getter方法
	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	public String getAccountNo()
	{
		return this.accountNo;
	}
	// 因此账户余额不允许随便修改，所以只为balance提供getter方法，
	public double getBalance()
	{
		return this.balance;
	}

	// 提供一个线程安全draw()方法来完成取钱操作
	public void draw(double drawAmount)
	{
		// 加锁
		lock.lock();
		try
		{
			// 账户余额大于取钱数目
			if (balance >= drawAmount)
			{
				// 吐出钞票
				System.out.println(Thread.currentThread().getName()
					+ "取钱成功！吐出钞票:" + drawAmount);
				try
				{
					Thread.sleep(1);
				}
				catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
				// 修改余额
				balance -= drawAmount;
				System.out.println("\t余额为: " + balance);
			}
			else
			{
				System.out.println(Thread.currentThread().getName()
					+ "取钱失败！余额不足！");
			}
		}
		finally
		{
			// 修改完成，释放锁
			lock.unlock();
		}
	}

	// 下面两个方法根据accountNo来重写hashCode()和equals()方法
	public int hashCode()
	{
		return accountNo.hashCode();
	}
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if (obj !=null
			&& obj.getClass() == Account.class)
		{
			Account target = (Account)obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
}