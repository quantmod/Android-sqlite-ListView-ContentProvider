package cn.itcast.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    
	
	/* 当新版本号为0的时候，就会执行onCreate方法(当数据库文件第一次创建的时候版本号就是0)
	 * 如果版本号不为0，就和老版本号进行比较，如果大于的话，就执行升级操作onUpgrade方法，否则就执行降级onDowngrade方法，
	 * 不过降级方法实现很简单:直接抛出异常，也就是说数据库不允许降级操作的，这个也符合正常情况。
	 */
	public DBOpenHelper(Context context) {
		super(context, "itcast.db", null, 2);//<包>/databases/
	}

	@Override
	public void onCreate(SQLiteDatabase db) {//是在数据库第一次被创建的时候调用的
		db.execSQL("CREATE TABLE person(personid integer primary key autoincrement, name varchar(20), phone VARCHAR(12) NULL)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("ALTER TABLE person ADD amount integer");
	}

}
