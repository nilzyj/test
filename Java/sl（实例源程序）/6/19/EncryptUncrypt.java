package com.mingrisoft;

public class EncryptUncrypt {
    public static String EAndU(String value, char secret) { 			// ��value���ܣ�secret�����ַ�
        byte[] bt = value.getBytes();             					// ����Ҫ���ܵ�����ת��Ϊ�ֽ�����
        for (int i = 0; i < bt.length; i++) {
            bt[i] = (byte) (bt[i] ^ (int) secret);     					// ͨ�����������м���
        }
        return new String(bt, 0, bt.length);        				 	// ���ؼ��ܺ���ַ���
    }
    public static void main(String[] args) {
        String value = "�Ұ�Java";             				 	// ��Ҫ���ܵ�����
        char secret = '��';                       				 	// �����ַ�
        System.out.println("ԭ�ַ���Ϊ��" + value);
        String encrypt = EncryptUncrypt.EAndU(value, secret);		//����
        System.out.println("���ܺ��ֵ��" + encrypt);
        String uncrypt = EncryptUncrypt.EAndU(encrypt, secret);		//����
        System.out.println("���ܺ��ֵ��" + uncrypt);
    }
}

