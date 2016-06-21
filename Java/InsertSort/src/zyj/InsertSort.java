package zyj;

public class InsertSort {

	public static void main(String[] args) {
		int[] array = new int[]{20,30,60,40,50,10};
		System.out.println("≈≈–Ú«∞£∫");
		for(int i = 0;i < array.length;i++)
		{
			System.out.println(array[i]+" ");
		}
		int temp;
		int j;
		for(int i = 1;i < array.length;i++)
		{
			temp = array[i];
			for(j = i - 1;j >= 0 && array[j] > temp;j--)
			{
				array[j+1] = array[j];
			}
			array[j+1] = temp;
		}
		System.out.println("\n≈≈–Ú∫Û£∫");
		for(int i = 0;i < array.length;i++)
		{
			System.out.println(array[i]+" ");
		}
	}

}
