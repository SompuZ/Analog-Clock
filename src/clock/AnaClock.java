 /*
	Simple Analog Clock
 
	Author: Anupam Roy <anupam.roy.125@gmail.com>
    Copyright (C) 2017  Anupam Roy <anupam.roy.125@gmail.com>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
*/

package clock;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

import javax.swing.JLabel;

import javax.swing.SwingConstants;
import java.util.Timer;

import java.awt.Font;

public class AnaClock extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {		
		new AnaClock();
	}

	/**
	 * Create the frame.
	 */
	
	int x,y;
	double st,mt,ht;
	
	Calendar c=Calendar.getInstance();
	SimpleDateFormat sdf=new SimpleDateFormat("ss");
	SimpleDateFormat mdf=new SimpleDateFormat("mm");
	SimpleDateFormat hdf=new SimpleDateFormat("HH");
	
	public AnaClock() throws InterruptedException {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(new Color(255, 153, 0));
		canvas.setBounds(0, 0, 25, 300);
		contentPane.add(canvas);
		
		Canvas canvas_1 = new Canvas();
		canvas_1.setBackground(new Color(255, 153, 0));
		canvas_1.setBounds(0, 0, 300, 25);
		contentPane.add(canvas_1);
		
		Canvas canvas_2 = new Canvas();
		canvas_2.setBackground(new Color(255, 153, 0));
		canvas_2.setBounds(275, 0, 25, 300);
		contentPane.add(canvas_2);
		
		Canvas canvas_3 = new Canvas();
		canvas_3.setBackground(new Color(255, 153, 0));
		canvas_3.setBounds(0, 275, 300, 25);
		contentPane.add(canvas_3);
		
		JLabel label = new JLabel("12");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(126, 28, 46, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("3");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(239, 133, 38, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("6");
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(126, 238, 46, 42);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("9");
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(10, 133, 62, 25);
		contentPane.add(label_3);
		
		Canvas canvas_4 = new Canvas();
		canvas_4.setBackground(new Color(255, 105, 180));
		canvas_4.setBounds(95, 56, 10, 10);
		contentPane.add(canvas_4);
		
		Canvas canvas_5 = new Canvas();
		canvas_5.setBackground(new Color(255, 105, 180));
		canvas_5.setBounds(50, 98, 10, 10);
		contentPane.add(canvas_5);
		
		Canvas canvas_6 = new Canvas();
		canvas_6.setBackground(new Color(255, 105, 180));
		canvas_6.setBounds(50, 191, 10, 10);
		contentPane.add(canvas_6);
		
		Canvas canvas_7 = new Canvas();
		canvas_7.setBackground(new Color(255, 105, 180));
		canvas_7.setBounds(95, 236, 10, 10);
		contentPane.add(canvas_7);
		
		Canvas canvas_8 = new Canvas();
		canvas_8.setBackground(new Color(255, 105, 180));
		canvas_8.setBounds(197, 56, 10, 10);
		contentPane.add(canvas_8);
		
		Canvas canvas_9 = new Canvas();
		canvas_9.setBackground(new Color(255, 105, 180));
		canvas_9.setBounds(240, 98, 10, 10);
		contentPane.add(canvas_9);
		
		Canvas canvas_10 = new Canvas();
		canvas_10.setBackground(new Color(255, 105, 180));
		canvas_10.setBounds(239, 191, 10, 10);
		contentPane.add(canvas_10);
		
		Canvas canvas_11 = new Canvas();
		canvas_11.setBackground(new Color(255, 105, 180));
		canvas_11.setBounds(197, 238, 10, 10);
		contentPane.add(canvas_11);
		init();
		setVisible(true);
		
		TimerTask clock=new TimerTask() {

			@Override
			public void run() {
				
				repaint();
			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(clock, 0, 1000);
	}
	
	
	
	public void init(){
		
		c=Calendar.getInstance();
		st= (6 * Integer.parseInt(sdf.format(c.getTime()))) -90 ;
		mt= (6 * Integer.parseInt(mdf.format(c.getTime()))) -90 ;
		
		ht= ( (30* Integer.parseInt(hdf.format(c.getTime()))) -90 ) + Integer.parseInt(mdf.format(c.getTime())) % 12 ;
		
	   if(Integer.parseInt(hdf.format(c.getTime())) > 12){
			
		   System.out.println("PM");
			ht= ( 30*( Integer.parseInt(hdf.format(c.getTime())) -12) -90 ) + Integer.parseInt(mdf.format(c.getTime())) % 12 ;
		
		} else {
			  System.out.println("AM");
		}
	
	}
	
	
	public void paint(Graphics g2){
		
		Graphics2D g =(Graphics2D)g2;
		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		super.paintComponents(g);
		
		g.translate(getWidth()/2, getHeight()/2);
		
		//System.out.println(Math.sin(Math.toRadians(30)));
		
		c=Calendar.getInstance();
		
		//System.out.println(hdf.format(c.getTime()));
		
		x= (int) Math.round( 85 * Math.cos( Math.toRadians(mt) ) );
		y= (int) Math.round( 85 * Math.sin( Math.toRadians(mt) ) );
		
		g.setStroke(new BasicStroke(5));
		
		g.setColor(Color.GREEN);
		g.drawLine(0, 0, x, y);
	
		if(sdf.format(c.getTime()).equals("00")){
			mt +=6;
		}
		
		
		x= (int) Math.round( 60 * Math.cos( Math.toRadians(ht) ) );
		y= (int) Math.round( 60 * Math.sin( Math.toRadians(ht) ) );
		
		g.setColor(Color.GREEN);
		g.drawLine(0, 0, x, y);
		
		if(sdf.format(c.getTime()).equals("00") && Integer.parseInt(mdf.format(c.getTime()))%12 == 0 ){
			ht +=6;
		}
		
		
		x= (int) Math.round( 110 * Math.cos( Math.toRadians(st) ) );
		y= (int) Math.round( 110 * Math.sin( Math.toRadians(st) ) );
		
		//System.out.println(200 * Math.cos(t)+ " -> "+x+"      "+ 200 * Math.sin(t)+" -> "+y);
		
		g.setColor(Color.RED);
		g.setStroke(new BasicStroke(2));
		g.drawLine(0, 0, x, y);
		
		
		st += 6;
		
		g.setColor(new Color(72, 61, 139));
		g.fillOval(-5, -5, 10, 10);
	}
}
