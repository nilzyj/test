#include<stdio.h>
#include<conio.h>
int main()
{
	int a[5][3]={{-50,17,-42},{-47,-19,-3},{36,-34,-43},{-30,-43,34},{-23,-8,-45}};
	int i,j;
	int max,n;
	int sum=0;
	for(i=0;i<5;i++)
	{
		max=a[i][0];
		n=0;
		for(j=1;j<3;j++)
		{
			if(a[i][j]>max)
			{
				max=a[i][j];
				n=j;
			}
		}
		sum+=max;
		printf("a[%d][%d]=%d\n",i,n,max);
	}
	printf("%d\n",sum);
	getch();
	return 0;
}
