#include<stdio.h>

void fun(char *a,char *b,int *k)
{
	int i,j=0;
	for(i=0;i<81;++i)
	{
		if(a[i]==b[j] && j<3)
		{
			++j;
			if(j==2)
			{
				j=0;
				(*k)++;
			}
		}
		else
			j=0;
	}
}

main()
{
	char a[81]="xabcxabcxabc",b[3]="abc";
	int k=0;
	fun(a,b,&k);
	printf("%d\n",k);
}
