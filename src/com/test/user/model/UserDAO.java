package com.test.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.test.board.model.BoardVO;
import com.test.util.JdbcUtil;

public class UserDAO {
	
	private static UserDAO instance = new UserDAO();

	private UserDAO() {
		
		try {
			
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("클래스 로딩 중 에러발생");
		}
	}
	
	public static UserDAO getInstance() {
		return instance;
	}

	private DataSource ds;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//아이디 중복체크
	public int checkId(String id) {
		int result = 0;
		
		String sql = "select * from t_users where id = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}else {
				result = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	//회원가입
	public int insert(UserVO vo) {
		
		int result = 0;
		
		String sql = "insert into t_users values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone1());
			pstmt.setString(5, vo.getPhone2());
			pstmt.setString(6, vo.getPhone3());
			pstmt.setString(7, vo.getEmail1());
			pstmt.setString(8, vo.getEmail2());
			pstmt.setString(9, vo.getAddr_basic());
			pstmt.setString(10, vo.getAddr_detail());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		return result;
	}
	
	//로그인 체크
	public int login(String id, String pw) {
		int result = 0;
		
		String sql = "select * from t_users where id = ? and pw = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}else {
				result = 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		return result;
	}
	
	public UserVO info(String id) {
		
		UserVO vo = new UserVO();
		
		String sql = "select * from t_users where id = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setEmail1(rs.getString("email1"));
				vo.setEmail2(rs.getString("email2"));
				vo.setPhone1(rs.getString("phone1"));
				vo.setPhone2(rs.getString("phone2"));
				vo.setPhone3(rs.getString("phone3"));
				vo.setAddr_basic(rs.getString("addr_basic"));
				vo.setAddr_detail(rs.getString("addr_detail"));
			}else {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	//정보수정
	public void update(UserVO vo) {

		String sql = "update t_users set pw=?, name=?, email1=?, email2=?,"
				+ "phone1=?, phone2=?, phone3=?, addr_basic=?, addr_detail=?"
				+ "where id = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail1());
			pstmt.setString(4, vo.getEmail2());
			pstmt.setString(5, vo.getPhone1());
			pstmt.setString(6, vo.getPhone2());
			pstmt.setString(7, vo.getPhone3());
			pstmt.setString(8, vo.getAddr_basic());
			pstmt.setString(9, vo.getAddr_detail());
			pstmt.setString(10, vo.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}

	}
	
	//회원탈퇴
	public int delete(String id) {
		int result = 0;
		
		String sql = "delete from t_users where id = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
		return result;
		
	}
	
	
}
