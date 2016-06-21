struct student//结构体说明形式
{
	char name[5];
	char sex;
	int age;
};

struct monitor
{
	struct student status;//结构体嵌套,status是结构体变量，可以存放数据
	int tel;
};

main(){}


/*struct monitor
{
	struct student//结构体说明形式
	{
		char name[5];
		char sex;
		int age;
	};
	int tel;
};*/




struct student
{
	char name[5];
	char sex;
}stu,pers[3],*pstd;//d
stu ：abc M
pers[3]: asdf m; sdf m; sdf m三组成员也就是三个结构体
pstd:存的是结构体变量的首地址，pstd=&stu;
