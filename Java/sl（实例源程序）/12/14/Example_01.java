import java.io.*;													//����java.io��
public class Example_01 {											//������
	public static void main(String[] args) {							//������
		try {
			FileOutputStream fs = new FileOutputStream("D:/work.txt");	//����FileOutputStream����
			DataOutputStream ds = new DataOutputStream(fs);			//����DataOutputStream����
			ds.writeUTF("ʹ��writeUFT()����д������;");			//д������ļ�����
			ds.writeChars("ʹ��writeChars()����д������;");
			ds.writeBytes("ʹ��writeBytes()����д������.");
			ds.close();											//�����ر�
			FileInputStream fis = new FileInputStream("D:/work.txt");		//����FileInputStream����
			DataInputStream dis = new DataInputStream(fis);			//����DataInputStream����
			System.out.print(dis.readUTF());						//���ļ��������
		} catch (Exception e) {
			e.printStackTrace();									//����쳣��Ϣ
		}
	}
}
