package com.mingrisoft;

import java.io.FileReader;							// ����java.io���е�FileReader��
import java.io.IOException;						// ����java.io���е�IOException��
public class Example_08 {
	private FileReader read=null;					// ����FileReader����read
	public void createFile() throws Exception{			// ���巽����ʹ��throws�׳�Exception�쳣
		read=new FileReader("src/com/mingrisoft/Example_08.java");	// ����FileReader����read
		System.out.println("�����ڴ���Դ��");
	}
	public void test(){
		try{
			createFile();						// ����createFile()������ʹ��try-catch-finally�����쳣
		}catch(Exception ex){
			ex.printStackTrace();					// ������ټ�
			System.out.println("����IO�����쳣��");
		}finally{
			if (read!=null){
				try {
					read.close();				// �ر�IO��
					System.out.println("�ͷ��ڴ���Դ��");
				} catch (IOException e) {
					e.printStackTrace();			// ������ټ�
					System.out.println("�ر�IO�����쳣��");
				}
			}
		}
	}
	public static void main(String[] args) {
		Example_08 ex=new Example_08();			// ��������
		ex.test();								// ����test()����
	}
}
