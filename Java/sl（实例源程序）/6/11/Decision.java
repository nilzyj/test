package com.mingrisoft;

public class Decision {
	public static void main(String[] args) {
		String s1 = "Mrkj007                    // ��Ҫ�����жϵ��ַ���
     	                  String s2 = "mrkj007"; 
		                                                     // �ж��ַ�������s��ֵ�Ƿ�Ϸ�
	boolean bn1 = s1.matches("\\p{Upper}\\p{Lower}\\p{Lower}\\p{Lower}\\d\\d\\d");
     	boolean bn2 = s2.matches("\\p{Upper}\\p{Lower}\\p{Lower}\\p{Lower}\\d\\d\\d");
	System.out.println(s1+"�ǺϷ���������"+bn1);	      // �ڿ���̨������
     	System.out.println(s2+"�ǺϷ���������"+bn2);
}
}
