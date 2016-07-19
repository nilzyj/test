#include<stdio.h>

int main()
{
	float a;
	scanf("%f",&a);
	printf("%.3f",a);
	return 0;
}
/*
	printf("%n1d");
	printf("%n1.n2f");//float,double
	printf("%n1.n2lf");//double
	printf("%n1f");//float,double自动突破
	printf("%n1lf");//double自动突破
	printf("%.n2f");//float,double输出小数前n2个字符
	printf("%.n2lf");//double输出小数前n2个字符
	printf("%*d",m,a);
	printf("%*.*",m,n,a);
	scanf("%*d")//跳过输入数据
	scanf("%3d");
	scanf("%3f");//float
	scanf("%3lf");//double
	*/