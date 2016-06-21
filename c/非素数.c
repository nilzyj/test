#include<stdio.h>

void fun(int m,int *k,int xx[])
{
    int i,j,n=0;
    for(i=4;i<m;i++)
    {
        for(j=2;j<i;j++)
            if(i%j==0)
            {
                xx[n++]=i;
                break;
            }
    }
	*k=n;
}

main()
{
    
	int xx[101]={0},m,k=0,i;
    scanf("%d", &m);
    fun(m,&k,xx);
	for(i=0;i<k;++i)
		printf("%d ",xx[i]);
    printf("\n%d",k);
}
