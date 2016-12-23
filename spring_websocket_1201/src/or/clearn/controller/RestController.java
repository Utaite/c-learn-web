package or.clearn.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import or.clearn.dao.RestDao;
import or.vo.ConnectVO;
import or.vo.QuizVO;
import or.vo.RestVO;

@Controller
public class RestController {

	@Autowired
	private View JsonView;

	@Autowired
	private RestDao dao;

	@RequestMapping(value = "/api/token", method = RequestMethod.POST)
	public View token(RestVO restvo, HttpSession session) {
		dao.apiToken(restvo);
		System.out.println();
		System.out.println("token success");
		System.out.println("p_id: " + restvo.getP_id() + " / p_pw: " + restvo.getP_pw());
		System.out.println("p_token: " + restvo.getP_token() + " / before_token: " + restvo.getBefore_token());
		session.removeAttribute("p_token");
		session.setAttribute("p_token", restvo.getP_token());
		return JsonView;
	}

	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public View login(RestVO restvo, ModelMap map) {
		System.out.println(restvo.getP_id() + "/" + restvo.getP_pw());
		RestVO vo = dao.apiLogin(restvo);
		if (vo == null) {
			map.addAttribute("v_num", -1);
			System.out.println("login failed");
		} else {
			map.addAttribute("v_num", vo.getV_num());
			map.addAttribute("p_token", vo.getP_token());
			System.out.println();
			System.out.println("login success");
			System.out.println("p_id: " + restvo.getP_id() + " / p_pw: " + restvo.getP_pw());
			System.out.println("v_num: " + vo.getV_num() + " / p_token: " + vo.getP_token());
		}
		return JsonView;
	}

	@RequestMapping(value = "/api/video", method = RequestMethod.POST)
	public View video(RestVO restvo, ModelMap map) {
		RestVO vo = dao.apiVideo(restvo);
		map.addAttribute("ch_file", vo.getCh_file());
		map.addAttribute("v_ctime", vo.getV_ctime());
		System.out.println();
		System.out.println("video success");
		System.out.println("ch_file: " + vo.getCh_file() + " / v_ctime: " + vo.getV_ctime());
		return JsonView;
	}

	@RequestMapping(value = "/api/finish", method = RequestMethod.POST)
	public View finish(int v_num) {
		dao.apiFinish(v_num);
		System.out.println();
		System.out.println("finish success");
		System.out.println("v_num: " + v_num);
		return JsonView;
	}

	@RequestMapping(value = "/api/save", method = RequestMethod.POST)
	public View save(RestVO restvo) {
		dao.apiSave(restvo);
		System.out.println();
		System.out.println("save success");
		System.out.println("v_num: " + restvo.getV_num() + " / v_ctime: " + restvo.getV_ctime());
		return JsonView;
	}

	@RequestMapping(value = "/api/connectresult", method = RequestMethod.POST)
	public View connectResult(RestVO restvo) {
		dao.apiConnectResult(restvo);
		System.out.println();
		System.out.println("connectResult success");
		System.out.println("connectResult: " + restvo.getP_cresult());
		return JsonView;
	}

	@RequestMapping(value = "/api/quizresult", method = RequestMethod.POST)
	public View quizResult(RestVO restvo) {
		dao.apiQuizResult(restvo);
		System.out.println();
		System.out.println("quizResult success");
		System.out.println("quizResult: " + restvo.getP_qresult());
		return JsonView;
	}

	@RequestMapping(value = "/watchAndroid", method = RequestMethod.POST)
	public ModelAndView watchAndroid(RestVO restvo, String msg) {
		ModelAndView mav = new ModelAndView();
		System.out.println("******" + restvo.getV_num());
		dao.apiUpdate(restvo);
		mav.setViewName("watchAndroid");
		mav.addObject("msg", msg);
		mav.addObject("p_token", restvo.getP_token());
		System.out.println("mav: " + restvo.getP_token());
		return mav;
	}

	@RequestMapping(value = "/api/watchCresult")
	public ModelAndView watchCresult(int p_num) {
		ModelAndView mav = new ModelAndView();
		List<ConnectVO> list = new ArrayList<>();
		ConnectVO connectVO = null;
		String result = dao.apiWatchCresult(p_num);
		if (result != null) {
			StringTokenizer st = new StringTokenizer(result, "}");
			while (st.hasMoreTokens()) {
				String value1 = st.nextToken();
				String value2 = value1.substring(value1.indexOf(":") + 1);
				if (value1.contains("number")) {
					connectVO = new ConnectVO();
					connectVO.setNumber(Integer.parseInt(value2));
				} else if (value1.contains("v_num")) {
					connectVO.setV_num(Integer.parseInt(value2));
				} else if (value1.contains("start_time")) {
					connectVO.setStart_time(value2);
				} else if (value1.contains("end_time")) {
					connectVO.setEnd_time(value2);
					list.add(connectVO);
				}
			}
			Collections.reverse(list);
			System.out.println("nn" + list);
			mav.addObject("list", list);
		} else {
			System.out.println("n");
			mav.addObject("list", null);
		}
		mav.setViewName("ajax/watchCresult");
		return mav;
	}

	@RequestMapping(value = "/api/watchQresult")
	public ModelAndView watchQresult(int p_num) {
		ModelAndView mav = new ModelAndView();
		List<QuizVO> list = new ArrayList<>();
		QuizVO quizVO = null;
		String result = dao.apiWatchQresult(p_num);
		if (result != null) {
			StringTokenizer st = new StringTokenizer(result, "}");
			while (st.hasMoreTokens()) {
				String value1 = st.nextToken();
				String value2 = value1.substring(value1.indexOf(":") + 1);
				if (value1.contains("number")) {
					quizVO = new QuizVO();
					quizVO.setNumber(Integer.parseInt(value2));
				} else if (value1.contains("v_num")) {
					quizVO.setV_num(Integer.parseInt(value2));
				} else if (value1.contains("userAnswerList")) {
					quizVO.setUserAnswerList(value2);
				} else if (value1.contains("quizAnswerList")) {
					quizVO.setQuizAnswerList(value2);
				} else if (value1.contains("resultList")) {
					quizVO.setResultList(value2);
					list.add(quizVO);
				}
			}
			Collections.reverse(list);
			mav.addObject("list", list);
		} else {
			mav.addObject("list", null);
		}
		mav.setViewName("ajax/watchQresult");
		return mav;
	}

}