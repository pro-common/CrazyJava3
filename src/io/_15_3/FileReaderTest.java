package io._15_3;


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
public class FileReaderTest
{
	public static void main(String[] args)
	{
		try(
			// �����ַ�������
			FileReader fr = new FileReader("FileReaderTest.java"))
		{
			// ����һ������Ϊ32�ġ���Ͳ��
			char[] cbuf = new char[32];
			// ���ڱ���ʵ�ʶ�ȡ���ַ���
			int hasRead = 0;
			// ʹ��ѭ�����ظ���ȡˮ������
			while ((hasRead = fr.read(cbuf)) > 0 )
			{
				// ȡ������Ͳ����ˮ�Σ��ַ��������ַ�����ת�����ַ������룡
				System.out.print(new String(cbuf , 0 , hasRead));
			}
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
