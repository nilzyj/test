#include<stdio.h>
int Fibo(int n)
{
    if(1==n)
    {
        return 1;
    }
    else if(2==n)
    {
        return 2;
    }
    else
    {
        return (Fibo(n-1)+Fibo(n-2));
    }
}
int main()
{
    int n,s;
    printf("n=");
    scanf("%d",&n);
    printf("%d\n",Fibo(n));
    return 0;
}
