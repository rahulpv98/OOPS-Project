import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Clock extends JLabel implements ActionListener {
 
  String type;
  SimpleDateFormat sdf;
 
  public Clock(String type) {
    this.type = type;

    	if(type=="date") {
    				sdf = new SimpleDateFormat("  MMMM dd yyyy");
                    setFont(new Font("Norasi", Font.PLAIN, 30));
                    setHorizontalAlignment(SwingConstants.LEFT);
           }
    	else if(type=="time") {
    				sdf = new SimpleDateFormat("hh:mm:ss ");
                    setFont(new Font("Norasi", Font.PLAIN, 30));
                    setHorizontalAlignment(SwingConstants.LEFT);
                    
    	}
    	else if(type=="day") {
    				sdf = new SimpleDateFormat("EEEEE");
                    setFont(new Font("Norasi", Font.PLAIN, 30));
                    setHorizontalAlignment(SwingConstants.LEFT);
                    
    	}
     
    
 
    Timer t = new Timer(1000, this);
    t.start();
  }
 
  public void actionPerformed(ActionEvent ae) {
    Date d = new Date();
    setText(sdf.format(d));
  }
}