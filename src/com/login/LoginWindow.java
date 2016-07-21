package com.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.assistclass.Circle;
import com.data.Reader;
import com.frame.MainFrame;
import com.sqlservice.DriveSQL;
import com.sun.awt.AWTUtilities;

public class LoginWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private Point origin; // �����ƶ�����
	private BufferedImage img; // �����趨���岻������ʽ��ͼƬ

	private ImageIcon background;
	private JTextField userText = new JTextField(30);
	private JPasswordField passwordText = new JPasswordField(30);
	private JLabel userLabel = new JLabel("�� ��:");
	private JLabel passwordLabel = new JLabel("�� ��: ");
	private JButton okbtn = new JButton("ȷ��");
	private JButton resert = new JButton("����");
	private JButton register = new JButton("ע��");

	private DriveSQL sql;

	public LoginWindow() {
		super();

		sql = new DriveSQL();

		background = new ImageIcon("image1\\login1.png");
		JLabel back = new JLabel(background);
		back.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());
		/*
		 * ���ȳ�ʼ��һ��ͼƬ�����ǿ���ѡ��һ����͸�����ֵĲ�����ͼƬ (��Ȼ����Ҫѡ��֧��Alpha(͸��)���ͼƬ��ʽ����PNG)������
		 * ͼƬ������������������״��ͬ�Ĳ�������
		 */
		MediaTracker mt = new MediaTracker(this);

		try {
			img = ImageIO.read(new File("image1\\login1.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		mt.addImage(img, 0);

		try {
			mt.waitForAll(); // ��ʼ�����ɴ�ý����������ٵ�����ͼ��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			initialize(); // �����ʼ��
		} catch (IOException e) {
			e.printStackTrace();
		}

		addMenu();
		this.add(back);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void addMenu() {
		this.setLayout(null);
		Font font = new Font("", 0, 18);
		userLabel.setForeground(Color.white);
		passwordLabel.setForeground(Color.white);
		userLabel.setFont(font);
		passwordLabel.setFont(font);
		passwordText.setEchoChar('*');

		userLabel.setBounds(80, 120, 100, 50);
		passwordLabel.setBounds(80, 160, 100, 50);
		userText.setBounds(140, 130, 170, 30);
		passwordText.setBounds(140, 170, 170, 30);
		okbtn.setBounds(81, 210, 60, 25);
		resert.setBounds(166, 210, 60, 25);
		register.setBounds(251, 210, 60, 25);

		this.add(userLabel);
		this.add(userText);
		this.add(passwordLabel);
		this.add(passwordText);
		this.add(okbtn);
		this.add(resert);
		this.add(register);

		okbtn.addMouseListener(new OwnListener());
		resert.addMouseListener(new OwnListener());
		register.addMouseListener(new OwnListener());
		userText.addKeyListener(new KeyOwnListener());
		passwordText.addKeyListener(new KeyOwnListener());
		
		userText.setText("2013083225");
		passwordText.setText("84878323");
	}

	private void initialize() throws IOException { // �����ʼ��
		// �趨�����С��ͼƬһ����
		this.setSize(img.getWidth(null), img.getHeight(null));
		// �趨���ô���װ�Σ�������ȡ����Ĭ�ϵĴ���ṹ
		this.setUndecorated(true);
		// ��ʼ�������ƶ������ԭ��
		this.origin = new Point();

		// ����AWTUtilities��setWindowShape�����趨������Ϊ�ƶ���Shape��״
		AWTUtilities.setWindowShape(this, getImageShape(img));
		// �趨����ɼ���
		AWTUtilities.setWindowOpacity(this, 0.8f);

		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		// ����ȡ����Ĭ�ϵĴ���ṹ����������Ҫ�ֶ�����һ���ƶ�����ķ���
		this.addMouseListener(new OwnListener());

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
						- origin.y);
			}
		});
	}

	public Shape getImageShape(Image img) {// ��Imageͼ��ת��ΪShapeͼ��
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		int width = img.getWidth(null);// ͼ����
		int height = img.getHeight(null);// ͼ��߶�

		// ɸѡ����
		// ���Ȼ�ȡͼ�����е�������Ϣ
		PixelGrabber pgr = new PixelGrabber(img, 0, 0, -1, -1, true);
		try {
			pgr.grabPixels();
		} catch (InterruptedException ex) {
			ex.getStackTrace();
		}
		int pixels[] = (int[]) pgr.getPixels();

		// ѭ������
		for (int i = 0; i < pixels.length; i++) {
			// ɸѡ������͸�������ص�������뵽����ArrayList x��y��
			int alpha = getAlpha(pixels[i]);
			if (alpha == 0) {
				continue;
			} else {
				x.add(i % width > 0 ? i % width - 1 : 0);
				y.add(i % width == 0 ? (i == 0 ? 0 : i / width - 1) : i / width);
			}
		}

		// ����ͼ����󲢳�ʼ��(0Ϊ͸��,1Ϊ��͸��)
		int[][] matrix = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = 0;
			}
		}

		// ��������ArrayList�еĲ�͸��������Ϣ
		for (int c = 0; c < x.size(); c++) {
			matrix[y.get(c)][x.get(c)] = 1;
		}

		/*
		 * ����Area������ʾ������Խ��кϲ���������һˮƽ"ɨ��"ͼ������ÿһ�У�
		 * ����͸������������ΪRectangle���ٽ�ÿһ�е�Rectangleͨ��Area���rec
		 * ������кϲ�������γ�һ��������Shapeͼ��
		 */
		Area rec = new Area();
		int temp = 0;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (matrix[i][j] == 1) {
					if (temp == 0)
						temp = j;
					else if (j == width) {
						if (temp == 0) {
							Rectangle rectemp = new Rectangle(j, i, 1, 1);
							rec.add(new Area(rectemp));
						} else {
							Rectangle rectemp = new Rectangle(temp, i,
									j - temp, 1);
							rec.add(new Area(rectemp));
							temp = 0;
						}
					}
				} else {
					if (temp != 0) {
						Rectangle rectemp = new Rectangle(temp, i, j - temp, 1);
						rec.add(new Area(rectemp));
						temp = 0;
					}
				}
			}
			temp = 0;
		}
		return rec;
	}

	private int getAlpha(int pixel) {
		return (pixel >> 24) & 0xff;
	}

	/*
	 * ���ǿ���ѡ���ڴ����ϻ���ͼƬ���Ǵ�����ȫ���ֳ�ͼƬ����ʽ�� ��Ȼ����Ҳ���Ը�����Ҫ��������������ȡ��������
	 */

	private class OwnListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			origin.x = e.getX();
			origin.y = e.getY();
		}

		// �����ϵ�������Ҽ��رճ���
		public void mouseClicked(MouseEvent e) {
			if (new Circle(350, 63, 11).contants(e.getX(), e.getY())) {
				System.exit(0);
			} else if (e.getSource() == okbtn) {
				isUserFail();
			} else if (e.getSource() == resert) {
				userText.setText("");
				passwordText.setText("");
			} else if (e.getSource() == register) {
				new Register(LoginWindow.this,sql);
				//System.out.println("Register");
			}
		}

		public void mouseReleased(MouseEvent e) {
			super.mouseReleased(e);
		}
	}

	private class KeyOwnListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (10 == e.getKeyCode()) {
				isUserFail();
			}
		}
	}

	public void isUserFail() {
		String user = userText.getText();
		char[] pw = passwordText.getPassword();
		String password = new String(pw);
		if (!user.equals("") || !password.equals("")) {
			String strSql = "select * from reader where readerNumber='" + user
					+ "';";
			Reader userLogin = sql.getReaderMsg(strSql);
//			Reader userLogin = new Reader(2013083225,"Ҧ��","84878323","��",21,
//				 	"15640928579","2293952179@qq.com","�������ѧ�빤��ѧԺ���繤��",
//				 	"�����ҳ�Ա","2013��","����Ա");
			if (userLogin != null) {
				String userPassword = userLogin.getReaderPassword();
				if (password.equals(userPassword)) {
					new MainFrame(userLogin);
					sql.closeSQL();
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "�������!", "����......",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "�˺Ų�����!", "����......",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "�˺Ż����벻��Ϊ��!", "����......",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
