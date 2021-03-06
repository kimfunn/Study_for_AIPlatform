package web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import web.vo.MemberVO;

public class MemberDAO_SpringJDBC {

	//DataSource dataSource;
	
	JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List listMembers() {
		// selectAllmembers() 와 동일
		String sql="select * from member";
		
		List<MemberVO> list = new ArrayList();
		
		list = jdbcTemplate.query(sql, new RowMapper(){//con 대여 + PreparedStatement+executeQuery
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
			MemberVO vo = new MemberVO();
			vo.setId(rs.getString("id"));
			vo.setPw(rs.getString("pw"));
			vo.setName(rs.getString("name"));
			System.out.println(vo);
			return vo;
			}
	}); //con대여 + PreparedStatement+executeQuery
		
		
		return list;

	}
}
/*		Connection con = ds.getConnection();
		PreparedStatement st =con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<MemberVO> list=new ArrayList();
		while(rs.next()) {
			String id= rs.getString("id");
			String pw= rs.getString("pw");
			String name= rs.getString("name");
			MemberVO vo=new MemberVO(id,pw,name);
			list.add(vo);}*/

