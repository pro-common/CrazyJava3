package collection.code8_2;

import java.util.Collection;
import java.util.HashSet;

/**
 * ClassName: CollectionEach <br/>
 * Function: 使用 Lambda 表达式遍历集合. <br/>
 * date: 2019年7月3日 下午2:43:47 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
public class CollectionEach_2
{
	public static void main(String[] args)
	{
		// 创建一个集合
		Collection books = new HashSet();
		books.add("轻量级Java EE企业应用实战");
		books.add("疯狂Java讲义");
		books.add("疯狂Android讲义");
		// 调用forEach()方法遍历集合
		books.forEach(obj -> System.out.println("迭代集合元素：" + obj));
	}
}
