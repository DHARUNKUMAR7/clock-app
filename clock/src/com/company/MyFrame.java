package com.company;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {
    Calendar calendar;
    SimpleDateFormat timeformat;
    SimpleDateFormat dayformat;
    SimpleDateFormat dateformat;
    JLabel timelabel;
    JLabel daylabel;
    JLabel datelabel;
    String time;
    String day;
    String date;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(false);

        timeformat =new SimpleDateFormat("hh:mm:ss a");
        dayformat =new SimpleDateFormat("EEEE");
        dateformat=new SimpleDateFormat("MMMMM DD,YYYY");

        timelabel=new JLabel();
        timelabel.setFont(new Font("Verdana",Font.PLAIN,50));
        timelabel.setForeground(new Color(0x00ff00));
        timelabel.setBackground(Color.BLACK);
        timelabel.setOpaque(true);

        daylabel=new JLabel();
        daylabel.setFont(new Font("Ink free",Font.BOLD,50));

        datelabel=new JLabel();
        datelabel.setFont(new Font("ink free",Font.BOLD,25));


        this.add(timelabel);
        this.add(daylabel);
        this.add(datelabel);

        this.setVisible(true);
        settime();
    }
    public void settime(){
        while(true){
            time=timeformat.format(calendar.getInstance().getTime());
            timelabel.setText(time);

            day=dayformat.format(calendar.getInstance().getTime());
            daylabel.setText(day);

            date=dateformat.format(calendar.getInstance().getTime());
            datelabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
