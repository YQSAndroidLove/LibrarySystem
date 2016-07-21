package com.frame;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.assistclass.Point;

public class MainMenu extends JPanel {
	
	private ImageIcon back;
	private Point point;
	
	public MainMenu(Point p){
		this.point = p;
		this.setSize(point.getInt_x(),point.getInt_y());
		initialize();
	}
	
	public void initialize(){
		back = new ImageIcon();
		this.setLayout(new GridLayout(8,3,5,10));
		JButton btn0 = new JButton(new ImageIcon());
		JButton btn5 = new JButton(new ImageIcon());
		JButton btn1 = new JButton(new ImageIcon());
		JButton btn2 = new JButton(new ImageIcon());
		JButton btn3 = new JButton(new ImageIcon());
		JButton btn4 = new JButton(new ImageIcon());
		JButton btn6 = new JButton(new ImageIcon());
		JButton btn7 = new JButton(new ImageIcon());
		JButton btn8 = new JButton(new ImageIcon());
		JButton btn9 = new JButton(new ImageIcon());
		JButton btn10 = new JButton(new ImageIcon());
		JButton btn11 = new JButton(new ImageIcon());
		this.add(btn0);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
		this.add(btn6);
		this.add(btn7);
		this.add(btn8);
		this.add(btn9);
		this.add(btn10);
		this.add(btn11);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(back.getImage(),0,0,this);
	}
}
