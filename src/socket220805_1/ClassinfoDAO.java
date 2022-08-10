package socket220805_1;

import java.sql.*;
import java.util.ArrayList;

public class ClassinfoDAO {

	private static ClassinfoDAO dao = new ClassinfoDAO();
	private ClassinfoDAO(){}

	public static ClassinfoDAO getInstance() {
		return dao;
	}

	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test", "1111");
			if(conn!=null) System.out.println("db성공 ");
			else System.out.println("db실패 ");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return conn;
	}

	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				System.out.println(ex);				
			}
		}
		close(conn, ps);
	} // close

	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
				System.out.println(ex);				
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				System.out.println(ex);				
			}
		}
	} // close

	//table create 
	public void insert(Classinfo ci) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into classinfo(id,name,kor,eng,math) values(?,?,?,?,?)");
			pstmt.setString(1, ci.getId());
			pstmt.setString(2,ci.getName());
			pstmt.setInt(3,ci.getKor());
			pstmt.setInt(4,ci.getEng());
			pstmt.setInt(5,ci.getMath());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);				
		} finally {
			close(conn, pstmt);
		}
	}

	public Classinfo findOne(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Classinfo ci = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from classinfo where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ci = new Classinfo();
				ci.setId(rs.getString(1));
				ci.setName(rs.getString(2));
				ci.setKor(rs.getInt(3));
				ci.setEng(rs.getInt(4));
				ci.setMath(rs.getInt(5));
				
			}

		} catch (Exception ex) {
			System.out.println(ex);				
		} finally {
			close(conn, pstmt, rs);
		}

		return ci;
	}

	public void update(Classinfo ci) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement("update classinfoi set name=?, kor=?, eng=?, math=? where id=?");
			pstmt.setString(1, ci.getName());
			pstmt.setInt(2, ci.getKor());
			pstmt.setInt(3, ci.getEng());
			pstmt.setInt(4, ci.getMath());
			pstmt.setString(5, ci.getId());
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);				
		} finally {
			close(conn, pstmt);
		}

	}

	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from classinfoi where id=?");
			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);				
		} finally {
			close(conn, pstmt);
		}
	}

	public ArrayList<Classinfo> findAll() {

		ArrayList<Classinfo> list = new ArrayList<Classinfo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Classinfo ci = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from classinfoi");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ci = new Classinfo();
				ci.setId(rs.getString(1));	
				ci.setName(rs.getString(2));
				ci.setKor(rs.getInt(3));
				ci.setEng(rs.getInt(4));
				ci.setMath(rs.getInt(5));				
				list.add(ci);
			}

		} catch (Exception ex) {
			System.out.println(ex);				
		} finally {
			close(conn, pstmt, rs);
		}

		return list;
	}

}
