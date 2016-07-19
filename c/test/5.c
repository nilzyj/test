#include<stdio.h>

int main()
{
	int a=1,b=2,c=3;
	if((a>b) && (b>c))
		printf("%d\n",b);
	else
		printf("%d\n",a);
	return 0;
}