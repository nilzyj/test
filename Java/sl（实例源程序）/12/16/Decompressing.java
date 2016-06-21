import java.io.*;										//����java.io��
import java.util.zip.*;									//����java.util.zip��
public class Decompressing {							//�����ļ�
	public static void main(String[] temp) {
		ZipInputStream zin;							//����ZipInputStream����
		try {										//try��䲶����ܷ������쳣
			zin = new ZipInputStream(new FileInputStream("E:/work.zip"));
												//ʵ��������ָ��Ҫ���н�ѹ���ļ�
			ZipEntry entry = zin.getNextEntry();			//��ȡ��һ��ZipEntry
			while (((entry = zin.getNextEntry()) != null)	
					&& !entry.isDirectory()) {			//���entry��Ϊ�գ�������ͬһĿ¼��
				File file = new File(entry.getName());		//��ȡ�ļ�Ŀ¼
				if (!file.exists()) {					//������ļ�������
					file.createNewFile();				//�����ļ�
				}
				zin.closeEntry();					//�رյ�ǰentry
				System.out.println(entry.getName()+"��ѹ�ɹ�");
			}
			zin.close();							//�ر���
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
