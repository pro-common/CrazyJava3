package io._15_6;


import java.io.*;
import java.util.*;
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
public class WriteToProcess
{
	public static void main(String[] args)
		throws IOException
	{
		// ����java ReadStandard����������и�������ӽ���
		Process p = Runtime.getRuntime().exec("java ReadStandard");
		try(
			// ��p���̵����������PrintStream����
			// ���������Ա����������������p��������������
			PrintStream ps = new PrintStream(p.getOutputStream()))
		{
			// ��ReadStandard����д�����ݣ���Щ���ݽ���ReadStandard��ȡ
			ps.println("��ͨ�ַ���");
			ps.println(new WriteToProcess());
		}
	}
}
// ����һ��ReadStandard�࣬������Խ��ܱ�׼���룬
// ������׼����д��out.txt�ļ���
class ReadStandard
{
	public static void main(String[] args)
	{
		try(
			// ʹ��System.in����Scanner�������ڻ�ȡ��׼����
			Scanner sc = new Scanner(System.in);
			PrintStream ps = new PrintStream(
			new FileOutputStream("out.txt")))
		{
			// ��������һ�н�ֻ�ѻس���Ϊ�ָ���
			sc.useDelimiter("\n");
			// �ж��Ƿ�����һ��������
			while(sc.hasNext())
			{
				// ���������
				ps.println("��������������ǣ�" + sc.next());
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
