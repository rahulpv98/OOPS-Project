
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Frame extends JFrame{
	 JLabel lblmin= new JLabel("00");
	 JLabel hours= new JLabel("00:");
	 JLabel minutes= new JLabel("00:");
	 JLabel seconds= new JLabel("00:");
	 JLabel miliseconds = new JLabel("00");
	 JButton start= new JButton("START");
	 JButton stop= new JButton("STOP");
	 int mili=0;
	 int m,s,min1,sec1;
	 Timer timer;
	 Boolean flag=true;
	 Boolean ifStop=false;
	 int sec=0;
	 int min=0;
	 int hour=0;
	 int state=1;
	 JButton reset= new JButton("RESET");
	 JLabel lblsec = new JLabel("00");
	
public Frame()
{	
	JFrame frame = new JFrame("Clock");
	
	Container cntr = frame.getContentPane();
	cntr.setLayout(null);
	JComboBox comsec = new JComboBox();
	comsec.setBounds(450, 100, 68, 24);
	for(int i=0;i<60;i++)
		if(i<10)
			comsec.addItem("0"+i);
		else
			comsec.addItem(i);
	cntr.add(comsec);
	
	JComboBox commin = new JComboBox();
	commin.setBounds(350, 100, 68, 24);
	for(int i=0;i<121;i++)
		if(i<10)
			commin.addItem("0"+i);
		else
			commin.addItem(i);
	cntr.add(commin);
	lblmin.setFont(new Font("Dialog", Font.BOLD, 50));
	lblmin.setBounds(375, 20, 75, 60);
	cntr.add(lblmin);
	
	lblsec.setFont(new Font("Dialog", Font.BOLD, 50));
	lblsec.setBounds(450, 20, 75, 60);
	cntr.add(lblsec);
	
	
	JLabel lblSetTimwe = new JLabel("Set Timer:");
	lblSetTimwe.setFont(new Font("Norasi", Font.BOLD, 17));
	lblSetTimwe.setBounds(350, 0, 148, 24);
	cntr.add(lblSetTimwe);
	
	JLabel lblStopwatch = new JLabel("Stopwatch");
	lblStopwatch.setFont(new Font("Norasi", Font.BOLD, 17));
	lblStopwatch.setBounds(100, 0, 148, 24);
	cntr.add(lblStopwatch);
	
	JLabel lblMin = new JLabel("Min:");
	lblMin.setBounds(350, 75, 70, 15);
	cntr.add(lblMin);
	
	JLabel lblSec = new JLabel("Sec:");
	lblSec.setBounds(450, 75, 70, 15);
	cntr.add(lblSec);
	frame.setVisible(true);
	frame.setBounds(500,100,600,625);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JButton btnStart = new JButton("Start");

	
	btnStart.setFont(new Font("Dialog", Font.BOLD, 10));
	btnStart.setBounds(350, 150, 64, 25);
	cntr.add(btnStart);
	
	JButton btnStop = new JButton("Stop");
	
	btnStop.setFont(new Font("Dialog", Font.BOLD, 10));
	btnStop.setBounds(450, 150, 64, 25);
	cntr.add(btnStop);

	Clock q=new Clock("date");
	Clock q2=new Clock("time");
	Clock q3=new Clock("day");
	q.setBounds(150,300,2000,30);
	q2.setBounds(220, 400, 2000, 30);
	q3.setBounds(220, 500, 2000, 37);
	cntr.add(q);
	cntr.add(q2);
	cntr.add(q3);
	
	
	cntr.add(hours);
	cntr.add(minutes);
	cntr.add(seconds);
	cntr.add(miliseconds);
	cntr.add(start);
	cntr.add(stop);
	cntr.add(reset);
	
	Font f = new Font("arial",Font.BOLD,30);
	hours.setFont(f);
	minutes.setFont(f);
	seconds.setFont(f);
	miliseconds.setFont(f);
	
	
	hours.setBounds(35,20,60,60);
	minutes.setBounds(90,20,60,60);
	seconds.setBounds(145,20,60,60);
	miliseconds.setBounds(200,20,260,60);
	start.setBounds(25,75,100,30);
	stop.setBounds(130,75,100,30);
	reset.setBounds(75,125,100,30);
	
	btnStart.addActionListener(new ActionListener()
	{
		
		public void actionPerformed(ActionEvent e)
		{	btnStart.setEnabled(false);
			btnStop.setEnabled(true);
			m = Integer.valueOf((String) commin.getSelectedItem());
			s = Integer.valueOf((String) comsec.getSelectedItem());
			timer = new Timer(1000, new ActionListener()
			{
				
				// @Override
				public void actionPerformed(ActionEvent arg0)
				{
					
					if(ifStop) {
						m = min1;
						s = sec1;
						ifStop = false;
					}
					if(s==0) {
						s=60;
						m--;
					}
					if(m==0) {
						lblmin.setForeground(Color.red);
						lblsec.setForeground(Color.red);
						
					}
					if(m<0)
					{
						JOptionPane.showMessageDialog(frame, "Times up", "Stopped", 0);
						m=0;s=0;
						timer.stop();
						btnStart.setEnabled(true);
						btnStop.setEnabled(false);
						
					}
					else {
						s--;
						if(s<10) {
							lblsec.setText("0"+s);
							flag = false;
						}
						if(m<10) {
							lblmin.setText("0"+m);
							if(s<10)
								lblsec.setText("0"+s);
							else
								lblsec.setText(""+s);
							flag=false;
						}
						if(flag) {
							lblmin.setText(""+m);
							lblsec.setText(""+s);
						}
					}
				}
				
			}
			);
			timer.start();
		}
	}
	);
	
	btnStop.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
			min1 = m;
			sec1 = s;
			ifStop = true;
			timer.stop();
			btnStart.setEnabled(true);
		}
	}
	);
	start.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent event)
		{	start.setEnabled(false);
			state=1;
			
			Thread t = new Thread()
			{
				public void run()
				{
					
						for(;;)
						{
							if(state==1)
							{
							
								try
								{
									sleep(1);
								
									if(mili>1000)
									{
										mili=0;
										sec++;
									}
								
									if(sec>60)
									{
										mili=0;
										sec=0;
										min++;
									}
								
									if(min>60)
									{
										mili=0;
										sec=0;
										min=0;
										hour=0;
									}
									
									miliseconds.setText(":"+mili);
									mili++;
									seconds.setText(":"+sec);
									minutes.setText(":"+min);
									hours.setText(""+hour);
								}
				
								catch(Exception e)
								{
							
								}
							}
							
							else if(state==2)
							{
								break;
							}
							
							else if(state==3)
							{
								miliseconds.setText(": 0");
								seconds.setText(": 0");
								minutes.setText(": 0");
								hours.setText("0");
								
								mili=0;
								sec=0;
								min=0;
								hour=0;
								
							}
						}	
				}
			};
			t.start();
		}
	});
	
	stop.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent event)
		{	start.setEnabled(true);
			state=2;
		}
	});
	
	reset.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent event)
		{
			state=3;
			miliseconds.setText(": 0");
			seconds.setText(": 0");
			minutes.setText(": 0");
			hours.setText("0");
			mili=0;
			sec=0;
			min=0;
			hour=0;
			
		}
	});
}}	
