package com.mingrisoft;

public class Example_03 {
	public void printBugInfo(){				// �����Ա����
		try{
			int x=100;					// ����ֲ�����x
			int y=0;					// ����ֲ�����y
			int z=x / y;					// ����x����y����
			// ���������
			System.out.println(x+"����"+y+"�����ǣ�"+z);
		}catch(Exception ex){
			ex.printStackTrace();				// ����쳣����׼������
			// ʹ��getMessage��������쳣��Ϣ
			System.out.println("getMessage������   "+ex.getMessage());
			// ʹ��getLocalizedMessage��������쳣��Ϣ
			System.out.println("getLocalizedMessage������   "+ex.getLocalizedMessage());
			// ʹ��toString��������쳣��Ϣ
			System.out.println("toString������   "+ex.toString());			
		}
	}
	public static void main(String[] args) {
		Example_03 ex=new Example_03();		// �������ʵ��
		ex.printBugInfo();					// ���÷���
	}
}

