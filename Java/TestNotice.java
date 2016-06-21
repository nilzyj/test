package notice;

import java.io.*;

public class TestNotice
{
	private String message;
	public TestNotice() {};
	public void setMessage(String message)	
	{
		try
		{
			FileOutputStream out = new FileOutputStream("mes.txt");
			OutputStreamWriter osw = new OutputStreamWriter(out);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(message);
			out.print(message);
			osw.close();
		}
		catch (IOException e)
		{
			// TODO: handle exception
		}	
	}
	public String getMessage()
	{
		String message=null,s;
		try
		{
			FileInputStream in = new FileInputStream("mes.txt");
			InputStreamReader osr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(osr);
			
			while((s = br.readLine()) != null)
				message+=s;
			osr.close();
			
		}
		catch (IOException e)
		{
			// TODO: handle exception
		}
		return "dsf";
	}
}
