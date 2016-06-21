package com.mingrisoft;

import java.io.FileInputStream;
import java.io.IOException;

public class CloseIo {

	private FileInputStream in=null;			// ����FileInputStream����in
	public void readInfo(){				// ���巽��
		try{
			// ����FileInputStream����in
			in=new FileInputStream("src/com/mingrisoft/CloseIo.java");
			System.out.println("����IO���������ڴ���Դ��");
		}catch(IOException io){
			io.printStackTrace();			// ������ټ�
			System.out.println("����IO�������쳣��");
		}finally{
			if (in!=null){
				try{
					in.close();			// �ر�FileInputStream����in���ͷ���Դ
					System.out.println("�ر�IO�����ͷ��ڴ���Դ��");
				}catch(IOException ioe){
					ioe.printStackTrace();				// ������ټ�
					System.out.println("�ر�IO�������쳣��");
				}
			}
		}
	}
	public static void main(String[] args) {
		CloseIo ex=new CloseIo();				// ��������
		ex.readInfo();								// ����readInfo()����
	}


}
