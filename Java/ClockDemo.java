import java.awt.*;
import java.util.*;
import javax.swing.*;
//数字时钟
public class ClockDemo extends JFrame implements Runnable{
	Thread clock;	
	
	public ClockDemo(){
		super("");
		setFont(new Font("Times New Roman",Font.BOLD,61));
		start();
		setSize(280,100);
		setVisible(true);
		this.setLocation(440,330);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void start(){
		if (clock==null){
			clock=new Thread(this);
			clock.start();
		}
	}
	
	public void run(){
		while (clock!=null){
			repaint();
			try{
				Thread.sleep(1000);
			}
			catch (InterruptedException ex){
				ex.printStackTrace();
			}
		}	
	}
	
	public void stop(){  //??????
		clock=null;
	}
	
	public void paint(Graphics g){  paint????
		Graphics2D g2=(Graphics2D)g;
		Calendar now=new GregorianCalendar();
		String timeInfo="";
		int hour=now.get(Calendar.HOUR_OF_DAY);
		int minute=now.get(Calendar.MINUTE);
		int second=now.get(Calendar.SECOND);
		if (hour<=9) 
			timeInfo+="0"+hour+":";
		else 
			timeInfo+=hour+":";
		if (minute<=9)
			timeInfo+="0"+minute+":";
		else
			timeInfo+=minute+":";
		if (second<=9)
			timeInfo+="0"+second;
		else
			timeInfo+=second;

		g.setColor(Color.orange);
		Dimension dim=getSize();
		g.fillRect(0,0,dim.width,dim.height);
		g.setColor(Color.black);
		g.drawString(timeInfo,20,80);
	}

	public static void main(String[] args){
		new ClockDemo();
	}
}


