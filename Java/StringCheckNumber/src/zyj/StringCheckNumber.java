package zyj;

public class StringCheckNumber {

	public static void main(String[] args) {
		String s = "12312312";
		if(StringCheckNumber.IsNumber(s))
		{
			System.out.println(s + " �����ָ�ʽ");
		}
		else
		{
			System.out.println(s + " �������ָ�ʽ");
		}
	}
	public static boolean IsNumber(String str)
	{
		char[] c = str.toCharArray();//���ַ���ת��Ϊ�ַ�����
		for(int i = 0;i < c.length;i++)
		{
			if(Character.isDigit(c[i])){}//�ж��ַ��Ƿ������֣��������ѭ��
			else 
			{
				return false;
			}
		}
		return true;//���������򷵻�true
	}
}
