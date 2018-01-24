package io._15_6;


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
public class ReadFromProcess
{
	public static void main(String[] args)
		throws IOException
	{
		// ����javac����������и�������ӽ���
		Process p = Runtime.getRuntime().exec("javac");
		try(
			// ��p���̵Ĵ���������BufferedReader����
			// ����������Ա�����������������p�������������
			BufferedReader br = new BufferedReader(new
				InputStreamReader(p.getErrorStream())))
		{
			String buff = null;
			// ��ȡѭ����ʽ����ȡp���̵Ĵ������
			while((buff = br.readLine()) != null)
			{
				System.out.println(buff);
			}
		}
	}
}

