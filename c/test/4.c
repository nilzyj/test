#include<stdio.h>

int main()
{
	int a;
	printf("1.a 2.b 3.c 4.break");
	while(1)
	{
		scanf("%d",&a);
	if(a==1)
		printf("a");
	else if(a==2)
		printf("b");
	else
		printf("c");
	}
	return 0;
}