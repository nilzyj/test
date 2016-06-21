package com.mingrisoft;

public class NineTable {
	public static void main(String[] args) {
		int arr[][] = new int[3][3];							//创建一个三阶方阵
		int a = 2;										//第3行的行下标
		int b = 3/2;									//第2列的列下标
		for(int i=1;i<=9;i++){								//给数组赋值
			arr[a++][b++] = i;
			if(i%3==0){								//如果i是3的倍数
				a = a-2;
				b = b-1;
			}else{									//如果i不是3的倍数
				a = a%3;
				b = b%3;
			}
		}
		System.out.println("输出九宫格：");					//遍历输出九宫格
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(arr[i][j]+"  ");
			}
			System.out.print("\n");
		}
	}
}
