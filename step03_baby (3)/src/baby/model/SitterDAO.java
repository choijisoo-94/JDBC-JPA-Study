package baby.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import baby.model.dto.SitterDTO;
import baby.model.util.DBUtil;

public class SitterDAO {

	static Properties sqlAll = DBUtil.getSqlAll();

	public static boolean addSitter(SitterDTO sitter) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("sitter.insert"));

			pstmt.setString(1, sitter.getName());
			pstmt.setString(2, sitter.getGender());
			pstmt.setInt(3, sitter.getAge());
			pstmt.setString(4, sitter.getLocation());
			pstmt.setString(5, sitter.getSitterid());
			pstmt.setInt(6, sitter.getOrderid());
			pstmt.setString(7, sitter.getPhonenumber());
			pstmt.setString(8, sitter.getCertification());
			pstmt.setString(9, sitter.getExperience());
			pstmt.setInt(10, sitter.getHourlywage());
			pstmt.setString(11, sitter.getDuration());
			pstmt.setString(12, sitter.getClearance());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}

		return false;
	}

	public static boolean updateSitter(String sitterid, String phonenumber) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("sitter.update.phonenumber"));

			pstmt.setString(1, phonenumber);
			pstmt.setString(2, sitterid);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}

		return false;
	}

	public static boolean deleteSitter(String sitterid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("sitter.update.phonenumber"));

			pstmt.setString(1, sitterid);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}

		return false;
	}

	public static SitterDTO getSitter(String sitterid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		SitterDTO sitter = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("sitter.getsitter"));
			pstmt.setString(1, sitterid);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				sitter = new SitterDTO(rset.getString("name"), rset.getString("gender"), rset.getInt("age"),
						rset.getString("location"), rset.getString("sitterid"), rset.getInt("orderid"),
						rset.getString("phonenumber"), rset.getString("certification"), rset.getString("experience"),
						rset.getInt("hourlywage"), rset.getString("duration"), rset.getString("clearance"));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return sitter;
	}

	public static ArrayList<SitterDTO> getAllSitters() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SitterDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("sitter.getallsitters"));
			rset = pstmt.executeQuery();

			list = new ArrayList<SitterDTO>();
			while (rset.next()) {
				list.add(new SitterDTO(rset.getString("name"), rset.getString("gender"), rset.getInt("age"),
						rset.getString("location"), rset.getString("sitterid"), rset.getInt("orderid"),
						rset.getString("phonenumber"), rset.getString("certification"), rset.getString("experience"),
						rset.getInt("hourlywage"), rset.getString("duration"), rset.getString("clearance")));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;

	}
	
	
	public static ArrayList<SitterDTO> getLocAllSitters(String loc) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SitterDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("sitter.getlocallsitters"));
			pstmt.setString(1, loc);
			rset = pstmt.executeQuery();

			list = new ArrayList<SitterDTO>();
			while (rset.next()) {
				list.add(new SitterDTO(rset.getString("name"), rset.getString("gender"), rset.getInt("age"),
						rset.getString("location"), rset.getString("sitterid"), rset.getInt("orderid"),
						rset.getString("phonenumber"), rset.getString("certification"), rset.getString("experience"),
						rset.getInt("hourlywage"), rset.getString("duration"), rset.getString("clearance")));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;

	}

	public static ArrayList<SitterDTO> getSitters1(String parentid, String duration, int hourlywage) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<SitterDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("sitter.getsitters1"));
			pstmt.setString(1, parentid);
			pstmt.setString(2, duration);
			pstmt.setInt(3, hourlywage);
			
			rset = pstmt.executeQuery();

			list = new ArrayList<SitterDTO>();
			while (rset.next()) {
				list.add(new SitterDTO(rset.getString("name"), rset.getString("gender"), rset.getInt("age"),
						rset.getString("location"), rset.getString("sitterid"), rset.getInt("orderid"),
						rset.getString("phonenumber"), rset.getString("certification"), rset.getString("experience"),
						rset.getInt("hourlywage"), rset.getString("duration"), rset.getString("clearance")));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;

	}

}
