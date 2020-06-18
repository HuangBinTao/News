package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Dao {

	public static ComboPooledDataSource ds;
	static{
		 ds = new ComboPooledDataSource();
	}
}
