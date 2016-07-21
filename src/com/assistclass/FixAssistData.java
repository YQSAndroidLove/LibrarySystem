package com.assistclass;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.constant.Constant;
import com.data.Reader;
import com.sqlservice.DriveSQL;

public class FixAssistData extends JPanel {

	private DriveSQL sql;
	private Reader reader;
	private MyFunction function;

	private ImageIcon backIcon;
	private JLabel[] label;
	private JButton[] button;

	private JButton readerNum;
	private JButton readerLimits;
	private JButton deleteBtn;

	private int type;
	private int fontSize;

	public FixAssistData(DriveSQL sql, Reader reader, int type) {
		
		this.sql = sql;
		this.reader = reader;
		this.type = type;

		this.setOpaque(false);		
		
		function = new MyFunction();
		initialize();
	}

	public void initialize() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();

		JPanel[] panel;

		if (type == Constant.FIX_TYPE_READER) {
			fontSize = 16;
		} else if(type == Constant.READER_MANAGER){
			fontSize = 20;
		}else{
			fontSize = 20;
		}

		p1.setLayout(new GridLayout(3, 2, 10, 13));
		p2.setLayout(new GridLayout(2, 2, 30, 13));

		p1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);

		ImageIcon tip = new ImageIcon("tipImage\\fixTip.png");

		readerNum = new JButton(tip);
		readerLimits = new JButton(tip);

		button = new JButton[Constant.SHOW_STRING.length];
		panel = new JPanel[Constant.SHOW_STRING.length];
		label = new JLabel[Constant.SHOW_STRING.length];

		String obj;
		for (int i = 0; i < 6; i++) {
			obj = null;
			switch (i) {
			case 0:
				obj = " " + reader.getReaderNumber();
				break;
			case 1:
				obj = " " + reader.getReaderName();
				break;
			case 2:
				obj = " " + reader.getReaderSex();
				break;
			case 3:
				obj = " " + reader.getReaderAge();
				break;
			case 4:
				obj = "  " + reader.getReaderPhone();
				break;
			case 5:
				obj = " " + reader.getReaderEmail();
				break;
			}
			label[i] = new JLabel(Constant.SHOW_STRING[i] + obj);
			label[i].setFont(new Font("���Ŀ���", Font.BOLD, fontSize));
			label[i].setForeground(Color.red);
			if (type == Constant.FIX_TYPE_READER) {
				panel[i] = new JPanel();
				panel[i].setOpaque(false);
				panel[i].setLayout(new BorderLayout());
				if (i != 0) {
					button[i] = new JButton(tip);
					function.setButtonStyle(button[i]);
					button[i].addMouseListener(new OwnListener());
					panel[i].add(button[i], BorderLayout.EAST);
				}
				panel[i].add(label[i], BorderLayout.CENTER);
				p1.add(panel[i]);
			} else if (type == Constant.READER_MANAGER) {
				if (0 == i) {
					p4.setOpaque(false);
					p4.setLayout(new BorderLayout());
					function.setButtonStyle(readerNum);
					readerNum.addMouseListener(new OwnListener());
					p4.add(readerNum, BorderLayout.EAST);
					p4.add(label[i], BorderLayout.CENTER);
					p1.add(p4);
				} else {
					p1.add(label[i]);
				}
			} else {
				p1.add(label[i]);
			}
		}

		for (int i = 6; i < Constant.SHOW_STRING.length; i++) {
			obj = null;
			switch (i) {
			case 6:
				obj = " " + reader.getReaderTie();
				break;
			case 7:
				obj = " " + reader.getReaderType();
				break;
			case 8:
				obj = " " + reader.getReaderGrade();
				break;
			case 9:
				obj = " " + reader.getReaderLimits();
				break;
			}
			label[i] = new JLabel(Constant.SHOW_STRING[i] + obj);
			label[i].setFont(new Font("���Ŀ���", Font.BOLD, fontSize));
			if (type == Constant.FIX_TYPE_READER) {
				panel[i] = new JPanel();
				panel[i].setOpaque(false);
				panel[i].setLayout(new BorderLayout());
				if (i != Constant.SHOW_STRING.length - 1) {
					button[i] = new JButton(tip);
					function.setButtonStyle(button[i]);
					button[i].addMouseListener(new OwnListener());
					panel[i].add(button[i], BorderLayout.EAST);
				}
				panel[i].add(label[i], BorderLayout.CENTER);
				p2.add(panel[i]);
			} else if (type == Constant.READER_MANAGER) {
				if (9 == i) {
					p5.setOpaque(false);
					p5.setLayout(new BorderLayout());
					function.setButtonStyle(readerLimits);
					readerLimits.addMouseListener(new OwnListener());
					p5.add(readerLimits, BorderLayout.EAST);
					p5.add(label[i], BorderLayout.CENTER);
					p2.add(p5);
				} else {
					p2.add(label[i]);
				}
			} else {
				p2.add(label[i]);
			}
		}

		JLabel tipLabel = new JLabel(Constant.SHOW_TIP, JLabel.CENTER);
		function.setLabelValue(tipLabel, 20, Color.red);
		p3.add(tipLabel);
		
		

		p1.setBorder(new TitledBorder("������Ϣ"));
		p2.setBorder(new TitledBorder("������Ϣ"));
		p3.setBorder(new TitledBorder("��ܰ��ʾ"));

		this.setLayout(null);

		if (type == Constant.READER_MANAGER) {
			deleteBtn = new JButton("ɾ���û�");
			deleteBtn.setBounds(280, 360, 130, 35);
			deleteBtn.addMouseListener(new OwnListener());
			p1.setBounds(30, 80, 635, 150);
			p2.setBounds(30, 240, 635, 100);
			this.add(p1);
			this.add(p2);
			this.add(deleteBtn);
		} else {
			p1.setBounds(30, 20, 635, 150);
			p2.setBounds(30, 195, 635, 100);
			p3.setBounds(30, 320, 635, 80);
			this.add(p1);
			this.add(p2);
			this.add(p3);
		}
	}

	private class OwnListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			String strSql = "update reader set ";
			String result = null;
			if(e.getSource() == deleteBtn){						//�����ö���Ϊ��̨����ʱ��ɾ������ʱ�¼�����
				int isOk = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫɾ����!", "��ʾ......", JOptionPane.CANCEL_OPTION);
				if(isOk == 0){
					if(reader.getReaderLimits().equals("����Ա")){
						JOptionPane.showMessageDialog(null, "�Բ����޷�ɾ�����Ϊ����Ա�Ķ���!","����......", JOptionPane.ERROR_MESSAGE);
					}else{
						strSql = "delete from reader where readerNumber='" + reader.getReaderNumber() + "';";
						sql.updateMessage(strSql);
					}
				}
			}
			else if(e.getSource() == readerNum){							//�����ö���Ϊ��̨����ʱ���޸Ķ��߱���¼�����
				result = function.inputFixMsg("�������µı��:");
				if (result != null) {
					strSql += "readerNumber='" + result+ "' where readerNumber='" + reader.getReaderNumber() + "';";
					sql.updateMessage(strSql);
				}
			}else if(e.getSource() == readerLimits){				//�����ö���Ϊ��̨����ʱ���޸Ķ���Ȩ���¼�����
				result = function.inputFixMsg("�������µĹ���Ȩ��(����Ա/�û�):");
				if (result != null) {
					if(result.equals("����Ա") || result.equals("�û�")){
						strSql += "readerLimits='" + result + "' where readerNumber='" + reader.getReaderNumber() + "';";
						sql.updateMessage(strSql);
					}else {
						JOptionPane.showMessageDialog(null, "����д�����ݲ��Ϸ�!","����......", JOptionPane.ERROR_MESSAGE);
					}
				}
			}else if (e.getSource() == button[1]) {
				result = function.inputFixMsg("�������µ�����:");
				if (result != null) {
					strSql += "readerName='" + result
							+ "' where readerNumber='"
							+ reader.getReaderNumber() + "';";
					sql.updateMessage(strSql);
				}
			} else if (e.getSource() == button[2]) {
				result = function.inputFixMsg("�������µ��Ա���/Ů��:");
				if (result != null) {
					if (result.equals("��") || result.equals("Ů")) {
						strSql += "readerSex='" + result
								+ "' where readerNumber='"
								+ reader.getReaderNumber() + "';";
						sql.updateMessage(strSql);
					} else {
						JOptionPane.showMessageDialog(null, "����д�����ݲ��Ϸ�!",
								"����......", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (e.getSource() == button[3]) {
				result = function.inputFixMsg("�������µ�����(10~80):");
				if (result != null) {
					if (Integer.parseInt(result) >= 10
							&& Integer.parseInt(result) <= 80) {
						strSql += "readerAge='" + result
								+ "' where readerNumber='"
								+ reader.getReaderNumber() + "';";
						sql.updateMessage(strSql);
					} else {
						JOptionPane.showMessageDialog(null, "����д�����ݲ��Ϸ�!",
								"����......", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (e.getSource() == button[4]) {
				result = function.inputFixMsg("�������µ���ϵ��ʽ:");
				if (result != null) {
					if (function.isPhoneNumberValid(result)) {
						strSql += "readerPhone='" + result
								+ "' where readerNumber='"
								+ reader.getReaderNumber() + "';";
						sql.updateMessage(strSql);
					} else {
						JOptionPane.showMessageDialog(null, "������ĺ��벻�Ϸ�!",
								"����......", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (e.getSource() == button[5]) {
				result = function.inputFixMsg("�������µĵ�������:");
				if (result != null) {
					if (function.isEmail(result)) {
						strSql += "readerEmail='" + result
								+ "' where readerNumber='"
								+ reader.getReaderNumber() + "';";
						sql.updateMessage(strSql);
					} else {
						JOptionPane.showMessageDialog(null, "����������䲻�Ϸ�!",
								"����......", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (e.getSource() == button[6]) {
				result = function.inputFixMsg("�������µ�Ժϵ:");
				if (result != null) {
					strSql += "readerTie='" + result + "' where readerNumber='"
							+ reader.getReaderNumber() + "';";
					sql.updateMessage(strSql);
				}
			} else if (e.getSource() == button[7]) {
				result = function.inputFixMsg("�������µĶ�������:");
				if (result != null) {
					strSql += "readerType='" + result
							+ "' where readerNumber='"
							+ reader.getReaderNumber() + "';";
					sql.updateMessage(strSql);
				}
			} else if (e.getSource() == button[8]) {
				result = function.inputFixMsg("�������µ��꼶(1970~2015):");
				if (result != null) {
					if (Integer.parseInt(result) >= 1970
							&& Integer.parseInt(result) <= 2015) {
						strSql += "readerGrade='" + result
								+ "��' where readerNumber='"
								+ reader.getReaderNumber() + "';";
						sql.updateMessage(strSql);
					} else {
						JOptionPane.showMessageDialog(null, "����д�����ݲ��Ϸ�!",
								"����......", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
}
