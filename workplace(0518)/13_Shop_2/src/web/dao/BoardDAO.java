package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import web.util.ShopException;
import web.vo.ArticleVO;
import web.vo.MemberVO;

public class BoardDAO {
	DataSource ds;
	//동시성 문제 
	//C
	public BoardDAO() {
		//1. 드라이버 등록 //한번만 해야 좋은일 (계속 반복하면 request 건수 만큼 수행됨)
		// connection full 찾기
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/MyDB"); //connectionPool
			
			
		} catch (Exception e) {
			System.out.println("드라이버 등록 실패");
			}
	}

	public ArrayList<ArticleVO> selectAllArticles() throws ShopException {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs=null;
			try {
			
			
			//2. 연결 (Connection 얻기)
			 con= ds.getConnection();//대여
		
		
			//3. Statement 생성
			 st = con.prepareStatement("select LEVEL, articleNO, parentNO,title,content,id,writeDate "
			 		+ " from t_board"
			 		+ " start with parentNO=0"
			 		+ " connect by prior articleno=parentno"
			 		+ " order siblings by articleNO desc");//sql문 들어가야함
			 
			//4. SQL 전송 ? 없어서 필요없음
/*			st.setString(1, vo.getId());
			st.setString(2, vo.getPw());
*/		
			rs=st.executeQuery();
			
			
			//5. 결과얻기
			ArrayList<ArticleVO> list=new ArrayList<ArticleVO>();
			while (rs.next()) {
				int level=rs.getInt("level");
				int articleNO=rs.getInt("articleNO");
				int parentNO=rs.getInt("parentNO");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String id=rs.getString("id");
				Date writeDate=rs.getDate("writeDate");
				
				ArticleVO vo =new ArticleVO( level, articleNO, parentNO, title, content, null,id, writeDate);
				list.add(vo);
			} 
			return list;
			//6. 종료
			
			}catch(Exception e) {
				e.printStackTrace(); //디버깅을 위한 실행시에는 빼야함 보안을 위해 
				throw new ShopException("게시판 리스트실패");
				
			}finally {
				//6. 종료
				try {
					//연것의 반대방향으로 닫아줌
					rs.close();
					st.close(); 
					con.close(); //반납
				}catch(Exception e) {
					
				}
			}
			
		}

	public synchronized void insertNewArticle(ArticleVO vo) throws ShopException {
		Connection con = null;
		PreparedStatement st = null, st2=null;
		ResultSet rs=null;
		try {
		
		
		//2. 연결 (Connection 얻기)
		 con=ds.getConnection();//대여
	
	
		//3. Statement 생성
		 st = con.prepareStatement("insert into t_board"
		 		+ "(articleNO, parentNO,title,content,imageFileName,id,writeDate) "
		 		+ "values (?,?,?,?,?,?,sysdate)");//sql문 들어가야함
		 
		//4. SQL 전송
		 st2=con.prepareStatement("select max(articleNO) from t_board");
		 rs=st2.executeQuery();
		 int articleNO=0;
		 if(rs.next()) {
			 
			articleNO = rs.getInt(1)+1; // 1번 필드를 가져왔으니까 1번이라고 함 (필드 번호로 가능)
			System.out.println(articleNO);
		 }
		st.setInt(1, articleNO);
		st.setInt(2, 0);//첫번째 글이니까 0
		st.setString(3, vo.getTitle());
		st.setString(4, vo.getContent());
		st.setString(5, vo.getImageFileName());
		st.setString(6, vo.getId());
		
		int i=st.executeUpdate();
		
		
		//5. 결과얻기
		System.out.println(i+"행이 insert 되었습니다.");
		
		//6. 종료
		
		}catch(Exception e) {
			e.printStackTrace(); //디버깅을 위한 실행시에는 빼야함 보안을 위해 
			throw new ShopException("글쓰기 실패");
			
		}finally {
			//6. 종료
			try {
				rs.close();
				st.close(); 
				con.close(); //반납
			}catch(Exception e) {
				
			}
		}
	}

	public ArticleVO selectArticle(int articleNO) throws ShopException {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs=null;
		try {
		
		
		//2. 연결 (Connection 얻기)
		 con= ds.getConnection();//대여
	
	
		//3. Statement 생성
		 String query ="select parentNO, title, content,imageFileName,id,writeDate"
		 		+ " from t_board"
		 		+ " where articleNO=?";
		 
		 st=con.prepareStatement(query);
		//4. SQL 전송 ? 없어서 필요없음
		 st.setInt(1, articleNO);
		 rs=st.executeQuery();
		
		
		//5. 결과얻기
			while (rs.next()) {
			
			int parentNO=rs.getInt("parentNO");
			String title=rs.getString("title");
			String content=rs.getString("content");
			String imageFileName=rs.getString("imageFileName");
			String id=rs.getString("id");
			Date writeDate=rs.getDate("writeDate");
			
			ArticleVO vo =new ArticleVO( 0, articleNO, parentNO, title, content,imageFileName,id, writeDate);
			return vo;
			} 
		return null;
		//6. 종료
		
		}catch(Exception e) {
			e.printStackTrace(); //디버깅을 위한 실행시에는 빼야함 보안을 위해 
			throw new ShopException("글 가져오기 실패");
			
		}finally {
			//6. 종료
			try {
				//연것의 반대방향으로 닫아줌
				rs.close();
				st.close(); 
				con.close(); //반납
			}catch(Exception e) {
				
			}
		}
		
	}
		
	}


