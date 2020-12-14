package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import model.domain.DeptDTO;
import util.DBUtil;

public class DeptDAO {

	// 모든 메소드가 allSql.properties 파일의 내용을 load 하고 있는 객체를 사용
	static Properties sqlAll = DBUtil.getSqlAll();
	
	//dept가 존재하는 수만큼 DeptDTO 생성해서 ArrayList에 저장후 반환
	public static ArrayList<DeptDTO> deptAll() throws SQLException {
		
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		ArrayList<DeptDTO> datas = null;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();

			//rset = stmt.executeQuery(DBUtil.getSqlAll().getProperty("deptAll"));
			rset = stmt.executeQuery(sqlAll.getProperty("deptAll")); //멤버 변수로 선헌후 멤버 변수 활용
			
			//정상으로 select 문 실행이 완료된 직후에 ArrayList 생성
			//완료되기도 전에 객체 생성과의 차이점: 비정상 문제 발생시 ArrayList객체는 어차피 쓰레기 객체
			datas = new ArrayList<>();
			while(rset.next()) {
				datas.add(new DeptDTO(rset.getInt("deptno"), rset.getString("dname"), rset.getString("loc")));
			}
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		
		return datas;
	}
	
	public static DeptDTO getDept(int deptno) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		

		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty(""));

			pstmt.setInt(1, deptno);
			
			rset = pstmt.executeQuery(); 
			
			
			if(rset.next()) {
				return new DeptDTO(rset.getInt("deptno"), rset.getString("dname"), rset.getString("loc"));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
	
		return null;
	}


	public static boolean insert(DeptDTO newDept) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("dept.insert"));
			
			
			pstmt.setInt(1, newDept.getDeptno());
			pstmt.setString(2, newDept.getDname());
			pstmt.setString(3, newDept.getLoc());
			
			
			if(pstmt.executeUpdate() != 0) {
				return true;
			}
		}  finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//? 로직 수정해서 코드 완성하기
	public static boolean updateDept(int deptno, String newLoc) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("dept.updateDept"));

			pstmt.setString(1, newLoc);
			pstmt.setInt(2, deptno);
			
			int result = pstmt.executeUpdate();
			if(result != 0) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//delete - delete from dept where deptno=60

	public static boolean delete(int deptno) throws SQLException {
		Connection con = null; 
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("dept.delete"));
			
			pstmt.setInt(1, deptno);

			int result = pstmt.executeUpdate();
			if(result != 0) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		//select 호출
//		select();
//		System.out.println("-- 저장 --");
//		insert(90, "hr", "일산");
//		System.out.println("-- 저장 후 검색 --");
//		select();
//		
//		System.out.println("-- 수정 --");
//		update(90, "서울");
//		System.out.println("-- 수정 후 검색 --");
//		select();
//		
//		System.out.println("-- 삭제 --");
//		delete(90);
//		System.out.println("-- 삭제 후 검색  --");
//		select();
	}
}
