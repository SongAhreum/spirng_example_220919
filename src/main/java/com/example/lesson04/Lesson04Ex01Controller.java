package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.model.User;

@RequestMapping("/lesson04/ex01")
@Controller
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO; //BO는 여러개 부를수 있음, 어노테이션과 필드가 한세트 로나열하면 가능 
	
	// 회원가입화면  서버에처리하는 restcontroller인지 veiw페이지인지 구별하기위해 _veiw는 jsp로간다고 생각 
	//http://localhost/lesson04/ex01/add_user_view  
	//옛날 방법 @RequestMapping(path="/add_user_view", method=RequiestMethod.POST)
	@RequestMapping("/add_user_view")
	//jsp는 application.properties에 저장된 경로는 생략해야함
	public String addUserView() {
		//  /WEB-INF/jsp/ (lesson04/addUser) .jsp
		return"lesson04/addUser";
	}
	
	@PostMapping("/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value="email", required=false) String email,
			@RequestParam(value="introduce", required=false) String introduce
			) {//파라미터정의
		
		
		//DB insert : bo dao만들어서 insert할거임, 에러생길수 있으니 응답,request부터 검증
		userBO.addUser(name, yyyymmdd, email, introduce);
		//veiw페이지 이동
		return "lesson04/afterAddUser"; // 결과 jsp 여기에 breaking포인트 걸고 디버깅, adduserview로들어감	
	}
	//http://localhost/lesson04/ex01/get_last_user_view
	@GetMapping("/get_last_user_view")
	public String getLastUserView(Model model) {
		//db select
		//가장마지막에 추가된 사람 한명 가져오기
		User user = userBO.getLastUser();
		
		//model에 데이터를 담아놓으면 jsp에서 꺼내 쓸 수 있다.
		model.addAttribute("seller", user);
		model.addAttribute("title","회원정보");
		return"lesson04/getLastUser";	
	}
}
