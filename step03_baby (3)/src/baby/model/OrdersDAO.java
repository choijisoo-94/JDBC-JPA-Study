package baby.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import baby.model.dto.OrdersDTO;
import baby.model.dto.SitterDTO;
import baby.model.util.DBUtil;

public class OrdersDAO {
	
	static Properties sqlAll = DBUtil.getSqlAll();

	public static boolean addOrders(OrdersDTO orders) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("orders.insert"));

			pstmt.setInt(1, orders.getOrderid());
			pstmt.setString(2, orders.getParentid());
			pstmt.setString(3, orders.getSitterid());
			pstmt.setString(4, orders.getChildid());
			pstmt.setInt(5, orders.getHourlywage());
			pstmt.setString(6, orders.getDuration());
			

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}

		return false;
	}
	
	public static boolean updateOrdersSitter(int orderid, String sitterid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sqlAll.getProperty("orders.update.sitterid"));
			pstmt.setString(1, sitterid);
			pstmt.setInt(2, orderid);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateOrdersParent(int orderid, String parentid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sqlAll.getProperty("orders.update.parentid"));
			pstmt.setString(1, parentid);
			pstmt.setInt(2, orderid);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	
	public static boolean deleteOrders(int orderid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sqlAll.getProperty("orders.delete"));
			pstmt.setInt(1, orderid);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;

	}
	
	public static OrdersDTO getOrders(int orderid) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		OrdersDTO orders = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("orders.getorders"));
			pstmt.setInt(1, orderid);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				orders = new OrdersDTO(rset.getInt("orderid"), rset.getString("parentid"),
						rset.getString("sitterid"), rset.getString("childid"),
						rset.getInt("hourlywage"), rset.getString("duration"));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return orders;
	}

	public static ArrayList<OrdersDTO> getAllOrders() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<OrdersDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlAll.getProperty("orders.getallorders"));
			rset = pstmt.executeQuery();

			list = new ArrayList<OrdersDTO>();
			while (rset.next()) {
				list.add(new OrdersDTO(rset.getInt("orderid"), rset.getString("parentid"),
						rset.getString("sitterid"), rset.getString("childid"),
						rset.getInt("hourlywage"), rset.getString("duration")));
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


