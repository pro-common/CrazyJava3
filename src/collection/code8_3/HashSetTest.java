package collection.code8_3;


import java.util.*;
/**
 * ClassName: A <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2019年7月3日 下午3:40:35 <br/>
 *
 * @version 
 * @since JDK 1.8
 * @author kaiyun
 */
//类A的equals方法总是返回true，但没有重写其hashCode()方法
class A
{
	public boolean equals(Object obj)
	{
		return true;
	}
}
//类B的hashCode()方法总是返回1，但没有重写其equals()方法
class B
{
	public int hashCode()
	{
		return 1;
	}
}
//类C的hashCode()方法总是返回2，且重写其equals()方法总是返回true
class C
{
	public int hashCode()
	{
		return 2;
	}
	public boolean equals(Object obj)
	{
		return true;
	}
}
public class HashSetTest
{
	public static void main(String[] args)
	{
		HashSet books = new HashSet();
		// 分别向books集合中添加两个A对象，两个B对象，两个C对象
		books.add(new A());
		books.add(new A());
		books.add(new B());
		books.add(new B());
		books.add(new C());
		books.add(new C());
		System.out.println(books);
	}
}
