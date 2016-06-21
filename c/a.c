#include<stdio.h>

main(int arg0,char *arg1[])
{
	int i;
	printf("%d\n",arg0);
	for(i=0;i<10;++i)
		printf("%s",arg1[i]);
}