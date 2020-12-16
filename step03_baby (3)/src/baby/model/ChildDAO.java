package baby.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import baby.model.dto.ChildDTO;
import baby.model.dto.ChildDTO;
import baby.model.util.DBUtil;

public class ChildDAO {

	static Properties sqlAll = DBUtil.getSqlAll();

	public static boolean addChild(ChildDTO child) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("child.insert"));

			pstmt.setString(1, child.getName());
			pstmt.setString(2, child.getGender());
			pstmt.setInt(3, child.getAge());
			pstmt.setString(4, child.getChildid());
			pstmt.setString(5, child.getParentid());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deletechild(String childid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sqlAll.getProperty("child.delete"));
			pstmt.setString(1, childid);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;

	}

	public static ChildDTO getChild(String childid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ChildDTO child = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("child.getchild"));
			pstmt.setString(1, childid);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				child = new ChildDTO(rset.getString("name"), rset.getString("gender"), rset.getInt("age"),
						rset.getString("childid"), rset.getString("parentid"));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return child;
	}

	public static ArrayList<ChildDTO> getAllChilds() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ChildDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("child.getallchilds"));
			rset = pstmt.executeQuery();

			list = new ArrayList<ChildDTO>();
			while (rset.next()) {
				list.add(new ChildDTO(rset.getString("name"), rset.getString("gender"), rset.getInt("age"),
						rset.getString("childid"), rset.getString("parentid")));
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
