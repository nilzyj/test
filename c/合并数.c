#include<stdio.h>

void fun(int a,int b,long *c)
{
    if(a>10 && b>10 && a<100 && b<100)
    {
        *c=(a/10)*1000+(a%10)*10+(b/10)+(b%10)*100;
    }
}

main()
{
    int a,b;
    long c=0;
    scanf("%d%d",&a,&b);
    fun(a,b,&c);
    printf("%ld",c);
}
