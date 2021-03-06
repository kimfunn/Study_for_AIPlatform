package web.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import web.vo.MemberVO;

public class MemberDAO {

		// jdbc 템플릿과 같은 역할을 하는 mybatis활용
	private static SqlSessionFactory sqlMapper=null;
	
	public static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
			String resource="mybatis/SqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public List<MemberVO> listMembers(){
		sqlMapper=getInstance();
		// con 과 같은 기능
		SqlSession session =sqlMapper.openSession();
		List<MemberVO> list = session.selectList("mapper.member.selectAllMemberList");
		return list;
	}
	
}

