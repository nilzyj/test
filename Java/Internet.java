import java.net.*;
import java.io.*;

public class Internet {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO �Զ����ɵķ�������
		/*
		InetAddress hd = null;
		try {
			//hd = InetAddress.getByName("www.hitwh.edu.cn");
			hd = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO: handle exception
			System.out.print("error");
		}
		System.out.println(hd);
		*/

		/*
		  URL ur = null;
		try {
			ur = new URL("http://www.nankai.edu.cn/~vmis/java.html");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("error");
		}
		System.out.println(ur);
		System.out.println(ur.toString());
		System.out.println(ur.toExternalForm());
		System.out.println(ur.getProtocol());
		System.out.println(ur.getHost());
		System.out.println(ur.getPort());
		System.out.println(ur.getFile());
		*/

		/*URL root = null;
		URL url = null;
		String readstring;
		DataInputStreamfffa dis;
		try {
			root = new URL("http://zhidao.baidu.com/question/15702198.html");//file://10.93.121.98/program/chapter11/");
			url = new URL(root,args[0]);

			//BufferedReader dis = new BufferedReader(new InputStreamReader(url.openStream()));
			dis = new DataInputStream(url.openStream());
			while((readstring = dis.readLine()) != null)
			{
				System.out.println(readstring);
			}
			dis.close();
		}
		catch (MalformedURLException e) {
			// TODO: handle exception
			System.out.print("M");
		}
		catch (IOException e) {
			// TODO: handle exception
			System.out.print("IO");
		}
		//catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			//System.out.print("ArrayIndexOutOfBoundsException");
		//}
		*/
	}
}
