#include<stdio.h>
#include<string.h>

struct STR
{char num[10];int s;};

main()
{
	struct STR t,*p;
	t.num[0]="a";
	t.num[0]="b";
	t.num[0]="c";
	p=&t;
	//p->num[0]='\0';
	//strcpy((*p).num,"");
	//puts(t.num);
	p->s=99;
	printf("%d",(*p).s);
}

/*
void fun(char *a)
{
    int i=0,j,k;
    while(a[i]=='*')
        ++i;
    for(j=i+1;*a;++j)
    {
        if(a[j]=='*')
        {
            for(k=j;*a;++k)
                a[k]=a[k+1];
        }
    }
	//a[j]='\0';
}

main()
{
    char s[81];
    gets(s);
    fun(s);
    puts(s);
}*/
