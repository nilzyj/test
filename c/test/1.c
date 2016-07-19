#include "stdio.h"
float fsdf(int a,int b)
{
	printf("%d\n",printf("  %d  %d?\n",a,b));
	return 1.212;
}

int main()
{
	//char a='1',b='2',c;
	{
	int z,x,y;
	printf("input x,y,z:");
	scanf("%d%d%d",&x,&y,&z);
	printf("x=%d£¬y=%d£¬z=%d",x,y,z);
	
	printf("fsdf=%f\n",fsdf(1,2));
	}
	//printf("%d\n",printf("%c%c\n",a,b));
	//printf("%d\n",scanf("%c%c",&a,&b));

	//getchar();
	//scanf("%c",&c);
	//printf("%d %d %d\n",a,b,c);
	return 0;
}
