package zyj;

public class ArraysMemory {

	public static void main(String[] args) {
		int num1 = 1024 * 1024 * 2;
		int[] arr1 = new int[num1];
		for(int i = 0;i < arr1.length;i++)
		{
			arr1[i] = 1;
		}
		//���ռ���ڴ�������������λת��ΪMB
		long memory1 = Runtime.getRuntime().totalMemory()/1024/1024;
		System.out.println("һά����ռ�ڴ棺"+memory1);
		int num2 = 1024 * 1024;
		int[][] arr2 = new int[num2][2];
		for(int i = 0;i < arr2.length;i++)
		{
			arr2[i][0] = i;
			arr2[i][1] = i;
		}
		//���ռ���ڴ�������������λת��ΪMB
		long memory2 = Runtime.getRuntime().totalMemory()/1024/1024;
		System.out.println("��ά����ռ���ڴ棺"+memory2);
	}

}
