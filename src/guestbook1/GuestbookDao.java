package guestbook1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDao {

	
	//필드 
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "webdb";
	private String pw = "1234";
	
	
	private void getConnection() {

		try {
			// JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

	}

	// 5. 자원정리
		private void close() {

			try {

				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}
		
		//등록 
		public int insert(GuestbookVo guestbookVo) {

			int count = 0;

			getConnection();

			try {

				// 3. SQL문 준비 / 바인딩 / 실행

				// SQL문 준비
				String query = "";
				query += " insert into guestbook ";
				query += " values (seq_guestbook_no.nextval, ?, ?, ?, ?) ";

				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, guestbookVo.getName());
				pstmt.setString(2, guestbookVo.getPassword());
				pstmt.setString(3, guestbookVo.getContent());
				pstmt.setString(4, guestbookVo.getDate());
				
				
				// 실행
				count = pstmt.executeUpdate();

				// 4.결과처리

			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

			close();

			return count;
			
			

		}
		
		public List<GuestbookVo> getGuestList() {
			
			List<GuestbookVo> guestList = new ArrayList<GuestbookVo>();
			
			getConnection();
			
			try {

				// 3. SQL문 준비 / 바인딩 / 실행 --> 완성된 sql문을 가져와서 작성할것
				// 3. SQL문 준비 
				String query = "";
				query += " select no ";
				query += "         ,name ";
				query += "         ,password ";
				query += "         ,content ";
				query += "         ,to_char(reg_date, 'YYYY-MM-DD HH:MI:SS') \"reg_date\" ";
				query += " from guestbook ";
				
				//바인딩
				pstmt = conn.prepareStatement(query); // 쿼리로 만들기
					
				//실행 
				rs = pstmt.executeQuery();

				
				
				
				// 4.결과처리
				while (rs.next()) {
					int no = rs.getInt("no");
					String name = rs.getString("name");
					String password = rs.getString("password");
					String content = rs.getString("content");
					String reg_date = rs.getString("reg_date");

					guestList.add(new GuestbookVo(no, name, password, content, reg_date));
				}

			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

			close();
			return guestList;
		}
		
		
		//Guest 추가
		public int selcet(int count) {

			List<GuestbookVo> guestbooklist = new ArrayList<GuestbookVo>();			
			
			getConnection();

			try {

				// 3. SQL문 준비 / 바인딩 / 실행
				
				//3. SQL문 준비 
				String query = "";
				query += " select  no ";
				query += "        ,name ";
				query += "        ,password ";
				query += "        ,content ";
				query += "        ,reg_date ";
				query += " from guestbook ";

				pstmt = conn.prepareStatement(query); // 쿼리로 만들기

				pstmt.setString(1, GbookVo.getName());
				pstmt.setString(2, GbookVo.getPassword());
				pstmt.setString(3, GbookVo.getContent());
				pstmt.setString(4, GbookVo.getDate());
				

				count = pstmt.executeUpdate(); 

				// 4.결과처리
				System.out.println("[" + count + "건 추가되었습니다.]");

			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
			close();
			
			return count;
		}
		
		
}
