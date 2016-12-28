package or.clearn.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import or.clearn.dao.RegisterDao;
import or.clearn.service.DoStarUpdateImple;
import or.clearn.service.DoStarUpdateInter;
import or.vo.DostarVO;
import or.vo.RegisterAddListVO;
import or.vo.RegisterClassListVO;
import or.vo.RegisterDoingVO;
import or.vo.RegisterDoneVO;

@Controller
public class RegisterController {

	@Autowired
	private RegisterDao registerDao;
	@Autowired
	private DoStarUpdateInter dostar;

	// 수강신청 리스트 (로드되는 뷰)
	@RequestMapping(value = "/registerAddListLoad")
	public ModelAndView registerAddListLoad(int cc_num) {
		ModelAndView mav = new ModelAndView("ajax/registerAddListLoad");
		List<RegisterAddListVO> list = registerDao.registerAddList(cc_num);
		mav.addObject("list", list);
		System.out.println("list ct_num : " + list.get(0).getCt_num());
		mav.addObject("cc_num", cc_num);
		return mav;
	}

	// 계정을 먼저 스마트폰과 연동하지 않으면 들어가지 못하게 만들었다.
	// 계정과 연동되면 p_token의 값이 바뀐 상태이므로 들어갈 수 있다.
	@RequestMapping(value = "registerAddListView")
	public ModelAndView registerAddListView(HttpSession session) {
		String p_id = (String) session.getAttribute("p_id");
		String p_token = registerDao.getp_token(p_id);
		session.removeAttribute("p_token");
		session.setAttribute("p_token", p_token);
		ModelAndView mav = new ModelAndView();
		if (p_id.equals(p_token)) { // 아이디와 토큰의 값이 같으면 index페이지로 들어가고
			mav.setViewName("index");
			mav.addObject("status", "먼저 계정을 스마트폰과 연동시켜주세요.");
		} else { // 아이디와 토큰의 값이 다르면 registerAddList(수강신청 페이지)로 가도록 만들었다.
			mav.setViewName("registerAddList");
		}
		return mav;
	}

	/*
	 * @RequestMapping(value = "/registerClassList") public ModelAndView
	 * registerClassList(int ct_num) { System.out.println("ct_num" + ct_num);
	 * ModelAndView mav = new ModelAndView("registerClassList");
	 * List<RegisterClassListVO> list = registerDao.registerClassList(ct_num);
	 * mav.addObject("list", list); mav.addObject("ct_num", ct_num); return mav;
	 * }
	 */

	// 수강 중인 리스트
	@RequestMapping(value = "/registerDoginList")
	public ModelAndView registerDoginList(HttpSession session) {
		int p_num = (int) session.getAttribute("p_num"); // p_num의 session값을
															// 가져온다.
		List<RegisterDoingVO> list = new ArrayList<RegisterDoingVO>(); // RegisterDoingVO를
																		// ArrayList로
																		// 만든다.
		List<Integer> ct_list = registerDao.getct_list(p_num); // 정수형 리스트에 컨텐츠를
																// 가져온다.
		for (Integer ct_num : ct_list) { // 컨텐츠를 모두 for문을 사용하여 가져온다.
			RegisterDoingVO vo = new RegisterDoingVO();
			vo.setP_num(p_num); // 부모의 번호와
			vo.setCt_num(ct_num); // 컨텐츠의 번호를
			for (RegisterDoingVO v : registerDao.registerDoginList(vo)) {// for문으로
																			// 돌리면서
																			// 가져온다.
				list.add(v); // 가져온 값을 리스트에 넣는다.
			}
		}
		for (RegisterDoingVO vo : list) { // 퍼센트를 가져오기 위해서 수강중인 리스트를 for문으로 돌린다.
			vo.setCnt_ch_num(registerDao.get_cntchnum(vo)); // 챕터의 수를 가져온다.
			vo.setCnt_cl_done(registerDao.get_cntcldone(vo)); // 수강완료된 수를 가져온다.
			float percent = ((float) vo.getCnt_cl_done() / (float) vo.getCnt_ch_num()) * 100;
			// 가져온 두 수를 이용하여 퍼센트를 구한다.
			vo.setPercent((int) percent); // 구한 퍼센트를 vo에 있는 변수에 넣는다.
		}
		ModelAndView mav = new ModelAndView("ajax/registerDoginList");
		mav.addObject("list", list);
		return mav;
	}

	// 수강중인 강의의 실제 목록
	@RequestMapping(value = "/registerClassList")
	public ModelAndView registerChapList(int ct_num, HttpSession session) throws ParseException {
		RegisterDoingVO vo = new RegisterDoingVO();
		vo.setP_num((int) session.getAttribute("p_num")); // p_num을 session값으로
															// 받는다.
		vo.setCt_num(ct_num); // 컨탠츠 수를 vo에 넣는다.
		ModelAndView mav = new ModelAndView("registerClassList");
		List<RegisterDoingVO> list = registerDao.getChaplist(vo); // 챕터리스트
		System.out.println("*******" + list.get(0).getV_num());
		SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd"); // 시간을 표시
		Date date = new Date(); // 날짜를 가져옴
		for (RegisterDoingVO v : list) { // vo에 list를 넣는다.
			if (v.getCl_date() != null) { // 만약 날짜가 null이면
				System.out.println(v.getCl_date());
				date = df.parse(v.getCl_date()); // 날짜를 setting
				v.setCl_date(df.format(date)); // vo에 날짜를 세팅
				System.out.println("after : " + v.getCl_date());
			}
		}
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping("/registerManagerList")
	public String registerManagerList() {
		return "registerManagerList";
	}

	// 수강 완료된 강의 목록입니다.
	@RequestMapping(value = "/registerDoneList") // session을 인자값으로 받습니다.
	public ModelAndView registerDoneList(HttpSession session) {
		int p_num = (int) session.getAttribute("p_num"); // p_num을 session값으로
															// 받습니다.
		List<RegisterDoneVO> list = new ArrayList<RegisterDoneVO>();
		List<Integer> ct_list = registerDao.getct_list_done(p_num);
		// 정수형 리스트에 완료된 강의 dao를 넣고 인자값으로 p_num을 받습니다.
		for (Integer ct_num : ct_list) { // for문으로 컨텐츠의 수 리스트를 받습니다.
			RegisterDoneVO vo = new RegisterDoneVO();
			vo.setP_num(p_num); // setter에 p_num을 넣습니다.
			vo.setCt_num(ct_num); // setter에 ct_num을 넣습니다.
			System.out.println("ct_num : " + ct_num);
			for (RegisterDoneVO v : registerDao.registerDoneList(vo)) { // 완료된
																		// 목록을
																		// vo에
																		// 넣고
																		// 넣은것을
				list.add(v); // list에 추가합니다.
			}
		}
		for (RegisterDoneVO vo : list) { // 리스트를 vo에 넣습니다.
			vo.setCnt_ch_num(registerDao.get_cntchnum_done(vo)); // 챕터 수를 받습니다.
			vo.setCnt_cl_done(registerDao.get_cntcldone_done(vo)); // 수강 완료한 수를
																	// 받습니다.
			float percent = ((float) vo.getCnt_cl_done() / (float) vo.getCnt_ch_num()) * 100; // 퍼센트를
																								// 구합니다.
			vo.setPercent((int) percent); // vo에 구한 퍼센트를 넣습니다.
		}
		ModelAndView mav = new ModelAndView("ajax/registerDoneList");
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/dostar")
	public ModelAndView dostar(DostarVO vo) {
		ModelAndView mav = new ModelAndView("redirect:/registerDoneList");
		try {
			dostar.starUpdate(vo); // transaction 처리한 update문을 실행시킵니다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
