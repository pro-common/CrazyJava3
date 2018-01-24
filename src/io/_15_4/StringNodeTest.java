package io._15_4;


import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class StringNodeTest
{
	public static void main(String[] args)
	{
		String src = "����������һ���Ҹ�����\n"
			+ "ι��������������\n"
			+ "�������𣬹�����ʳ���߲�\n"
			+ "����һ�����ӣ��泯�󺣣���ů����\n"
			+ "�������𣬺�ÿһ������ͨ��\n"
			+ "���������ҵ��Ҹ�\n";
		char[] buffer = new char[32];
		int hasRead = 0;
		try(
			StringReader sr = new StringReader(src))
		{
			// ����ѭ����ȡ�ķ��ʶ�ȡ�ַ���
			while((hasRead = sr.read(buffer)) > 0)
			{
				System.out.print(new String(buffer ,0 , hasRead));
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		try(
			// ����StringWriterʱ��ʵ������һ��StringBuffer��Ϊ����ڵ�
			// ����ָ����20����StringBuffer�ĳ�ʼ����
			StringWriter sw = new StringWriter())
		{
			// ����StringWriter�ķ���ִ�����
			sw.write("��һ�������������磬\n");
			sw.write("����Զ������,\n");
			sw.write("����������ĺ��ӣ�\n");
			sw.write("���й���ľ���\n");
			System.out.println("----������sw���ַ����ڵ��������----");
			// ʹ��toString()��������StringWriter���ַ����ڵ������
			System.out.println(sw.toString());
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
