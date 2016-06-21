struct student
{
	char name[5];
	char sex;
}stu,*pstd,arrstu[3];
pstd=&stu;
//结构体成员的引用
stu.sex;//stu.sex=='m';
pstd->sex;
(*pstd).sex;

stu.name[0];
pstd->name[0];//变量
(*pstd).name[0];

arrstu[0].sex;//第一个结构体里的sex变量,引用结构体数组中的变量成员
arrstu[1].sex;


arrstu[0].name[0];//第一个结构体里的字符数组的第一个元素，引用结构体数组中的数组成员
arrstu[1].name[0];

//内嵌结构体成员的引用
struct student//结构体说明形式
{
	char name[5];
	char sex;
	int age;
}

struct monitor
{
	struct student status;//结构体嵌套。status结构体变量，相当于stu。status是monitor的成员。
	int tel;
}stu,*s;
s=&stu;

stu.status.sex;
s->status.sex;
(*s).status.sex;

stu.status.name[0];
s->status.name[1];
(*s).status.name[4];

