package com.data;

public class Data {
	/*
	 	create table Reader(
	 		readerNumber char(10) UNIQUE NOT NULL,
	 		readerName char(30) NOT NULL,
	 		readerPassword char(10) NOT NULL,
	 		readerSex char(2) CHECK (readerSex IN('��','Ů')),
	 		readerAge SMALLINT CHECK (readerAge >= 15 AND readerAge <= 30),
	 		readerPhone char(11) NOT NULL,
	 		readerEmail char(20),
	 		readerTie char(20) NOT NULL,
	 		readerType char(10),
	 		readerGrade char(5),
	 		readerLimits char(10) NOT NULL,
	 		PRIMARY KEY (readerNumber)
	 	);
	 	
	 	
	 	Insert into Reader Values 
	 	('2013083225','Ҧ��','84878323','��','21',
	 	'15640928579','2293952179@qq.com','�����ѧԺ���繤��',
	 	'�����ҳ�Ա','2013��','����Ա');
	 	
	 	
	 	update reader set readerTie='�����ѧԺ���繤��' where readerNumber='2013083225';
	 	update reader set readerLimits='����Ա' where readerNumber='2013083225';
	 */
	
	/*
	 	create table Book(
	 		bookNumber char(10) UNIQUE NOT NULL,
	 		bookName char(20) NOT NULL,
	 		bookType char(10),
	 		bookAuthor char(20) NOT NULL,
	 		bookPrice SMALLINT CHECK (bookPrice >= 1),
	 		bookCount SMALLINT CHECK (bookCount >= 0),
	 		bookState char(10) CHECK (bookState IN ('�ɽ�','���ɽ�')),
	 		bookPress char(20),
	 		bookDate char(20),
	 		bookDiscuss char(100)
	 	);
	 	
	 	
	 	insert into book values ('TP312JA527','java��Ŀ��������','���','���տƼ�','39.80','2','�ɽ�','�廪��ѧ������','2012-1-1','�Ȿ�齲�ĺܲ���ӡˢҲ���ԡ�');
	 	insert into book values ('TP312JA528','���ݿ�ϵͳ����','���','��ɺ  ��ʦ��','39.80','2','�ɽ�','�ߵȽ���������','2014-9-1','�Ȿ�齲�ĺܲ���ӡˢҲ���ԡ�');
	 	insert into book values ('TP312JA529','java������300��','���','���տƼ�','39.80','2','�ɽ�','�廪��ѧ������','2012-1-1','�Ȿ�齲�ĺܲ���ӡˢҲ���ԡ�');
	 	insert into book values ('TP312JA530','java��Ŀ��������','���','���տƼ�','39.80','2','�ɽ�','�廪��ѧ������','2012-1-1','�Ȿ�齲�ĺܲ���ӡˢҲ���ԡ�');
	 	insert into book values ('TP312JA531','java��Ŀ��������','���','���տƼ�','39.80','2','�ɽ�','�廪��ѧ������','2012-1-1','�Ȿ�齲�ĺܲ���ӡˢҲ���ԡ�');
	 	insert into book values ('TP312JA550','�ִ����ǳ�ʶ','�Ļ�����','����','39.80','1','�ɽ�','�廪��ѧ������','2011-5-5','ѧ�������Ǻ��б�Ҫ��');
	 	
	 */
/*	create table Borrow(
			authorNum INT,
			bookNum VARCHAR(20),
			borrowTime CHAR(20),
			borrowCount INT);
			
			insert into Borrow values('2013083225','TP312JA527','2013-9-4','1');
	*/
}
