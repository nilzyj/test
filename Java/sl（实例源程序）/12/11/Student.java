import java.io.*;										//导入java.io包
public class Student {								//创建类
	public static void main(String args[]) {				//主方法
		String content[] = { "明日科技", "Java部", "快速入门" };//定义字符串数组
		File file = new File("D:/work.txt");				//创建文件对象
		try {
			FileWriter fw = new FileWriter(file);			//创建FileWriter类对象
			BufferedWriter bufw = new BufferedWriter(fw);	//创建BufferedWriter类对象
			for (int k = 0; k < content.length; k++) {		//循环遍历数组
				bufw.write(content[k]);				//将字符串数组中元素写入到磁盘文件中
				bufw.newLine();					//将数组中的单个元素以单行的形式写入文件
			}
			bufw.close();							//将BufferedWriter流关闭
			fw.close();								//将FileWriter流关闭
		} catch (Exception e) {						//处理异常
			e.printStackTrace();
		}
		try {
			FileReader fr = new FileReader(file);			//创建FileReader类对象
			BufferedReader bufr = new BufferedReader(fr);//创建BufferedReader类对象
			String s = null;							//创建字符串对象
			int i = 0;								//声明int型变量
			while ((s = bufr.readLine()) != null) {		//如果文件的文本行数不为null,则进入循环
				i++;								//将变量做自增运算
				System.out.println("第" + i + "行:" + s);	//输出文件数据
			}
			bufr.close();							//将FileReader流关闭
			fr.close();								//将FileReader流关闭
		} catch (Exception e) {						//处理异常
			e.printStackTrace();
		}
	}
}
