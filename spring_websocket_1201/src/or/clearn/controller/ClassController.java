package or.clearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import or.clearn.dao.ChapterDao;
import or.clearn.dao.ContentDao;
import or.clearn.dao.MyClassDao;
import or.clearn.service.MyclassVideoInsertInter;
import or.vo.ChapterVO;
import or.vo.ContentVO;
import or.vo.MyClassVO;
import or.vo.ParentVO;
import or.vo.RestVO;

@Controller
public class ClassController {

	@Autowired
	private ContentDao contentDao;
	@Autowired
	private ChapterDao chapterDao;
	@Autowired
	private MyClassDao myclassDao;

	@Autowired
	private MyclassVideoInsertInter service;

	@RequestMapping(value = "/classdetail")
	public ModelAndView popup(int ct_num) {
		ModelAndView mav = new ModelAndView("classdetail");
		ContentVO vo = contentDao.getdetail(ct_num);
		List<ChapterVO> list = chapterDao.getlist(ct_num);
		mav.addObject("vo", vo);
		mav.addObject("list", list);
		mav.addObject("chapternum", chapterDao.chapnum(ct_num));
		return mav;
	}

	@RequestMapping(value = "/insertClass", method = RequestMethod.POST)
	public ModelAndView insertClass(@RequestParam(value = "ct_num_ary[]") List<Integer> ct_num_ary,
			@RequestParam(value = "p_num") int p_num, @RequestParam(value = "p_token") String p_token) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/index");
		for (int ct_num : ct_num_ary) {
			int chap_cnt = chapterDao.chapnum(ct_num);
			List<Integer> chap_list = chapterDao.chaplist(ct_num);
			for (int i = 0; i < chap_cnt; i++) {
				MyClassVO mvo = new MyClassVO();
				mvo.setP_num(p_num);
				mvo.setCt_num(ct_num);
				mvo.setCt_period(contentDao.getperiod(ct_num));
				mvo.setCh_num(chap_list.get(i));
				RestVO rvo = new RestVO();
				rvo.setCh_num(chap_list.get(i));
				rvo.setP_token(p_token);
				service.insertMyclassVideo(mvo, rvo);
			}
		}
		return mav;
	}
}
