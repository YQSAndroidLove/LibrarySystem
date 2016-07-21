package com.frame.panel.readerMsg;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.assistclass.FixAssistData;
import com.constant.Constant;
import com.data.Reader;
import com.sqlservice.DriveSQL;

public class FixReaderMsg extends JPanel {

	private DriveSQL sql;
	private Reader user;
	private ImageIcon background;

	public FixReaderMsg(DriveSQL sql,Reader user) {
		this.sql = sql;
		this.user = user;

		this.setLayout(null);
		FixAssistData fixMenu = new FixAssistData(sql,user,Constant.FIX_TYPE_READER);
		fixMenu.setBounds(0, 0, 750, 430);		

		this.background = new ImageIcon("image1\\background.png");
		JLabel back = new JLabel(background);
		back.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
		
		this.add(fixMenu);
		this.add(back);
	}

	/*public void initialize() {

		String tipStr = "������Ϣ�������޸�";
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout(new GridLayout(3, 2, 10, 10));
		p2.setLayout(new GridLayout(2, 2, 30, 10));

		p1.setOpaque(false);
		p2.setOpaque(false);

		label = new JLabel[Constant.SHOW_STRING.length - 1];
		textField = new JTextField[Constant.SHOW_STRING.length - 1];
		panel = new JPanel[Constant.SHOW_STRING.length - 1];

		for (int i = 0; i < Constant.SHOW_STRING.length - 4; i++) {

			label[i] = new JLabel(Constant.SHOW_STRING[i] + "  ");
			label[i].setFont(new Font("���Ŀ���", Font.BOLD, 16));
			label[i].setForeground(Color.red);

			textField[i] = new JTextField();

			panel[i] = new JPanel();
			panel[i].setLayout(new BorderLayout());
			panel[i].setOpaque(false);

			panel[i].add(label[i], BorderLayout.WEST);
			panel[i].add(textField[i], BorderLayout.CENTER);

			p1.add(panel[i]);
		}

		for (int i = 6; i < Constant.SHOW_STRING.length - 1; i++) {

			if (8 == i)
				label[i] = new JLabel("   " + Constant.SHOW_STRING[i] + "  ");
			else
				label[i] = new JLabel(Constant.SHOW_STRING[i] + "  ");
			label[i].setFont(new Font("���Ŀ���", Font.BOLD, 16));

			textField[i] = new JTextField();

			panel[i] = new JPanel();
			panel[i].setLayout(new BorderLayout());
			panel[i].setOpaque(false);

			panel[i].add(label[i], BorderLayout.WEST);
			panel[i].add(textField[i], BorderLayout.CENTER);

			p2.add(panel[i]);
		}

		p1.setBounds(30, 30, 635, 150);
		p2.setBounds(30, 210, 635, 105);
		p1.setBorder(new TitledBorder(tipStr));
		p2.setBorder(new TitledBorder("������Ϣ�޸�"));

		this.add(p1);
		this.add(p2);
	}
*/
		
}
