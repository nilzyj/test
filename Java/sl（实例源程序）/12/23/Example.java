import java.io.*;
public class Example {
	static final int lineLength = 81;
	public static void main(String[] args) {
	  FileOutputStream fos ;
	  
	  byte[] phone = new byte[lineLength];
	  byte[] name = new byte[lineLength];
	  try {
		fos= new FileOutputStream("D:/word.txt");
		while(true){
			System.err.println("请输入一个名字：");
			readLine(name);
			if("done".equalsIgnoreCase(new String(name,0,0,4))){
				break;
			}
			System.err.println("请输入电话号：");
			readLine(phone);
			for(int i = 0;phone[i]!=0;i++){
				fos.write(phone[i]);
			}
			fos.write(',');
			for(int j = 0;name[j]!=0;j++){
				fos.write(name[j]);
			}
			fos.write('\n');
			fos.close();
		}
	} catch (Exception e) {
		// TODO 自动生成 catch 块
		e.printStackTrace();
	}
	}

	private static void readLine(byte[] name) throws IOException {
		int b = 0, i= 0;
		while((i <(lineLength - 1))&& (b= System.in.read())!='\n'){
			name[i++] = (byte)b;
		}
		name[i] = (byte)0;
	}

}
