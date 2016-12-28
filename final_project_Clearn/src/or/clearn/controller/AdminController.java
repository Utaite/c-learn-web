package or.clearn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import or.clearn.dao.AdminDao;
import or.vo.AdminVO;


@Controller
public class AdminController {
	@Autowired
	private AdminDao admindao; //변수선언

	@RequestMapping(value = { "/adminform" }) // /adminform 그 페이지로 이동 할 수 있게 함
	public String adminform() { //메서드 선언
		return "adminform"; // 값 돌려줌
	}

	@RequestMapping(value = "/adminmenu") //  "/adminmenu", "/" jsp이동
	public String adminmenu() { //메서드 선언
		System.out.println("TEST"); // 값이 들어 오는지 테스트	
		return "adminmenu"; //값을 돌려줌
	}

	// 회원가입이터 처리0 00
	@RequestMapping(value = "/adminadd", method = RequestMethod.POST)
	public ModelAndView addMem(AdminVO vo, HttpServletRequest request) {
		// -----------------------------------
		ModelAndView mav = new ModelAndView(); //mav 라는 이름을 부여함
		admindao.addAdmin(vo);//admindao 에 있는 addAdmin 에 vo 값을 주고
		mav.setViewName("redirect:/adminmenu"); // 벨유 값이 어드민 메뉴로 가야한다
		return mav;
	}

	// 아이디 중복 확인
	@RequestMapping(value = "/adminIdChk")
	public ModelAndView checkId(String a_id) { //메서드 생성
		int res = admindao.checkId(a_id); // admindao.checkId(a_id) 이 값들을 res에 넣어줌
		String m = ""; // 그에 대한 결과
		char chrInput = ' '; // 한글 및 특수문자 허용금지
		System.out.println("리설트 값 : " + res);
		for (int i = 0; i < a_id.length(); i++) {
			chrInput = a_id.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크
			if (((chrInput >= 0x30 && chrInput <= 0x39) || (chrInput >= 0x61 && chrInput <= 0x7A)
					|| (chrInput >= 0x41 && chrInput <= 0x5A)) && res <= 0) {
				m = "<p style='color:blue'> 사용가능한 아이디 입니다. </p>";
			} else if (res > 0) {
				m = "<p style='color:red'> 이미 존재하는 아이디 입니다. </p>"; //조건에 반대되면 저 내용을 띄움
			} else {
				m = "<p style='color:red'> 아이디는 영문과 숫자만 입력이 가능합니다. </p>"; 
			}
		}
		ModelAndView mav = new ModelAndView("ajax/idChk");//"ajax/idChk" mav에 넣어줌
		mav.addObject("res", m);//
		return mav;// 값을 돌려줌
	}

	// 닉네임중복확인
	@RequestMapping(value = "/adminNicknamechk")
	public ModelAndView checknickname(String a_nickname) {
		int res = admindao.checknickname(a_nickname);// admindao.checknickname(a_nickname) 를 res에 넣어줌 
		System.out.println(res);//res값이 나온는지 확인
		System.out.println(a_nickname);
		String m = "";
		if (res > 0) {
			m = "<p style='color:red'> 이미 존재하는 닉네임 입니다. </p>"; 
		} else {
			m = "<p style='color:blue'> 사용 가능한 닉네임 입니다. </p>"; //조건에 부합하지 않을때 이 내용이 나옴
		}
		ModelAndView mav = new ModelAndView("ajax/nicknamechk");//new ModelAndView("ajax/nicknamechk") mav에 넣어줌
		mav.addObject("res", m);// 값이 m으로 가게함
		return mav;// 값을 돌려줌
	}
}
