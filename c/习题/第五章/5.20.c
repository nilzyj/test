#include<stdio.h>

main()
{
	int i,j,k,a,b;
	for(i=1;i<5;++i)
	{
		for(a=5;a>=2*i-1;a=a-2)
			printf(" ");
		for(j=1;j<=2*i-1;j=j+1)
		{
			printf("*");
		}
		printf("\n");
	}
	for(i=1;i<4;++i)
	{
		for(a=1;a<=2*i-1;a=a+2)
			printf(" ");
		for(k=5;k>=2*i-1;k=k-1)
		{
			printf("*");
		}
		printf("\n");
			
	}
	printf("   **       **\n");
	printf(" *    *   *    *\n");
	printf(" *      *      *\n");
	printf("  *     ML    * \n");
	printf("    *       *\n");
	printf("      *   *\n");
	printf("        *\n");
}
