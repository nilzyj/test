package com.mingrisoft;

public class Judge {								     	//�½���
	public static void main(String[] args) {			     	//������
		String regex = "\\w{0,}\\@\\w{0,}\\.{1}\\w{0,}";   		//������ʽ�����������ʽ
		String str1 = "aaa@";					     	//�����ַ���str1
		String str2 = "aaaa";						    		//�����ַ���str2
		String str3 = "aaaaa@111.com";			     	//�����ַ���str3
		  if(str1.matches(regex)){					    		//�ж��ַ����Ƿ���������ʽƥ��
			 System.out.println(str1+" ��һ��E_mail��ַ��ʽ");		//�����Ϣ
		  }
		  if(str2.matches(regex)){					    		//�ж��ַ���str2�Ƿ���������ʽƥ��
			 System.out.println(str2+" ��һ��E_mail��ַ��ʽ");		//�����Ϣ
		  }
		  if(str3.matches(regex)){					    		//�ж��ַ���str3�Ƿ���������ʽƥ��
			 System.out.println(str3+" ��һ��E_mail��ַ��ʽ");		//�����Ϣ
		  }
		  else{										//�����������ʽ����ƥ��
			 System.out.println("������E_mail��ַ��ʽ");			     //�����Ϣ
		  }
	 }
}

