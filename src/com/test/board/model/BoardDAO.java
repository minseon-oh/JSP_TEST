package com.test.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.test.board.model.BoardVO;
import com.test.util.JdbcUtil;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {
		
		try {
			
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("클래스 로딩 중 에러발생");
		}
	}
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private DataSource ds;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//글 목록 조회메서드
	public ArrayList<BoardVO> getList(int pageNum, int amount) {
		
		ArrayList<BoardVO> list = new ArrayList<>();
		
		//DB에서 모든 글 목록을 조회해서 VO에 담고 VO를 list에 추가
		String sql = "select *\r\n" + 
				"from(\r\n" + 
				"    select rownum rn,\r\n" + 
				"            bno,\r\n" + 
				"            title,\r\n" + 
				"            writer,\r\n" + 
				"            content,\r\n" + 
				"            regdate\r\n" + 
				"    from(\r\n" + 
				"        select * from t_board order by bno desc\r\n" + 
				"        )\r\n" + 
				"    )\r\n" + 
				"where rn > ? and rn <= ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			//전달되는 페이지 번호를 받아서 쿼리문에 저장 
			pstmt.setInt(1, (pageNum - 1) * amount );
			pstmt.setInt(2, (pageNum * amount) );
			rs = pstmt.executeQuery();
			
			while(rs.next()) { 
				BoardVO vo = new BoardVO(rs.getInt("bno"), rs.getString("title"), rs.getString("writer"), rs.getString("content"), rs.getTimestamp("regdate"));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	//전체 게시글 수 구하는 메서드
	public int getTotal() {
		
		int total = 0;
		
		String sql = "select count(*) as total from t_board";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt("total");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return total;
	}
	
	public void write(BoardVO vo) {

		String sql = "insert into t_board(bno,title,writer,content) values(t_board_seq.nextval,?,?,?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
	}
	
	public BoardVO content(int bno) {
		BoardVO vo = new BoardVO();
		
		String sql = "select * from t_board where bno = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getTimestamp("regdate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	public void modify(BoardVO vo) {
		
		String sql = "update t_board set title=?, content=? where bno = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBno());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
	}
	
	public void delete(String bno) {
		
		String sql = "delete from t_board where bno = ?";
		
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, null);
		}
		
	}
	
}
