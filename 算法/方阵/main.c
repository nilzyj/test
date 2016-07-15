#include<stdio.h>
int main()
{
    int m,n,b[2],x,y,t,i,j;
    int a[8][8]={0};
    n=7;
    b[0]=0;
    b[1]=1;
    m=n;
    t=1;
    x=1;
    while(x<=n*n)
    {
        for(y=1;y<=2*m-1;++y)
        {
            b[y/(m+1)]+=t;
            a[b[1]][b[0]]=x;
            x++;
        }
        --m;
        t=-t;
	}
	for(i=1;i<8;++i)
        for(j=1;j<8;++j)
        {
            printf("%d\t",a[i][j]);
            if(7==j)
                printf("\n");
        }
    return 0;
}
