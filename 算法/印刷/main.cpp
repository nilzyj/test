#include<stdio.h>
#include<conio.h>
int a[6][2]={{3,8},{12,10},{5,9},{2,6},{9,3},{11,1}};
int x[6],f1=0,f2[7]={0};
int b[6],t;
void swap(int i,int j)
{
	int temp;
	temp=x[i];
	x[i]=x[j];
	x[j]=temp;
}
void comp(int i)
{
	int j;
	if(i==6)
	{
		for(j=0;j<6;j++)
			b[j]=x[j];
		t=f2[i];
	}
	else
	{
		for(j=i;j<6;j++)
		{
			f1=f1+a[x[j]][0];
			if(f2[i]>f1)
				f2[i+1]=f2[i]+a[x[j]][1];
			else
				f2[i+1]=f1+a[x[j]][1];
			if(f2[i+1]<t)
			{
				swap(i,j);
				comp(i+1);
				swap(i,j);
			}
			f1=f1-a[x[j]][0];
		}
	}
}
int main()
{
	int i,j;
	t=32767;
	for(i=0;i<6;i++)
        x[i]=i;
	comp(0);
	for(i=0;i<6;i++)
		printf("%d ",b[i]);
	printf("\nt=%d\n",t);
	getch();
	return 0;
}





