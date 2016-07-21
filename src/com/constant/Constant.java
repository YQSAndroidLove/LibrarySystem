package com.constant;

public class Constant {
	
	public static int WINDOQ_WIDTH = 800;
	public static int WINDOQ_HEIGHT = 650;
	
	public static int SEARCH_WIDTH = 400;
	public static int SEARCH_HEIGHT = 40;
	
	public static int SEARCH_RESULT_WIDTH = 730;
	public static int SEARCH_RESULT_HEIGHT = 300;
	
	public static int SEARCH_UPDATE_WIDTH = 650;
	public static int SEARCH_UPDATE_HEIGHT = 300;
	
	public static int BOOK_SEARCH = 0;
	public static int BOOK_UPDATE = 1;
	public static int BOOK_DELETE = -1;
	public static int BOOK_BORROW = 2;
	
	public static int FIX_TYPE_READER = 2;			//reader message fix
	public static int FIX_TYPE_BOOK = 3;			//book message fix	
	public static int SHOW_TYPE_READER = 4;			//reader message fix
	public static int READER_MANAGER = 5;			//reader manager
	
	public static int SEARCH_STAGE_READER = 0;
	public static int SEARCH_FIX_READER = 1;
	public static int SEARCH_STAGE_BOOK = 2;
	public static int SEARCH_BOROOW_BOOK = 3;
	public static int SEARCH_SEARCH_BOOK = 4;
	public static int SEARCH_UPDATE_BOOK = 5;
	
	public static int TOOLBAR_MENU_WIDTH = 110;
	public static int TOOLBAR_MENU_HEIGHT = 40;
	
	public static int TOOLBAR_MENU_SETING = 0;				//Seting
	public static int TOOLBAR_MENU_READER = 1;				//Reader
	public static int TOOLBAR_MENU_ADDBOOK = 2;				//AddBook
	public static int TOOLBAR_MENU_SEARCH = 3;				//Search
	public static int TOOLBAR_MENU_BORROW = 4;				//Borrow
	public static int TOOLBAR_MENU_HELP = 5;				//Help
	public static int TOOLBAR_MENU_EXIT = 6;				//Exit
	
	public static String[] SHOW_STRING = {
			"���߱��:","��������:","�����Ա�:","��������:","��ϵ��ʽ:",
			"��������:","����Ժϵ:","��������:","��    ��:","ӵ��Ȩ�ޣ�"
	};	

	public static String[] TABLE_HEAD = {
		"ͼ����", "ͼ������", "ͼ������", "ͼ������", "ͼ��۸�",
		"ͼ������", "����״̬" , "������   ", "��������", "ͼ������"
		};
	
	public static String[] EXIT_TIP = {
		"���ڹر����ݿⲢ�رճ���",
		"���ڹر����ݿⲢ�رճ���.",
		"���ڹر����ݿⲢ�رճ���..",
		"���ڹر����ݿⲢ�رճ���...",
		"���ڹر����ݿⲢ�رճ���....",
		"���ڹر����ݿⲢ�رճ���.....",
		"���ڹر����ݿⲢ�رճ���......",
	};
	
	public static String SHOW_TIP = "����Ϣ��ʾ����ȷʱ�����������������˵�ˢ�£�";
	public static String SEARCH_RESULT_NULL_TIP = "�Բ���,�Ҳ������û�!";
	
	public static int TABLE_COLUM_WIDTH[] = {
		150,250,150,150,100,100,100,150,200,500
		};
	public static String[] HELP={
		"����������������������ϵͳ����Ŭ�������С���������������������",
		
		"���Ϸ��˵�������ʾ��ϵͳ���й��ܣ�����ݲ˵������и��ֲ�����",
		
		"����Ϣ��ʾ������ˢ�����ԣ�",
		
		"��ϵͳ�й���Ա���޸ĺ�̨����,�����Ա����Աֻ���޸�������Ϣ��",
		
		"��� �����������㣬��ຣ����",
		
		"�������������������๦�����ڳﱸ�������ڴ��������������������� ",
	
	};
}
