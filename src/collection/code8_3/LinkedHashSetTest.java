package collection.code8_3;

import java.util.*;

public class LinkedHashSetTest
{
	public static void main(String[] args)
	{
//		LinkedHashSet
//			是 HashSet 的子类;
//			同样是根据 hashCode 值来决定元素的存储位置，但它同时使用链表维护元素的次序（以插入的顺序保存的）；
//			遍历时，按元素的添加顺序来访问集合里的元素
		LinkedHashSet books = new LinkedHashSet();
		books.add("疯狂Java讲义");
		books.add("轻量级Java EE企业应用实战");
		System.out.println(books);
		
		// 删除 疯狂Java讲义
		books.remove("疯狂Java讲义");
		
		// 重新添加 疯狂Java讲义
		books.add("疯狂Java讲义");
		System.out.println(books);
	}
}
