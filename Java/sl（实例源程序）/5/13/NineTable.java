package com.mingrisoft;

public class NineTable {
	public static void main(String[] args) {
		int arr[][] = new int[3][3];							//����һ�����׷���
		int a = 2;										//��3�е����±�
		int b = 3/2;									//��2�е����±�
		for(int i=1;i<=9;i++){								//�����鸳ֵ
			arr[a++][b++] = i;
			if(i%3==0){								//���i��3�ı���
				a = a-2;
				b = b-1;
			}else{									//���i����3�ı���
				a = a%3;
				b = b%3;
			}
		}
		System.out.println("����Ź���");					//��������Ź���
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(arr[i][j]+"  ");
			}
			System.out.print("\n");
		}
	}
}
