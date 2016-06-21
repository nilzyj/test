struct student
{
	char name[5];
	char sex;
}stu,*s,arrstu[3];
s=&stu;

void fun1(char a){}//形参和实参的类型要一样
void fun2(struct student j)//fun2中的实参传递给形参，才能使用结构体成员
{
	j.sex 
	j.name[0]
}
void fun3(struct student *p){}//*前面有struct类型所以是指针定义
void fun4(struct student *p){}	

main()
{
	fun1(stu.sex);//结构体成员作为实参
	fun2(stu);//结构体整体(变量)作为实参,
	fun3(s);//指针存结构体变量的地址，作为实参
	fun4(arrstu);//结构体数组名作为实参
}












//函数之间传递
int fun(int a)
{
	a=1
	return a;
}

void test()
{
	fun(b);
}

main()
{
	test();
}