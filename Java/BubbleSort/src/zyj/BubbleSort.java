package zyj;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = new int[]{63,4,24,1,3,13};
		for(int i = 1;i < array.length;i++)
		{
			for(int j = 0;j < array.length-i;j++)
			{
				if(array[j] > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
				System.out.print(array[j] + " ");
			}
			System.out.print("¡¾");
			for(int j = array.length-i;j < array.length;j++)
			{
				System.out.print(array[j] + " ");
			}
			System.out.println("¡¿");
		}
	}

}
