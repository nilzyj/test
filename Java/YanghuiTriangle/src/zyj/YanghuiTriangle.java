package zyj;

public class YanghuiTriangle {

	public static void main(String[] args) {
		int i,j;
		int a[][]=new int[10][];
		for(i=0;i<10;++i)
		{
			a[i]=new int[i+1];
			for(j=0;j<a[i].length-1;++j)
			{
				if(i==0 || j==0 || j==a[i].length-1)
					a[i][j]=1;
				else
					a[i][j]=a[i-1][j]+a[i-1][j-1];
				System.out.print(a[i][j]+"  ");
			}
			System.out.println("");
		}
	}

}
