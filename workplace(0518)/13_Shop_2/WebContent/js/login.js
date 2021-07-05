	$(document).ready(function(){
		$('loginBtn').click(function(){
			
			const id=$('#id').val();
			const pw=$('#pw').val();
			alert(id+":"+pw);
			//console.log(opener.document.getElementById("welcomeMsg"));
			
			//회원가입 요청
			//AJAX 기술 활용 https://www.w3schools.com/js/js_ajax_intro.asp
			// JQuery-AJAX https://www.w3schools.com/jquery/jquery_ajax_intro.asp
			/* 
			$.get('../Main?name='+name+"&id="+id+"&pw="+pw,function(data, status){
				alert("Data: " + data + "\nStatus: " + status);
				window.close();
			}); */

			$.post("main",
					  {
						sign :"login",
					    id,
					    pw //비구조화 할당
					  },
					  function(data, status){
						  data=JSON.parse(data); //이라인에서 자바스크립트가 됨 
						  console.log(data);
						  if(data.msg){ //include는 스트링이라서 에러가 안났지만 json text 를 활용했기 떄문에 js object가 됨
							  //java script object 는 string 이 아니라서 include 안됨
							 
							  //fail //name에 login 이 없다고 생각
							  alert(data.msg);
						  }else{//ok //로그인 성공
							  //document.cookie = "username="+data;
						  		//jquery로
							
						  		$.cookie("id",data.id,{path:'/'}); //json 과 js 의 변환이 필요하다 그리고 json에는 parse라는 메서드가 있음
						  		//https://www.w3schools.com/js/js_json_parse.asp

							  opener.document.getElementById("welcomeMsg").innerHTML=data.id+"님 환영합니다  <button id='logoutBtn'>로그아웃</button>  <button id='memberDeleteBtn'>회원탈퇴</button>";
					 		 // window.close();
						   
						  }//end else
				 		   }//end function
		);//end post
			//opener.document.getElementById("welcomeMsg").textContent=name+"님 환영합니다";
		
		}); //end click
	}); //end ready
