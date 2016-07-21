package com.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.assistclass.MyFunction;
import com.sqlservice.DriveSQL;
public class Register extends JDialog implements ActionListener{
	private JLabel number,name,sex,age,phone,email,dept,grade,leixing,password,passwordagin,tishi,timu;
	private JTextField number1,name1,phone1,email1,dept1;
	private JPasswordField password1,passwordagin1;
	private JButton ok,look;
	private JComboBox sex1,age1,grade1,leixing1;
	private ImageIcon icon;
	private JLabel tu;
	private JPanel panel,p1,p2,p3,p4,p5,p6;
	private String[] age2,grade2;
	private DriveSQL sql;
	
	public Register(JFrame frame,DriveSQL sql)
	{	
		super(frame,true);
		this.sql=sql;
		this.setLayout(null);
		icon=new ImageIcon("image1\\back.png");
		tu=new JLabel(icon);
		
		panel=new JPanel();
		panel.setOpaque(false);
		timu=new JLabel("用户注册");
		timu.setForeground(Color.red);
		timu.setFont(new Font("华文楷体",1,40));	
		timu.setHorizontalAlignment(SwingConstants.CENTER);
		tishi=new JLabel("温馨提示:带*号的为必填或必选内容哦!");
		tishi.setForeground(Color.red);
		tishi.setFont(new Font("华文楷体",1,16));	
		tishi.setHorizontalAlignment(SwingConstants.CENTER);
		number=new JLabel("*学      号:");
		number.setForeground(Color.red);
		number.setFont(new Font("华文楷体",1,20));	
		
		name=new JLabel("*姓      名:");
		name.setForeground(Color.red);
		name.setFont(new Font("华文楷体",1,20));	
		
		sex=new JLabel("*性别:");
		sex.setForeground(Color.red);
		sex.setFont(new Font("华文楷体",1,20));
		
		
		age=new JLabel("*年 龄:");
		age.setForeground(Color.red);
		age.setFont(new Font("华文楷体",1,20));
		
		phone=new JLabel("*电话号码:");
		phone.setForeground(Color.red);
		phone.setFont(new Font("华文楷体",1,20));	
		//phone.setHorizontalAlignment(SwingConstants.CENTER);
		
		email=new JLabel("* qq邮 箱:");
		email.setForeground(Color.red);
		email.setFont(new Font("华文楷体",1,20));	
		//email.setHorizontalAlignment(SwingConstants.CENTER);
		
		dept=new JLabel("所在院系:");
		dept.setFont(new Font("华文楷体",1,20));	
		//dept.setHorizontalAlignment(SwingConstants.CENTER);
		grade=new JLabel("年级:");
		grade.setFont(new Font("华文楷体",1,20));	
		//grade.setHorizontalAlignment(SwingConstants.CENTER);
		leixing=new JLabel("*读者类型:");
		leixing.setForeground(Color.red);
		leixing.setFont(new Font("华文楷体",1,20));	
		//leixing.setHorizontalAlignment(SwingConstants.CENTER);
		password=new JLabel("*密      码:");
		password.setForeground(Color.red);
		password.setFont(new Font("华文楷体",1,20));	
		//password.setHorizontalAlignment(SwingConstants.CENTER);
		
		passwordagin=new JLabel("*确认密码:");
		passwordagin.setForeground(Color.red);
		passwordagin.setFont(new Font("华文楷体",1,20));	
		//passwordagin.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		number1=new JTextField(16);
		number1.setName("学号");
		name1=new JTextField(16);
		name1.setName("姓名");
		phone1=new JTextField(16);
		phone1.setName("联系电话");
		email1=new JTextField(16);
		email1.setName("qq邮箱");
		dept1=new JTextField(16);
		dept1.setName("专业");
		password1=new JPasswordField(16);
		password1.setName("密码");
		passwordagin1=new JPasswordField(16);
		passwordagin1.setName("密码确认");
		
		sex1=new JComboBox();
		sex1.setName("性别");
		age1=new JComboBox();
		age1.setName("年龄");
		grade1=new JComboBox();
		grade1.setName("年级");
		leixing1=new JComboBox();
		leixing1.setName("读者类型");
		
		sex1.addItem("请选择");
		sex1.addItem("男");
		sex1.addItem("女");
		
		age2=new String[16];
		age1.addItem("请选择");
		for(int i=0;i<=15;i++)
		{
				
			age2[i]=i+15+"";
			age1.addItem(age2[i]);
		}
		
		grade2=new String[16];
		grade1.addItem("请选择");
		for(int i=0;i<=15;i++)
		{
			grade2[i]=2000+i+"年";
			grade1.addItem(grade2[i]);
		}
		
		leixing1.addItem("请选择");
		leixing1.addItem("工作室成员");
		leixing1.addItem("工作室老师");
		
		ok=new JButton("确定");
		ok.addActionListener(this);
		look=new JButton("清空");
		look.addActionListener(this);
		
		timu.setBounds(0, 30, 700, 50);
		tishi.setBounds(20, 65, 300, 30);
		number.setBounds(50, 100, 100, 30);
		number1.setBounds(150, 100, 180, 30);
		name.setBounds(350, 100, 100, 30);
		name1.setBounds(450, 100, 180, 30);
		password.setBounds(50, 160, 100, 30);
		password1.setBounds(150, 160, 180, 30);
		passwordagin.setBounds(350, 160,100, 30);
		passwordagin1.setBounds(450, 160, 180, 30);
		phone.setBounds(50, 220, 100, 30);
		phone1.setBounds(150, 220, 180, 30);
		email.setBounds(350, 220, 100, 30);
		email1.setBounds(450, 220, 180, 30);
		sex.setBounds(100, 280, 100, 30);
		sex1.setBounds(160, 280, 80, 30);
		age.setBounds(260, 280, 100, 30);
		age1.setBounds(330, 280, 80, 30);
		grade.setBounds(430, 280, 100, 30);
		grade1.setBounds(490, 280, 80, 30);
		dept.setBounds(50, 340, 100, 30);
		dept1.setBounds(150, 340, 240, 30);
		leixing.setBounds(410, 340, 100, 30);
		leixing1.setBounds(520, 340, 110, 30);
		ok.setBounds(230, 400, 100, 30);
		look.setBounds(350, 400, 100, 30);
		
		panel.setLayout(null);
		panel.add(timu);
		//panel.add(tishi);
		panel.add(number);
		panel.add(number1);
		panel.add(name);
		panel.add(name1);
		panel.add(password);
		panel.add(password1);
		panel.add(passwordagin);
		panel.add(passwordagin1);
		panel.add(phone);
		panel.add(phone1);
		panel.add(email);
		panel.add(email1);
		panel.add(sex);
		panel.add(sex1);
		panel.add(age);
		panel.add(age1);
		panel.add(grade);
		panel.add(grade1);
		panel.add(dept);
		panel.add(dept1);
		panel.add(leixing);
		panel.add(leixing1);
		panel.add(ok);
		panel.add(look);
		
		
		panel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		tu.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		this.add(panel);
		this.add(tu);
		this.setSize(700, 480);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);	
	}
	public void getsourse(String string)
	{
		String aa="";
		
		if(string=="性别"||string=="年龄"||string=="年级"||string=="读者类型")
		{
			aa="请选择"+string+"等信息!";
		}
		else
		 aa="请填写"+string+"等信息!";
		if(aa!=null)
		{
			int res=JOptionPane.showConfirmDialog(this, aa,"确定",JOptionPane.CLOSED_OPTION);	
		}
		
	}
	
	public boolean istrue()
	{
		if(new MyFunction().isNumber(number1.getText())==false)
		{
			int res=JOptionPane.showConfirmDialog(this, "学号格式错误，请重新填写","确定",JOptionPane.CLOSED_OPTION);	
			return false;
		}
		if(new MyFunction().isPhoneNumberValid(phone1.getText())==false)
		{
			int res=JOptionPane.showConfirmDialog(this, "电话号码格式错误，请重新填写","确定",JOptionPane.CLOSED_OPTION);	
			return false;
		}
		if(new MyFunction().isEmail(email1.getText())==false)
		{
			int res=JOptionPane.showConfirmDialog(this, "邮箱格式错误，请重新填写！","确定",JOptionPane.CLOSED_OPTION);	
			return false;
		}
		if(password1.getText().equals(passwordagin1.getText())==false)
		{
			int res=JOptionPane.showConfirmDialog(this, "两次密码输入不相同，请重新填写！","确定",JOptionPane.CLOSED_OPTION);	
			return false;
		}
		
		return true;	
	}
	public boolean iskong()
	{
		if(number1.getText().isEmpty())
		{
			getsourse(number1.getName());
			return true;
		}
		else if(name1.getText().isEmpty())
		{
			getsourse(name1.getName());
			return true;
		}
		else if(password1.getText().isEmpty())
		{
			getsourse(password1.getName());
			return true;
		}
		else if(passwordagin1.getText().isEmpty())
		{
			getsourse(passwordagin1.getName());
			return true;
		}
		else if(phone1.getText().isEmpty())
		{
			getsourse(phone1.getName());
			return true;
		}
			
		else if(email1.getText().isEmpty())
		{
			getsourse(email1.getName());
			return true;
		}
		else if(sex1.getSelectedItem()=="请选择")
		{
			getsourse(sex1.getName());
			return true;
		}
		else if(age1.getSelectedItem()=="请选择")
		{
			getsourse(age1.getName());
			return true;
		}
		else if(leixing1.getSelectedItem()=="请选择")
		{
			getsourse(leixing1.getName());
			return true;
		}
		return false;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok)
		{
			if(iskong()==false)
				istrue();
			int bb;
			String cc;
			cc=dept1.getText();
		bb=grade1.getSelectedIndex();
			String message="insert into Reader"+"(readerNumber,readerName,readerSex ,readerAge ,readerPassword,readerPhone ,readerEmail ,readerTie ,readerType ,readerGrade,readerLimits )"
					+ "values"+"('"+number1.getText()+"','"+name1.getText()+"','"+sex1.getSelectedItem()+"','"+age1.getSelectedItem()+"','"+password1.getText()
					+"','"+phone1.getText()+"','"+email1.getText()+"','"+cc+"','"+leixing1.getSelectedItem()+"','"+bb+"',"+"'用户');";
			System.out.print(message);
			if(sql.insertMessage(message))
			{
				int res=JOptionPane.showConfirmDialog(this, "插入成功","确定",JOptionPane.CLOSED_OPTION);	
			}
			else
			{
				
			}
		}
		if(e.getSource()==look)
		{
			number1.setText("");
			name1.setText("");
			password1.setText("");
			passwordagin1.setText("");
			phone1.setText("");
			email1.setText("");
			dept1.setText("");
			sex1.setSelectedIndex(0);
			age1.setSelectedIndex(0);
			grade1.setSelectedIndex(0);
			leixing1.setSelectedIndex(0);	
		}
	}

}

