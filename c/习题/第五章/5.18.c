#include <stdio.h>

main()
{
	double e=1,a;
    int i,j;
    for(i=0;i<50;++i)
    {
		a=1;
		for(j=1;j<i+2;++j)
		{
			a=a*j;
        }
        e=e+1/a;
    }
	printf("%f\n",e);
}
