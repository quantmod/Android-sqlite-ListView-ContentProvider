package cn.itcast.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    
	
	/* ���°汾��Ϊ0��ʱ�򣬾ͻ�ִ��onCreate����(�����ݿ��ļ���һ�δ�����ʱ��汾�ž���0)
	 * ����汾�Ų�Ϊ0���ͺ��ϰ汾�Ž��бȽϣ�������ڵĻ�����ִ����������onUpgrade�����������ִ�н���onDowngrade������
	 * ������������ʵ�ֺܼ�:ֱ���׳��쳣��Ҳ����˵���ݿⲻ�����������ģ����Ҳ�������������
	 */
	public DBOpenHelper(Context context) {
		super(context, "itcast.db", null, 2);//<��>/databases/
	}

	@Override
	public void onCreate(SQLiteDatabase db) {//�������ݿ��һ�α�������ʱ����õ�
		db.execSQL("CREATE TABLE person(personid integer primary key autoincrement, name varchar(20), phone VARCHAR(12) NULL)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("ALTER TABLE person ADD amount integer");
	}

}
