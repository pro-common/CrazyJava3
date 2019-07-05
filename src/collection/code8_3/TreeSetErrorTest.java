package collection.code8_3;


import java.util.*;

class Err{}
public class TreeSetErrorTest
{
	public static void main(String[] args)
	{
		// 如果试图把一个对象添加到 TreeSet 时，则该对象的类必须实现 Comparable 接口，否则程序将会抛出异常。
		TreeSet ts = new TreeSet();
		// 向TreeSet集合中添加两个Err对象
		ts.add(new Err());
		ts.add(new Err());  //①
	}
}
