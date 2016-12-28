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

// 이 클래스는 @Controller 어느테이션을 사용하여 현재 클래스가 사용되는 모델임을 보여줍니다.
// 이 클래스는 오직 공지사항만을 위한 모델입니다.
@Controller
public class NoticeController {

	// String형 참조자료형으로 선언된 pagingCode는 페이징처리를 하기 위하여 선언된 변수입니다.
	private String pagingCode;

	// 이 변수는 @Value 어노테이션을 사용하여 properties에 작성된 numPerBlock를 사용하기 위한 변수 입니다.
	// 이 변수를 사용하면 페이지의 블록 수를 설정할 수 있습니다.
	// 예 ) [1] [2] [3] [4] [5]
	@Value("#{props['numPerBlock']}")
	private int numPerBlock;

	// 이 변수는 @Value 어노테이션을 사용하여 properties에 작성된 numPerPage를 사용하기 위한 변수 입니다.
	// 이 변수를 사용하면 페이지 안에 있는 게시글의 수를 설정할 수 있습니다.
	@Value("#{props['numPerPage']}")
	private int numPerPage;

	// 공지사항의 현재 페이지를 1로 설정해 주었습니다.
	public NoticeController() {
		int nowPage = 1;
	}

	// 어노테이션(@Autowired)을 사용하여 데이터베이스를 사용하기 위한 dao를 선언했습니다.
	@Autowired
	private NoticeDao noticeDao;

	// 공지사항을 등록하기 위한 폼을 만들었습니다.
	@RequestMapping(value = "adminNoticeForm")
	public String viewNotice() {
		return "adminNoticeForm";
	}

	// 공지사항 게시물을 등록하는 작업입니다.
	@RequestMapping(value = "/adminNoticeAdd", method = RequestMethod.POST)
	public ModelAndView adminNoticeAdd(SearchNoticeVO snvo) {
		ModelAndView mav = new ModelAndView("redirect:/adminNoticeList?nowPage=1");
		noticeDao.noticeAdd(snvo);
		return mav;
	}

	// 작성이 완료된 공지사항의 목록을 보여주는 method입니다.
	@RequestMapping(value = "/adminNoticeList")
	public ModelAndView adminNoticeList(SearchNoticeVO snvo, Integer nowPage) {
		// SearchNoticeVO를 사용하여 SearchNoticeVO 안에 있는 start값과 end값을 설정하기 위한
		// 변수입니다.
		// Integer형 참조자료형인 nowPage를 선언해줍니다.

		// 페이징 처리의 시작 번호입니다.
		int start = 0;
		// 페이징 처리의 마지막 번호입니다.
		int end = 0;
		// int형 일반자료형을 total 이라는 값으로 선언한 후 noticeDao에서 게시글의 총 수를 가져옵니다.
		int total = noticeDao.noticeListTotal();
		// 만약 게시글의 총 수가 0 이라면
		if (total == 0) {
			// numPerPage를 1로 설정해주고, 
			numPerPage = 1;
			// numPerBlock을 1로 설정해 줍니다.
			numPerBlock = 1;
			
			// 게시글의 총 수가 0이 아니라면
			
			// total의 값이 
		} else { 
			numPerPage = 10; // numPerPage의 수를 10으로
			numPerBlock = 5; // numPerBlock의 수를 5로 세팅해주고,
			start = (nowPage - 1) * numPerPage + 1; // 시작 번호를 (현재 페이지 - 1) * 위에서
													// 가져온 페이지 수 (10) + 1로 해서
			// 현재 페이지가 만약 1이라면 (1 - 1 = 0) * (10 + 1)을 해서 11이 되니까 10까지 잘라서 현재
			// 페이지가 1이라면 (1 ~ 10) 까지
			// 현재 페이지가 2라면 (11 ~ 20)까지 잘라냅니다.
			end = start + numPerPage - 1;
		}
		// Paging 클래스의 값을 가져옵니다. (필요한 값은 ㄱ시글의 총 수, 현재페이지, numPerPage값과 numPerBlock, 이동할 주소)
		Paging page = new Paging(total, nowPage, numPerPage, numPerBlock, "adminNoticeList");
		// pagingCode 변수에 Paging클래스에 PagingCode의 getter를 설정해줍니다.
		pagingCode = page.getPagingCode();
		
		// ModelAndView를 선언하고, 그 안에 ViewName을 작성한다.
		ModelAndView mav = new ModelAndView("adminNoticeList");
		// list를 선언하고 그 안에 고정된 목록을 넣는다.
		List<SearchNoticeVO> list1 = noticeDao.noticeListFix();
		// list를 선언하고 그 안에 고정되지 않고 페아징 처리를 할 목록을 넣는다. (start값과 end값을 넣기)
		List<SearchNoticeVO> list2 = noticeDao.noticeList(new SearchNoticeVO(start, end));
		//뷰에 보여줄 list들과 페이징 처리를 할 pagingCode, nowPage를 전달한다.
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		mav.addObject("nowPage", nowPage);
		mav.addObject("pagingCode", pagingCode);
		// ModelAndView로 리턴한다.
		return mav;
	}

	// 작성이 완료된 공지사항의 목록을 검색해서 보여줄 method입니다.
	@RequestMapping(value = "/adminNoticeListSearch", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView adminNoticeListSearch(SearchNoticeVO snvo, int nowPage) {
		int start = (nowPage - 1) * numPerPage + 1;
		int end = start + numPerPage - 1;
		snvo.setStart(start);
		snvo.setEnd(end);
		int total = noticeDao.noticeListSearchTotal(snvo);
		// 이 메서드에서는 검색 타입과 검색값을 같이 전달한다.
		Paging page = new Paging(total, nowPage, numPerPage, numPerBlock, "adminNoticeListSearch", snvo.getSearchType(),
				snvo.getSearchValue());
		pagingCode = page.getPagingCode();
		ModelAndView mav = new ModelAndView("adminNoticeListSearch");
		List<SearchNoticeVO> list1 = noticeDao.noticeListFix();
		List<SearchNoticeVO> list2 = noticeDao.noticeListSearch(snvo);
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		mav.addObject("nowPage", nowPage);
		mav.addObject("pagingCode", pagingCode);
		return mav;
	}

	// 공지사항의 상세피이지를 보여주고 조회수를 증가시킬 method입니다.
	@RequestMapping(value = "/adminNoticeDetail")
	public ModelAndView adminNoticeDetail(int n_num) {

		SearchNoticeVO snvo = noticeDao.noticeDetail(n_num);
		int nowPage = 1;
		if (snvo.getNowPage() > 0) {
			nowPage = snvo.getNowPage();
		}
		noticeDao.noticeUpdateHit(n_num);
		ModelAndView mav = new ModelAndView("adminNoticeDetail");
		mav.addObject("snvo", snvo);
		mav.addObject("n_num", n_num);
		mav.addObject("nowPage", nowPage);
		return mav;
	}

	// 공지사항을 수정할 폼입니다.
	@RequestMapping(value = "/adminNoticeUpform")
	public ModelAndView adminNoticeUpform(int n_num) {
		SearchNoticeVO snvo = noticeDao.noticeDetail(n_num);
		ModelAndView mav = new ModelAndView("adminNoticeUpform");
		mav.addObject("snvo", snvo);
		mav.addObject("n_num", n_num);
		return mav;
	}

	// 공지사항 수정을 처리할 method입니다.
	@RequestMapping(value = "/adminNoticeUpdate", method = RequestMethod.POST)
	public ModelAndView adminNoticeUpdate(SearchNoticeVO snvo) {
		noticeDao.noticeUpdate(snvo);
		int n_num = snvo.getN_num();
		ModelAndView mav = new ModelAndView("redirect:/adminNoticeDetail?n_num=" + n_num);
		return mav;
	}

	// 공지사항을 삭제할 method입니다.
	@RequestMapping(value = "/adminNoticeDelete")
	public ModelAndView adminNoticeDelete(SearchNoticeVO snvo) {
		int nowPage = 1;
		if (snvo.getNowPage() > 0) {
			nowPage = snvo.getNowPage();
		}
		noticeDao.noticeDelete(snvo.getN_num());
		ModelAndView mav = new ModelAndView("redirect:/adminNoticeList?nowPage=" + nowPage);
		return mav;
	}

	// 지금까지는 관리자 페이지에서 필요한 method들이었습니다.
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------
	// 지금부터는 사용자 페이지에서 필요한 method들입니다.
	// method들의 내용은 위와 같지만 리스트 페이지와 검색한 리스트 페이지, 상세페이지입니다.
	
	
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
		// System.out.println("검색타입1:" + snvo.getSearchType());
		// System.out.println("검색value1:" + snvo.getSearchValue());
		List<SearchNoticeVO> list1 = noticeDao.noticeListFix();
		List<SearchNoticeVO> list2 = noticeDao.noticeListSearch(snvo);
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		mav.addObject("nowPage", nowPage);
		mav.addObject("pagingCode", pagingCode);
		// System.out.println("검색타입2:" + snvo.getSearchType());
		// System.out.println("검색value2:" + snvo.getSearchValue());
		return mav;
	}

	// 공지사항 상세페이지 + 조회수 증가
	@RequestMapping(value = "/noticeDetail")
	public ModelAndView noticeDetail(int n_num) {

		SearchNoticeVO snvo = noticeDao.noticeDetail(n_num);
		int nowPage = 1;
		if (snvo.getNowPage() > 0) {
			nowPage = snvo.getNowPage();
		}
		noticeDao.noticeUpdateHit(n_num);
		ModelAndView mav = new ModelAndView("noticeDetail");
		mav.addObject("snvo", snvo);
		mav.addObject("n_num", n_num);
		mav.addObject("nowPage", nowPage);
		return mav;
	}
}
