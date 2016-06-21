#include<stdio.h>

main()
{
	int a=0,i=1;
	while(abs(i)<10)//abs()是取绝对值函数
	{
		a=a+i;
		i=-i;
		if(i>0)
			i=i+2;
		else
			i=i-2;
	}
	printf("%d\n",a);
}