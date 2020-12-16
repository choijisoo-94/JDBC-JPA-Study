package baby.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import baby.exception.NotExistException;
import baby.model.dto.ParentDTO;
import baby.model.util.DBUtil;

public class ParentDAO {

	static Properties sqlAll = DBUtil.getSqlAll();

	public static boolean addParent(ParentDTO parent) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("parent.insert"));

			pstmt.setString(1, parent.getName());
			pstmt.setString(2, parent.getGender());
			pstmt.setInt(3, parent.getAge());
			pstmt.setString(4, parent.getLocation());
			pstmt.setString(5, parent.getParentid());
			pstmt.setString(6, parent.getPhonenumber());
			pstmt.setString(7, parent.getChildid());
			pstmt.setString(8, parent.getClearance());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}

		return false;
	}

	public static boolean updateParent(String parentid, String phonenumber) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("parent.update.phonenumber"));

			pstmt.setString(1, phonenumber);
			pstmt.setString(2, parentid);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}

		return false;
	}
	
	
	public static boolean deleteParent(String parentid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("parent.delete"));

			pstmt.setString(1, parentid);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}

		return false;
	}

	public static ParentDTO getParent(String parentid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ParentDTO parent = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("parent.getparent"));
			pstmt.setString(1, parentid);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				parent = new ParentDTO(rset.getString("name"), rset.getString("gender"), rset.getInt("age"),
						rset.getString("location"), rset.getString("parentid"), rset.getString("phonenumber"),
						rset.getString("childid"), rset.getString("clearance"));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return parent;
	}

	public static ArrayList<ParentDTO> getAllParents() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ParentDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("parent.getallparents"));
			rset = pstmt.executeQuery();

			list = new ArrayList<ParentDTO>();
			while (rset.next()) {
				list.add(new ParentDTO(rset.getString("name"), rset.getString("gender"), rset.getInt("age"),
						rset.getString("location"), rset.getString("parentid"), rset.getString("phonenumber"),
						rset.getString("childid"), rset.getString("clearance")));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	public static ArrayList<ParentDTO> getIdParents(String parentid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ParentDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("parent.getidparents"));
			pstmt.setString(1, parentid);
			rset = pstmt.executeQuery();

			list = new ArrayList<ParentDTO>();
			while (rset.next()) {
				list.add(new ParentDTO(rset.getString("name"), rset.getString("gender"), rset.getInt("age"),
						rset.getString("location"), rset.getString("parentid"), rset.getString("phonenumber"),
						rset.getString("childid"), rset.getString("clearance")));
			}
		} catch (SQLException s) {
			s.printStackTrace();
			throw s;
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;

	}
	
	public static String getParentlocation(ParentDTO parent) throws SQLException, NotExistException {
		return parent.getLocation();
	}


}
