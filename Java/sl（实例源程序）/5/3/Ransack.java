package com.mingrisoft;


public class Ransack {											// 创建类
	public static void main(String[] args) {
				int arr[][][] = new int[][][] {							// 创建三维数组
				{{ 1, 2, 3 }, { 4, 5, 6 }},
				{{ 7, 8, 9 }, {10, 11, 12}},
				{{13, 14, 15}, {16, 17, 18}}
				};
		for (int i = 0; i < arr.length; i++) {							// 遍历数组
			System.out.println("三维数组的第"+(i+1)+"个元素是一个"+arr[0].length
					+"维数组，内容如下：");
			for (int j = 0; j < arr[0].length; j++) {						// 遍历数组
				for (int k = 0; k < arr[0][0].length; k++) {
					System.out.print(arr[i][j][k] + "\t");				// 输出数组元素
				}
				System.out.println();
			}
		}
	}
}

