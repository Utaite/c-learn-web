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

	@RequestMapping(value = "/registerAddListLoad")
	public ModelAndView registerAddListLoad(int cc_num) {
		ModelAndView mav = new ModelAndView("ajax/registerAddListLoad");
		List<RegisterAddListVO> list = registerDao.registerAddList(cc_num);
		mav.addObject("list", list);
		System.out.println("list ct_num : " + list.get(0).getCt_num());
		mav.addObject("cc_num", cc_num);
		return mav;
	}

	@RequestMapping(value = "registerAddListView")
	public ModelAndView registerAddListView(String p_id, String p_token) {
		ModelAndView mav = new ModelAndView();
		if (p_id.equals(p_token)) {
			mav.setViewName("index");
			mav.addObject("status", "먼저 계정을 스마트폰과 연동시켜주세요.");
		} else {
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

	@RequestMapping(value = "/registerDoginList")
	public ModelAndView registerDoginList(HttpSession session) {
		int p_num = (int) session.getAttribute("p_num");
		List<RegisterDoingVO> list = new ArrayList<RegisterDoingVO>();
		List<Integer> ct_list = registerDao.getct_list(p_num);
		for (Integer ct_num : ct_list) {
			RegisterDoingVO vo = new RegisterDoingVO();
			vo.setP_num(p_num);
			vo.setCt_num(ct_num);
			for (RegisterDoingVO v : registerDao.registerDoginList(vo)) {
				list.add(v);
			}
		}
		for (RegisterDoingVO vo : list) {
			vo.setCnt_ch_num(registerDao.get_cntchnum(vo));
			vo.setCnt_cl_done(registerDao.get_cntcldone(vo));
			float percent = ((float) vo.getCnt_cl_done() / (float) vo.getCnt_ch_num()) * 100;
			vo.setPercent((int) percent);
		}
		ModelAndView mav = new ModelAndView("ajax/registerDoginList");
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/registerClassList")
	public ModelAndView registerChapList(int ct_num, HttpSession session) throws ParseException {
		RegisterDoingVO vo = new RegisterDoingVO();
		vo.setP_num((int) session.getAttribute("p_num"));
		vo.setCt_num(ct_num);
		ModelAndView mav = new ModelAndView("registerClassList");
		List<RegisterDoingVO> list = registerDao.getChaplist(vo);
		SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");
		Date date = new Date();
		for (RegisterDoingVO v : list) {
			if (v.getCl_date() != null) {
				System.out.println(v.getCl_date());
				date = df.parse(v.getCl_date());
				v.setCl_date(df.format(date));
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

	@RequestMapping(value = "/registerDoneList")
	public ModelAndView registerDoneList(HttpSession session) {
		int p_num = (int) session.getAttribute("p_num");
		List<RegisterDoneVO> list = new ArrayList<RegisterDoneVO>();
		List<Integer> ct_list = registerDao.getct_list_done(p_num);
		for (Integer ct_num : ct_list) {
			RegisterDoneVO vo = new RegisterDoneVO();
			vo.setP_num(p_num);
			vo.setCt_num(ct_num);
			System.out.println("ct_num : " + ct_num);
			for (RegisterDoneVO v : registerDao.registerDoneList(vo)) {
				list.add(v);
			}
		}
		for (RegisterDoneVO vo : list) {
			vo.setCnt_ch_num(registerDao.get_cntchnum_done(vo));
			vo.setCnt_cl_done(registerDao.get_cntcldone_done(vo));
			float percent = ((float) vo.getCnt_cl_done() / (float) vo.getCnt_ch_num()) * 100;
			vo.setPercent((int) percent);
		}
		ModelAndView mav = new ModelAndView("ajax/registerDoneList");
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = "/dostar")
	public ModelAndView dostar(DostarVO vo) {
		ModelAndView mav = new ModelAndView("redirect:/registerDoneList");
		try {
			dostar.starUpdate(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
