package collection.code8_3;

import java.util.*;

class R1 implements Comparable<Object>
{
	int count;
	public R1(int count)
	{
		this.count = count;
	}
	public String toString()
	{
		return "R[count:" + count + "]";
	}
	// 重写equals方法，根据count来判断是否相等
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if(obj != null && obj.getClass() == R1.class)
		{
			R1 r = (R1)obj;
			return r.count == this.count;
		}
		return false;
	}
	// 重写compareTo方法，根据count来比较大小
	public int compareTo(Object obj)
	{
		R1 r = (R1)obj;
		return count > r.count ? 1 :
			count < r.count ? -1 : 0;
	}
}
public class TreeSetTest3
{
	public static void main(String[] args)
	{
		// 如果向 TreeSet 中添加一个可变对象后，并且后面程序修改了该可变对象的实例变量，这将导致它与其他对象的大小顺序发生了变化，
		// 但 TreeSet 不会再次调整它们的顺序，甚至可能导致 TreeSet 中报存的这连个对象通过 compareTo(Object obj) 方法比较返回 0。
		TreeSet ts = new TreeSet();
		ts.add(new R1(5));
		ts.add(new R1(-3));
		ts.add(new R1(9));
		ts.add(new R1(-2));
		// 打印TreeSet集合，集合元素是有序排列的
		System.out.println(ts);    // ①
		
		// 取出第一个元素
		R1 first = (R1)ts.first();
		// 对第一个元素的count赋值
		first.count = 20;
		// 取出最后一个元素
		R1 last = (R1)ts.last();
		// 对最后一个元素的count赋值，与第二个元素的count相同
		last.count = -2;
		// 再次输出将看到TreeSet里的元素处于无序状态，且有重复元素
		System.out.println(ts);   // ②
		
		// 删除实例变量被改变的元素，删除失败
		System.out.println(ts.remove(new R1(-2)));   // ③
		System.out.println(ts);
		
		// 删除实例变量没有被改变的元素，删除成功
		System.out.println(ts.remove(new R1(5)));    // ④
		System.out.println(ts);
	}
}
