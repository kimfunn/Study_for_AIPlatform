package com.jes.web1.web.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.jes.web1.web.vo.MemberVO;



@Mapper
// Member VO 가 mapper의 Parameter
@Repository("memberDAO")
public interface MemberDAO {
	public void insertMember(MemberVO memberVO) throws DataAccessException;
	
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException;

	public void deleteMember(String id) throws DataAccessException;

	public void updateMember(MemberVO memberVO) throws DataAccessException;
	
	public List<MemberVO> selectAllMemberList() throws DataAccessException;

	public boolean loginCheck(MemberVO vo) throws DataAccessException;

	public void logout(HttpSession session)  throws DataAccessException;



}
