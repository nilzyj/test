#include<stdio.h>

main(int argc,char *argv[])
{
	int i;//����forѭ��
	printf("����argc=%d\n",argc);//argcΪ�����в����ĸ���
	for(i=0;i<argc;++i)
		printf("����argv[%d]=%s ",i,argv[i]);//argvΪ�����в�����ֵ���ֱ�Ϊargv[0],argv[1]...
}