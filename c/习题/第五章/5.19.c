#include<stdio.h>

main()
{
	int i,count=0;
	for(i=2000;i<3001;++i)
	{
		if(i%4==0 && i%100!=0 || i%400==0)
		{

			printf("%d ",i);
			count++;
			if(count==10)
			{
				printf("\n");
				count=0;
			}
		}
	}
}