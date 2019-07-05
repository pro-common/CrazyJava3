package collection.code8_3;

import java.util.*;

public class TreeSetErrorTest2
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet();
		// 向TreeSet集合中添加两个对象
		ts.add(new String("疯狂Java讲义"));
		ts.add(new Date());   // ①
	}
}
