package com.mingrisoft;

public class CopyOfTransferProperty {
	static int i=47;											//���徲̬��Ա����
	public void call(){										//�����Ա����
		System.out.println("����call()����");
		for(i=0;i<3;i++){
			System.out.print(i+" ");
			if(i==2){
				System.out.println("\n");
			}
		}
	}
	public CopyOfTransferProperty(){							//���幹�췽��
	}
	public static void main(String[] args) {						//����������
		CopyOfTransferProperty t1=new CopyOfTransferProperty();	//����һ������
		CopyOfTransferProperty t2=new CopyOfTransferProperty();	//������һ������
		t2.i=60;											//�����Ա������ֵΪ60
		//ʹ�õ�һ������������Ա����
		System.out.println("��һ��ʵ��������ñ���i�Ľ����"+t1.i++); 
		t1.call();											//ʹ�õ�һ������������Ա����
		//ʹ�õڶ�������������Ա����
		System.out.println("�ڶ���ʵ��������ñ���i�Ľ����"+t2.i);
		t2.call();											//ʹ�õڶ�������������Ա����
	}
}
