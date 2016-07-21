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
			"读者编号:","读者姓名:","读者性别:","读者年龄:","联系方式:",
			"电子邮箱:","所在院系:","读者类型:","年    级:","拥有权限："
	};	

	public static String[] TABLE_HEAD = {
		"图书编号", "图书名称", "图书类型", "图书作者", "图书价格",
		"图书数量", "借阅状态" , "出版商   ", "出版日期", "图书评论"
		};
	
	public static String[] EXIT_TIP = {
		"正在关闭数据库并关闭程序",
		"正在关闭数据库并关闭程序.",
		"正在关闭数据库并关闭程序..",
		"正在关闭数据库并关闭程序...",
		"正在关闭数据库并关闭程序....",
		"正在关闭数据库并关闭程序.....",
		"正在关闭数据库并关闭程序......",
	};
	
	public static String SHOW_TIP = "当信息显示不正确时，请点击工具栏的主菜单刷新！";
	public static String SEARCH_RESULT_NULL_TIP = "对不起,找不到改用户!";
	
	public static int TABLE_COLUM_WIDTH[] = {
		150,250,150,150,100,100,100,150,200,500
		};
	public static String[] HELP={
		"。。。。。。。。。。。系统正在努力完善中。。。。。。。。。。。",
		
		"最上方菜单栏已显示此系统所有功能，请根据菜单栏进行各种操作。",
		
		"若信息显示有误，请刷新重试！",
		
		"本系统中管理员可修改后台数据,管理会员；会员只可修改自身信息。",
		
		"如果 给您带来不便，请多海涵！",
		
		"。。。。。。。。更多功能正在筹备，敬请期待。。。。。。。。。。 ",
	
	};
}
