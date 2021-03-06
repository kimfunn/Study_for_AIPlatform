package web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController{
//MAC = multi action controller 
	
	
	public ModelAndView memberInfo(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView(); // /test/result.jsp 로 응다바라
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//db를 다녀와서 성공했으면 이렇게
		mav.addObject("loginedId",id);
		mav.addObject("loginedPw",pw);
		
		mav.setViewName("memberinfo");
		return mav;
	}
	
	
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView(); // /test/result.jsp 로 응다바라
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//db를 다녀와서 성공했으면 이렇게
		mav.addObject("loginedId",id);
		
		mav.setViewName("result");
		return mav;
	}
}

// 가장 심플한 형태
