package com.mingrisoft;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Example_07 {
	private FileReader read=null;			// ����FileReader����read
	public void readFileInfo(){				// ���巽��
		try{
			try {
				read=new FileReader("src/com/mingrisoft/Example_07.java");// ����FileReader����read
				System.out.println("�ҵ�ָ�����ļ�������IO����ɹ���");
			} catch (FileNotFoundException e) {
				e.printStackTrace();		// ������ټ�
			}
		}finally{
			if (read!=null){
				try{
					read.close();			// �ر�FileReader����read���ͷ���Դ
					System.out.println("�ر�IO����");
				}catch(IOException ioe){
					ioe.printStackTrace();				// ������ټ�
					System.out.println("�ر�IO�������쳣��");
				}
			}
		}
	}
	public static void main(String[] args) {
		Example_07 ex=new Example_07();				// ��������
		ex.readFileInfo();								// ����readFileInfo()����
	}

}
