package or.clearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import or.clearn.dao.NoticeDao;
import or.clearn.service.Paging;
import or.vo.SearchNoticeVO;

@Controller
public class NoticeController {

	private String pagingCode;

	@Value("#{props['numPerBlock']}")
	private int numPerBlock;

	@Value("#{props['numPerPage']}")
	private int numPerPage;

	public NoticeController() {
		int nowPage = 1;
	}

	@Autowired
	private NoticeDao noticeDao;

	// 공지사항 등록 폼
	@RequestMapping(value = "adminNoticeForm")
	public String viewNotice() {
		return "adminNoticeForm";
	}

		// 공지사항 등록 처리
	@RequestMapping(value = "/adminNoticeAdd", method = RequestMethod.POST)
	public ModelAndView adminNoticeAdd(SearchNoticeVO snvo) {
		ModelAndView mav = new ModelAndView("redirect:/adminNoticeList?nowPage=1");
		noticeDao.noticeAdd(snvo);
		return mav;
	}
	// 공지사항 리스트
	@RequestMapping(value = "/adminNoticeList")
	public ModelAndView adminNoticeList(SearchNoticeVO snvo, Integer nowPage) {
		int start = 0;
		int end = 0;
		int total = noticeDao.noticeListTotal();
		// System.out.println(total);
		if (total == 0) {
			numPerPage = 1;
			numPerBlock = 1;
		} else {
			numPerPage = 10;
			numPerBlock = 5;
			start = (nowPage - 1) * numPerPage + 1;
			end = start + numPerPage - 1;
		}
		Paging page = new Paging(total, nowPage, numPerPage, numPerBlock, "adminNoticeList");
		pagingCode = page.getPagingCode();
		// System.out.println(start);
		// System.out.println(end);
		ModelAndView mav = new ModelAndView("adminNoticeList");
		List<SearchNoticeVO> list1 = noticeDao.noticeListFix();
		List<SearchNoticeVO> list2 = noticeDao.noticeList(new SearchNoticeVO(start, end));
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		mav.addObject("nowPage", nowPage);
		mav.addObject("pagingCode", pagingCode);
		return mav;
	}
	// 공지사항 검색 리스트
	@RequestMapping(value = "/adminNoticeListSearch", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView adminNoticeListSearch(SearchNoticeVO snvo, int nowPage) {
		int start = (nowPage - 1) * numPerPage + 1;
		int end = start + numPerPage - 1;
		snvo.setStart(start);
		snvo.setEnd(end);
		int total = noticeDao.noticeListSearchTotal(snvo);
		// System.out.println("--------------------------------------------------------");
		// System.out.println("total:" + total);
		// System.out.println("start2:" + snvo.getStart());
		// System.out.println("end2:" + snvo.getEnd());
		Paging page = new Paging(total, nowPage, numPerPage, numPerBlock, "adminNoticeListSearch", snvo.getSearchType(),
				snvo.getSearchValue());
		pagingCode = page.getPagingCode();
		ModelAndView mav = new ModelAndView("adminNoticeListSearch");
		//System.out.println("검색타입1:" + snvo.getSearchType());
		//System.out.println("검색value1:" + snvo.getSearchValue());
		List<SearchNoticeVO> list1 = noticeDao.noticeListFix();
		List<SearchNoticeVO> list2 = noticeDao.noticeListSearch(snvo);
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		mav.addObject("nowPage", nowPage);
		mav.addObject("pagingCode", pagingCode);
		//System.out.println("검색타입2:" + snvo.getSearchType());
		//System.out.println("검색value2:" + snvo.getSearchValue());
		return mav;
	}
	// 공지사항 상세페이지 + 조회수 증가
	@RequestMapping(value="/adminNoticeDetail")
	public ModelAndView adminNoticeDetail(int n_num){
		
		SearchNoticeVO snvo = noticeDao.noticeDetail(n_num);
		int nowPage = 1;
		if(snvo.getNowPage() > 0){
			nowPage = snvo.getNowPage();
		}
		noticeDao.noticeUpdateHit(n_num);
		ModelAndView mav = new ModelAndView("adminNoticeDetail");
		mav.addObject("snvo", snvo);
		mav.addObject("n_num", n_num);
		mav.addObject("nowPage",nowPage);
		return mav;
	}
	// 공지사항 수정 폼
	@RequestMapping(value="/adminNoticeUpform")
	public ModelAndView adminNoticeUpform(int n_num){
		SearchNoticeVO snvo = noticeDao.noticeDetail(n_num);
		ModelAndView mav = new ModelAndView("adminNoticeUpform");
		mav.addObject("snvo", snvo);
		mav.addObject("n_num", n_num);
		return mav;
	}
	// 공지사항 수정
	@RequestMapping(value="/adminNoticeUpdate",method=RequestMethod.POST)
	public ModelAndView adminNoticeUpdate(SearchNoticeVO snvo){
		noticeDao.noticeUpdate(snvo);
		int n_num = snvo.getN_num();
		ModelAndView mav = new ModelAndView("redirect:/adminNoticeDetail?n_num=" + n_num);
		return mav;
	}
	// 공지사항 삭제
	@RequestMapping(value="/adminNoticeDelete")
	public ModelAndView adminNoticeDelete(SearchNoticeVO snvo){
		int nowPage = 1;
		if(snvo.getNowPage() > 0){
			nowPage = snvo.getNowPage();
		}
		noticeDao.noticeDelete(snvo.getN_num());
		ModelAndView mav = new ModelAndView("redirect:/adminNoticeList?nowPage=" + nowPage);
		return mav;
	}
	
	
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	// 공지사항 리스트
		@RequestMapping(value = "/noticeList")
		public ModelAndView noticeList(SearchNoticeVO snvo, Integer nowPage) {
			int start = 0;
			int end = 0;
			int total = noticeDao.noticeListTotal();
			// System.out.println(total);
			if (total == 0) {
				numPerPage = 1;
				numPerBlock = 1;
			} else {
				numPerPage = 10;
				numPerBlock = 5;
				start = (nowPage - 1) * numPerPage + 1;
				end = start + numPerPage - 1;
			}
			Paging page = new Paging(total, nowPage, numPerPage, numPerBlock, "noticeList");
			pagingCode = page.getPagingCode();
			// System.out.println(start);
			// System.out.println(end);
			ModelAndView mav = new ModelAndView("noticeList");
			List<SearchNoticeVO> list1 = noticeDao.noticeListFix();
			List<SearchNoticeVO> list2 = noticeDao.noticeList(new SearchNoticeVO(start, end));
			mav.addObject("list1", list1);
			mav.addObject("list2", list2);
			mav.addObject("nowPage", nowPage);
			mav.addObject("pagingCode", pagingCode);
			return mav;
		}
		// 공지사항 검색 리스트
		@RequestMapping(value = "/noticeListSearch", method = { RequestMethod.POST, RequestMethod.GET })
		public ModelAndView noticeListSearch(SearchNoticeVO snvo, int nowPage) {
			int start = (nowPage - 1) * numPerPage + 1;
			int end = start + numPerPage - 1;
			snvo.setStart(start);
			snvo.setEnd(end);
			int total = noticeDao.noticeListSearchTotal(snvo);
			// System.out.println("--------------------------------------------------------");
			// System.out.println("total:" + total);
			// System.out.println("start2:" + snvo.getStart());
			// System.out.println("end2:" + snvo.getEnd());
			Paging page = new Paging(total, nowPage, numPerPage, numPerBlock, "noticeListSearch", snvo.getSearchType(),
					snvo.getSearchValue());
			pagingCode = page.getPagingCode();
			ModelAndView mav = new ModelAndView("noticeListSearch");
			//System.out.println("검색타입1:" + snvo.getSearchType());
			//System.out.println("검색value1:" + snvo.getSearchValue());
			List<SearchNoticeVO> list1 = noticeDao.noticeListFix();
			List<SearchNoticeVO> list2 = noticeDao.noticeListSearch(snvo);
			mav.addObject("list1", list1);
			mav.addObject("list2", list2);
			mav.addObject("nowPage", nowPage);
			mav.addObject("pagingCode", pagingCode);
			//System.out.println("검색타입2:" + snvo.getSearchType());
			//System.out.println("검색value2:" + snvo.getSearchValue());
			return mav;
		}
		// 공지사항 상세페이지 + 조회수 증가
		@RequestMapping(value="/noticeDetail")
		public ModelAndView noticeDetail(int n_num){
			
			SearchNoticeVO snvo = noticeDao.noticeDetail(n_num);
			int nowPage = 1;
			if(snvo.getNowPage() > 0){
				nowPage = snvo.getNowPage();
			}
			noticeDao.noticeUpdateHit(n_num);
			ModelAndView mav = new ModelAndView("noticeDetail");
			mav.addObject("snvo", snvo);
			mav.addObject("n_num", n_num);
			mav.addObject("nowPage",nowPage);
			return mav;
		}
}
