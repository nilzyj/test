struct student//�ṹ��˵����ʽ
{
	char name[5];
	char sex;
	int age;
};

struct monitor
{
	struct student status;//�ṹ��Ƕ��,status�ǽṹ����������Դ������
	int tel;
};

main(){}


/*struct monitor
{
	struct student//�ṹ��˵����ʽ
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
stu ��abc M
pers[3]: asdf m; sdf m; sdf m�����ԱҲ���������ṹ��
pstd:����ǽṹ��������׵�ַ��pstd=&stu;
