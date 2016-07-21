package com.frame;

import java.awt.Font;
import java.awt.GridLayout;



import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.constant.Constant;

public class HelpMenu extends JPanel{
	
	private ImageIcon background;
	private JLabel[] label;
	private JPanel panel;
	
	public HelpMenu(){
		
		this.setLayout(null);
		background = new ImageIcon("image1\\helpback.png");
		
		JLabel back = new JLabel(background);
		back.setBounds(1, 1, background.getIconWidth(),background.getIconHeight());
		label=new JLabel[Constant.HELP.length];
		for(int i=0;i<Constant.HELP.length;i++)
		{
			
			label[i]=new JLabel();
			if(i>0&&i<Constant.HELP.length-1)
				label[i].setIcon(new ImageIcon("tipImage\\helpTip.png"));
			label[i].setText(Constant.HELP[i]);
			label[i].setFont(new Font("»ªÎÄ¿¬Ìå",1,18));	
		}
		
		panel=new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new GridLayout(Constant.HELP.length,1));
		for(int i=0;i<label.length;i++)
		{
			
			panel.add(label[i]);
		}
		panel.setBounds(80, 30, 650, 360);
		this.add(panel);
		this.add(back);
	}	
}
