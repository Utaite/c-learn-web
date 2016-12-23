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
	private AdminDao admindao;

	@RequestMapping(value = { "/adminform" }) // 
	public String adminform() {
		return "adminform";
	}

	@RequestMapping(value = "/adminmenu") //  "/adminmenu", "/" jsp이동
	public String adminmenu() {
		System.out.println("TEST");
		return "adminmenu";
	}

	// 회원가입이터 처리0 00
	@RequestMapping(value = "/adminadd", method = RequestMethod.POST)
	public ModelAndView addMem(AdminVO vo, HttpServletRequest request) {
		// -----------------------------------
		ModelAndView mav = new ModelAndView();
		admindao.addAdmin(vo);
		mav.setViewName("redirect:/adminmenu");
		return mav;
	}

	// 아이디 중복 확인
	@RequestMapping(value = "/adminIdChk")
	public ModelAndView checkId(String a_id) {
		int res = admindao.checkId(a_id);
		String m = "";
		char chrInput = ' ';
		System.out.println("리설트 값 : " + res);
		for (int i = 0; i < a_id.length(); i++) {
			chrInput = a_id.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크
			if (((chrInput >= 0x30 && chrInput <= 0x39) || (chrInput >= 0x61 && chrInput <= 0x7A)
					|| (chrInput >= 0x41 && chrInput <= 0x5A)) && res <= 0) {
				m = "<p style='color:blue'> 사용가능한 아이디 입니다. </p>";
			} else if (res > 0) {
				m = "<p style='color:red'> 이미 존재하는 아이디 입니다. </p>";
			} else {
				m = "<p style='color:red'> 아이디는 영문과 숫자만 입력이 가능합니다. </p>";
			}
		}
		ModelAndView mav = new ModelAndView("ajax/idChk");
		mav.addObject("res", m);
		return mav;
	}

	// 닉네임중복확인
	@RequestMapping(value = "/adminNicknamechk")
	public ModelAndView checknickname(String a_nickname) {
		int res = admindao.checknickname(a_nickname);
		System.out.println(res);
		System.out.println(a_nickname);
		String m = "";
		if (res > 0) {
			m = "<p style='color:red'> 이미 존재하는 닉네임 입니다. </p>";
		} else {
			m = "<p style='color:blue'> 사용 가능한 닉네임 입니다. </p>";
		}
		ModelAndView mav = new ModelAndView("ajax/nicknamechk");
		mav.addObject("res", m);
		return mav;
	}
}
