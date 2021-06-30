package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	//@ResponseBody //아웃범퍼에 저장한다
	@RequestMapping("/")
	public String home() {
		System.out.println("home() 호출됨");
		return "index.html";
	}
	//없으면 view 페이지를 지정한다 (view 페이지는 전부 static 밑에 있어야함)
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("hello() 호출됨");
		return "html/hello.html";
	}
}
