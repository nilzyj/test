import java.io.*;										//导入java.io包
import java.util.zip.*;									//导入java.util.zip包
public class Decompressing {							//创建文件
	public static void main(String[] temp) {
		ZipInputStream zin;							//创建ZipInputStream对象
		try {										//try语句捕获可能发生的异常
			zin = new ZipInputStream(new FileInputStream("E:/work.zip"));
												//实例化对象，指明要进行解压的文件
			ZipEntry entry = zin.getNextEntry();			//获取下一个ZipEntry
			while (((entry = zin.getNextEntry()) != null)	
					&& !entry.isDirectory()) {			//如果entry不为空，并不在同一目录下
				File file = new File(entry.getName());		//获取文件目录
				if (!file.exists()) {					//如果该文件不存在
					file.createNewFile();				//创建文件
				}
				zin.closeEntry();					//关闭当前entry
				System.out.println(entry.getName()+"解压成功");
			}
			zin.close();							//关闭流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
