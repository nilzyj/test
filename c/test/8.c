#include<stdio.h>

int main()
{
	int a,b;
	scanf("%d%d",&a,&b);
	if(a<b)
		printf("a<b:%d",a);
	if(a>b)
		printf("a>b:%d",b);
	if(a==b)
		printf("a==b:%d",a);
	return 0;
}
