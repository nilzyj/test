#include<stdio.h>

main(int argc,char *argv[])
{
	int i;//控制for循环
	printf("参数argc=%d\n",argc);//argc为命令行参数的个数
	for(i=0;i<argc;++i)
		printf("参数argv[%d]=%s ",i,argv[i]);//argv为命令行参数的值，分别为argv[0],argv[1]...
}