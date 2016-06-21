import java.io.*;
import java.util.zip.*;

import javax.swing.*;

import com.sun.java.swing.plaf.windows.WindowsBorders.ProgressBarBorder;

public class Student {
	public static void main(String[] temp) {
		byte b[] = new byte[30];
		try{
			FileInputStream fis = new FileInputStream("D:/word.txt");
			ProgressMonitorInputStream in = 
				new ProgressMonitorInputStream(null,"¶ÁÈ¡ÎÄ¼þ",fis);
			ProgressMonitor p = in.getProgressMonitor();
		   while(in.read(b)!=-1){
			   String s = new String(b);
			   System.out.println(s);
			   Thread.sleep(1000);
		   }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
