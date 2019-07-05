package io._15_5;


import java.io.*;
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
public class RedirectOut
{
	public static void main(String[] args)
	{
		try(
			// һ���Դ���PrintStream�����
			PrintStream ps = new PrintStream(new FileOutputStream("out.txt")))
		{
			// ����׼����ض���ps�����
			System.setOut(ps);
			// ���׼������һ���ַ���
			System.out.println("��ͨ�ַ���");
			// ���׼������һ������
			System.out.println(new RedirectOut());
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}

