#include<stdio.h>

main()
{
	int x,a;
	scanf("%d",&x);
	if(x>-5 && x<0)
		a=0;
	if(x==0)
		a=1;
	if(x>0 && x<10)
		a=2;
	switch (a)
	{
		case 0:printf("%d\n",x);break;
		case 1:printf("%d\n",x-1);break;
		default:printf("%d\n",x+1);
	}
}

