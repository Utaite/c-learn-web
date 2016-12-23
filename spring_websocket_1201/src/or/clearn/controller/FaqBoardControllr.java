package or.clearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import or.clearn.dao.FaqBoardDao;
import or.vo.SearchFaqBoardVO;

@Controller
public class FaqBoardControllr {
	@Autowired
	private FaqBoardDao faqBoardDao;
	
	// 자주하는 질문 게시판 목록(adminFaqBoardList)
	@RequestMapping(value="/adminFaqBoardList")
	public ModelAndView adminFaqBoardList(){
		List<SearchFaqBoardVO> list = faqBoardDao.faqboardList();
		ModelAndView mav = new ModelAndView("adminFaqBoardList");
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value="/adminFaqBoardListLoad")
	public ModelAndView adminFaqBoardListLoad(){
		List<SearchFaqBoardVO> list = faqBoardDao.faqboardList();
		ModelAndView mav = new ModelAndView("adminFaqBoardListLoad");
		mav.addObject("list", list);
		return mav;
	}
}
