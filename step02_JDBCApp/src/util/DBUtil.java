/* 모든 DAO가 공유하게 되는 자원 제공 및 자원 반환처리
 * sql 의 내용을 load하고 있는 Properties 객체도 단일 객체로 생성해서 모든 DAO가 공유
 * 
 */

package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.sql.ResultSet;

import java.sql.DriverManager;

import java.sql.SQLException;

public class DBUtil {
	private static Properties dbInfo = new Properties(); // DBUtil 에서만 사용
	private static Properties sqlAll = new Properties(); // DAO 클래스들이 사용하고자 하는 객체 0x

	static {
		try {
			dbInfo.load(new FileInputStream("dbinfo.properties"));
			sqlAll.load(new FileInputStream("allSql.properties"));
			
			
			Class.forName(dbInfo.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("해당 driver가 없습니다.");
		}
	}
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbInfo.getProperty("url"), dbInfo.getProperty("id"), dbInfo.getProperty("pw"));
	}
	
	public static Properties getSqlAll() {
		return sqlAll;
	}
	

	public static void close(Connection con, Statement stmt) {
		try {
			
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(con != null) {
				con.close();
				con = null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if(con != null) {
				con.close();
				con = null;
			}
			if(stmt != null) {
				stmt.close();
				stmt = null;
			}
			if(rset != null) {
				rset.close();
				rset = null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

