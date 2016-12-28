package or.clearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import or.clearn.dao.FaqBoardDao;
import or.vo.SearchFaqBoardVO;
// 자주하는 질문 리스트를 뿌려줄 클래스입니다.
@Controller
public class FaqBoardControllr {
	// 자주하는 질문 리스트 dao가져와서 자동빈 묶기를 합니다.(@AutoWired 어노테이션 사용)
	@Autowired
	private FaqBoardDao faqBoardDao;
	
	// 자주하는 질문 게시판 리스트 중  질문입니다.
	@RequestMapping(value="/adminFaqBoardList")
	public ModelAndView adminFaqBoardList(){
		List<SearchFaqBoardVO> list = faqBoardDao.faqboardList();
		ModelAndView mav = new ModelAndView("adminFaqBoardList");
		mav.addObject("list", list);
		return mav;
	}
	// 자주하는 질문 게시판 중 로드될 답변 입니다.
	@RequestMapping(value="/adminFaqBoardListLoad")
	public ModelAndView adminFaqBoardListLoad(){
		List<SearchFaqBoardVO> list = faqBoardDao.faqboardList();
		ModelAndView mav = new ModelAndView("adminFaqBoardListLoad");
		mav.addObject("list", list);
		return mav;
	}
}
