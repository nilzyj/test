import java.io.*;													//导入java.io包
public class Example_01 {											//创建类
	public static void main(String[] args) {							//主方法
		try {
			FileOutputStream fs = new FileOutputStream("D:/work.txt");	//创建FileOutputStream对象
			DataOutputStream ds = new DataOutputStream(fs);			//创建DataOutputStream对象
			ds.writeUTF("使用writeUFT()方法写入数据;");			//写入磁盘文件数据
			ds.writeChars("使用writeChars()方法写入数据;");
			ds.writeBytes("使用writeBytes()方法写入数据.");
			ds.close();											//将流关闭
			FileInputStream fis = new FileInputStream("D:/work.txt");		//创建FileInputStream对象
			DataInputStream dis = new DataInputStream(fis);			//创建DataInputStream对象
			System.out.print(dis.readUTF());						//将文件数据输出
		} catch (Exception e) {
			e.printStackTrace();									//输出异常信息
		}
	}
}
