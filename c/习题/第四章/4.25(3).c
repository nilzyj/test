#include<stdio.h>

main()
{
	int x;
	scanf("%d",&x);
	if(x>-5 && x<0)
		printf("%d\n",x);
	else if(x==0)
		printf("%d\n",x-1);
	else
		printf("%d\n",x+1);
}
