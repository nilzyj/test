#include<stdio.h>

int main()
{
	int a=1,b=2,c=3;
	if(--a && b++)//((a>b) && (b<c))
		printf("%d\n",a);
	else
		printf("%d\n",b);
	return 0;
}