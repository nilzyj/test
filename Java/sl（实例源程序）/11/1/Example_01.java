package com.mingrisoft;

public class Example_01 {
	private int num=10;							// ��Ա����
	public int getNum() {							// ��Ա����
		return num;							// ���س�Ա������ֵ
	}
	public void setNum(int num) {					// ��Ա����
		this.num = num;							// ���ó�Ա������ֵ
	}
	public Example_01(){							// ��Ĺ��췽��
		try {
			Class.forName("com.mingrisoft.Test");		// װ��zzk.jdbc���е�Test��
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		System.out.println("���ԡ�");				// �ڿ���̨��������ԡ���
	}
	public static void main(String[] args) {
		Example_01 exam=new Example_01();		// �������ʵ��
		exam.setNum(888);						// ����setNum()�������ó�Ա����num��ֵΪ888
		System.out.println(exam.getNum());			// ����getNum()���������Ա������ֵ888
	}
}

