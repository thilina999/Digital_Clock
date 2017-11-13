/**
 *  Name: D.M.T.S. Dissanayake
 *  Digital Clock
  */

import javax.swing.*;
import javax.swing.Timer;
import java.text.*;
import java.util.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;

public class clock {
  public static void main(String[] arg) {
    JLabel dateL = new ClockLabel("date");
    JLabel timeL = new ClockLabel("time");
    JLabel dayL = new ClockLabel("day");
    
    JFrame.setDefaultLookAndFeelDecorated(false);
    JFrame frame = new JFrame("Digital Clock");
    frame.setSize(500,250);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(3, 1));
 
    frame.add(dateL);
    frame.add(timeL);
    frame.add(dayL);
 
    frame.getContentPane().setBackground(Color.black);
 
    frame.setVisible(true);
  }
}
 
 class ClockLabel extends JLabel implements ActionListener {
 String type;
  SimpleDateFormat data;
 
  public ClockLabel(String type) {
    this.type = type;
    
 
    switch (type) {
      case "date" : data = new SimpleDateFormat("dd MMMM yyyy");
                    setFont(new Font("Arial", Font.BOLD, 15));
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setForeground(Color.CYAN);
                    break;
      case "time" : data = new SimpleDateFormat("hh:mm:ss ");
                    setFont(new Font("Arial", Font.BOLD, 50));
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setForeground(Color.green);
                    break;
      case "day"  : data = new SimpleDateFormat("EEEE");
                    setFont(new Font("Arial", Font.BOLD, 25));
                    setHorizontalAlignment(SwingConstants.CENTER);
                    setForeground(Color.CYAN);
                    break;
        }
     Timer tme = new Timer(1000, this);
     tme.start();
  }
  public void actionPerformed(ActionEvent time) {
    Date dte = new Date();
    setText(data.format(dte));
  }
}
 