package com.mingrisoft;


public class Ransack {											// ������
	public static void main(String[] args) {
				int arr[][][] = new int[][][] {							// ������ά����
				{{ 1, 2, 3 }, { 4, 5, 6 }},
				{{ 7, 8, 9 }, {10, 11, 12}},
				{{13, 14, 15}, {16, 17, 18}}
				};
		for (int i = 0; i < arr.length; i++) {							// ��������
			System.out.println("��ά����ĵ�"+(i+1)+"��Ԫ����һ��"+arr[0].length
					+"ά���飬�������£�");
			for (int j = 0; j < arr[0].length; j++) {						// ��������
				for (int k = 0; k < arr[0][0].length; k++) {
					System.out.print(arr[i][j][k] + "\t");				// �������Ԫ��
				}
				System.out.println();
			}
		}
	}
}

