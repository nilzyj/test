#include <stdio.h>
int main ()
{
    int a,b,c,d,e;
    for(a=1;a<=5;++a)
    {
        for(b=1;b<=5;++b)
        {
            if(a!=b)
            {
                for(c=1;c<=5;++c)
                {
                    if(c!=b && c!=a)
                    {
                        for(d=1;d<=5;++d)
                        {
                            if (d!=a && d!=b && d!=c)
                            {
                                e=15-a-b-c-d;
                                if(e!=a && e!=b && e!=c && e!=d)
                                	{
                                    if(((b==3)+(c==5))==1 && ((d==2)+(e==4))==1 && ((b==1)+(e==4))==1 && ((c==1)+(b==2))==1 && (d==2)+(a==3)==1)
                                    {
                                        printf("%d\n",a);
                                        printf("%d\n",b);
                                        printf("%d\n",c);
                                        printf("%d\n",d);
                                        printf("%d\n",e);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    return 0;
}
