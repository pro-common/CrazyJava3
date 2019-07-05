package collection.code8_2;


import java.util.*;

/**
 * ClassName: IteratorErrorTest_4 <br/>
 * Function: Collection 集合里的元素不能被改变，只有通过 Iterator 的 remove() 方法删除上一次 next() 方法返回的集合元素才可以；
 * 	否则会引发 java.util.ConcurrentModificationException 异常. <br/>
 * date: 2019年7月3日 下午2:50:51 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
public class IteratorErrorTest_4
{
	public static void main(String[] args)
	{
		// 创建集合、添加元素的代码与前一个程序相同
		Collection books = new HashSet();
		books.add("轻量级Java EE企业应用实战");
		books.add("疯狂Java讲义");
		books.add("疯狂Android讲义");
		
		// 获取books集合对应的迭代器
		Iterator it = books.iterator();
		while(it.hasNext())
		{
			String book = (String)it.next();
			System.out.println(book);
			if (book.equals("疯狂Android讲义"))
			{
				// 使用Iterator迭代过程中，不可修改集合元素,下面代码引发异常
				books.remove(book);
			}
		}
	}
}

