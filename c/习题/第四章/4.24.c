#include<stdio.h>

main()
{
	int a,b,c,max;
	scanf("%d%d%d",&a,&b,&c);
	max=a;
	if(max<b)
		max=b;
	if(max<c);
		max=c;
	printf("最大的数为%d\n",max);
}