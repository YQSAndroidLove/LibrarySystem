package com.frame.panel.seting;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.constant.Constant;
import com.sqlservice.DriveSQL;

public class AddBook extends JPanel{
	
	private JComboBox comboBoxYear;
	private JComboBox comboBoxMouth;
	private JLabel[] label;
	private JLabel jlabel;
	private JLabel back;
	
	private JTextField[] textfield;
	private JButton okButton;
	private JButton cancleButton;
	private String[] stringMassage= {
			"ͼ����:  ", "ͼ������:  ", "ͼ������:  ", "ͼ������:  ", "ͼ��۸�:  ",
			"ͼ������:  ", "����״̬:  ", "������   :  ", "��������:  "
			};
	private String[] selectYear;
	private String[] selectMonth;
	private DriveSQL sql;
	
	private int selectYearId =0;
	private int selectMonthId=0;
	private String selectYearItem="��ѡ����";
	private String selectMonthItem="��ѡ���·�";
	
	public AddBook(DriveSQL sql){
		this.sql = sql;
		
		this.setLayout(null);
		ImageIcon icon = new ImageIcon("image1\\background.png");
		back = new JLabel(icon);
		back.setBounds(0, 0, icon.getIconWidth()+5,icon.getIconHeight());
	
		initialized();
		this.add(back);	
	}
	
	public void initialized(){
		selectYear = new String[67];
		selectYear[0] = "��ѡ����";
		for(int i=66,count=1;i>0;i--,count++){
			selectYear[count]= ""+(i+1949);
		}
		selectMonth = new String[13];
		selectMonth[0] = "��ѡ����";
		for(int i=1;i<13;i++){
			selectMonth[i]=""+(i);
		}
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridBagLayout());
		p1.setOpaque(false);
		
		okButton = new JButton("ȷ��");
		okButton.addMouseListener(new mouseAction());
		cancleButton = new JButton("ȡ��");
		cancleButton.addMouseListener(new mouseAction());
		label = new JLabel[stringMassage.length];
		jlabel = new JLabel("����鼮��Ϣ");
		jlabel.setFont(new Font("���Ŀ���",0,35));
		textfield = new JTextField[stringMassage.length];
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridheight = 2;//ռ�ݸ��ӵĿ�Ⱥ͸߶�
		c.gridwidth = 4;
		c.gridx =0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;		
		p1.add(jlabel,c);
		
		int countrlX =0;
		int countrlY =0;
		for(int i=0;i<Constant.TABLE_HEAD.length-1;i++){			
			label[i] = new JLabel(stringMassage[i]);			
			textfield[i] = new JTextField(18);
			c.gridheight = 1;//ռ�ݸ��ӵĿ�Ⱥ͸߶�
			c.gridwidth = 1;
			c.weightx = 0;
			c.weighty = 1;
			if(i%2==0){countrlX++;}//��ӱ�ǩ
			c.gridx = countrlY;
			c.gridy = countrlX+1;
			//c.anchor = GridBagConstraints.CENTER;
			label[i].setFont(new Font("���Ŀ���",0,20));
			p1.add(label[i],c);
			if(i<stringMassage.length-1){//��ӵ����ı���
			c.gridwidth = 1;
			c.gridx = countrlY+1;
			c.gridy = countrlX+1;
			c.ipady = 15;
			c.anchor = GridBagConstraints.EAST;
			p1.add(textfield[i],c);
			}
			countrlY+=2;
			if(countrlY%4==0)countrlY=0;
			if(i==stringMassage.length-1){
				c.gridx = 2;
				c.ipadx = 80;
				c.gridy = countrlX+2;
				p1.add(okButton,c);
				c.gridx = 3;
				c.gridy = countrlX+2;
				p1.add(cancleButton,c);
			}
		}
		c.gridx =1;
		c.gridy =6;	
		c.anchor = GridBagConstraints.CENTER;
		comboBoxYear = new JComboBox(selectYear);		
		//�����ѡ������¼�
		comboBoxYear.addItemListener(new ItemListener() {
			 public void itemStateChanged(final ItemEvent e) {
				  int index = comboBoxYear.getSelectedIndex();
				  if (index != 0) { // ==0��ʾѡ�е��µ�һ��					  
					  selectYearId =index;
					  selectYearItem =comboBoxYear.getSelectedItem().toString();
				     }
				  }
			});		
		p1.add(comboBoxYear,c);		
		
		c.gridx =2;			
		comboBoxMouth = new JComboBox(selectMonth);				
				//�����ѡ������¼�
				comboBoxMouth.addItemListener(new ItemListener() {
					public void itemStateChanged(final ItemEvent e) {
						  int index = comboBoxMouth.getSelectedIndex();						  
						  if (index != 0) { // ==0��ʾѡ�е��µ�һ��
							  selectMonthId =index;
							  selectMonthItem =comboBoxMouth.getSelectedItem().toString();
						     }
						  }
					});				
		p1.add(comboBoxMouth,c);	
		p1.setBounds(0, 0, 700, 400);
		this.add(p1);
		
	}
	//�@ȡ�x�����Ϣ
	public void getMassage(){
		boolean isSure = true;
//		for(int i=0;i<stringMassage.length-1;i++){
//			System.out.println(textfield[i].getText());
//			
//		}
		//ͼ����
		if(textfield[0].getText().isEmpty()){
			isSure = false;
		}
		//ͼ������
		if(textfield[1].getText().isEmpty()){
			isSure = false;
		}
		//ͼ������
		if(textfield[2].getText().isEmpty()&&textfield[2].getText().length()>10){
			isSure = false;
		}
		//ͼ������
		if(textfield[3].getText().isEmpty()&&textfield[3].getText().length()>20){
			isSure = false;
		}
		//ͼ��۸�
		if(textfield[4].getText().isEmpty()){
			isSure = false;
		}
		//ͼ������
		if(textfield[5].getText().isEmpty()){
			isSure = false;
		}
		//ͼ��״̬
		if(textfield[6].getText().isEmpty()){
			isSure = false;
		}
		//������
		if(textfield[7].getText().isEmpty()){
			isSure = false;
		}
		//��������
		if(isSure){
		//�����ݿ����������
		String data = selectYearItem+"+"+selectMonthItem;
		String strSql = "insert into book values('"+textfield[0].getText()+"',"
				+ "'"+textfield[1].getText()+"','"+textfield[2].getText()+"',"
						+ "'"+textfield[3].getText()+"','"+textfield[4].getText()+"',"
								+ "'"+textfield[5].getText()+"','"+textfield[6].getText()+"',"
										+ "'"+textfield[7].getText()+"',"
												+ "'"+data+"','');";
		System.out.println(strSql);
		if(sql.insertMessage(strSql)){
			JOptionPane.showMessageDialog(null, "��ӳɹ�!", "�ɹ�......", JOptionPane.ERROR_MESSAGE);
			setMassage();
			//System.out.println("����ɹ�");			
		}
		else{
			JOptionPane.showMessageDialog(null, "���ʧ��!", "����......", JOptionPane.ERROR_MESSAGE);
			System.out.println("����ʧ��");
		}		
		}
		else{
			JOptionPane.showMessageDialog(null, "��������!", "����......", JOptionPane.ERROR_MESSAGE);
		}
		//System.out.println(strSql);
	}
	//���³�ʼ���x���Ϣ
	public void setMassage(){
		for(int i=0;i<stringMassage.length-1;i++){
			textfield[i].setText("");
		}	
		comboBoxYear.setSelectedIndex(0);
		comboBoxMouth.setSelectedIndex(0);
		selectYearId = 0;
		selectYearItem = "��ѡ����";
		selectMonthId = 0;
		selectMonthItem = "��ѡ���·�";
	}
	//ȡ���x헵�����¼�
	class mouseAction extends MouseAdapter{
		public void mouseClicked(MouseEvent m){
			if(m.getSource() == okButton){
				getMassage();
			}else if(m.getSource() == cancleButton){
				setMassage();
			}
		}
	}	
}

