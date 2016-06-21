#include<stdio.h>

main()
{
	int x;
	scanf("%d",&x);
	if(x>-5 && x<0)
	{
		printf("%d\n",x);
		if(x==0)
		{
			printf("%d\n",x-1);
			if(x>0 && x<10)
				printf("%d\n",x+1);
		}
	}
}
