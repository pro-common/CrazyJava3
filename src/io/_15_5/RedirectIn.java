package io._15_5;


import java.util.*;
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
public class RedirectIn
{
	public static void main(String[] args)
	{
		try(
			FileInputStream fis = new FileInputStream("RedirectIn.java"))
		{
			// ����׼�����ض���fis������
			System.setIn(fis);
			// ʹ��System.in����Scanner�������ڻ�ȡ��׼����
			Scanner sc = new Scanner(System.in);
			// ��������һ�н�ֻ�ѻس���Ϊ�ָ���
			sc.useDelimiter("\n");
			// �ж��Ƿ�����һ��������
			while(sc.hasNext())
			{
				// ���������
				System.out.println("��������������ǣ�" + sc.next());
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}

