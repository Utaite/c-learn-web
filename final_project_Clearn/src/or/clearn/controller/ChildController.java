package or.clearn.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import or.clearn.dao.ChildDao;
import or.clearn.service.Paging;
import or.vo.ChildVO;
import or.vo.SearchChildVO;

@Controller
public class ChildController {
	@Autowired
	private ChildDao childdao; // 변수선언을 해준다
	
	private String pagingCode;
	

	public ChildController() {
		int nowPage = 1; //변수선언
	}
	
	@Value("#{props['numPerBlock']}")
	private int numPerBlock;

	@Value("#{props['numPerPage']}")
	private int numPerPage;


	@Autowired
	private ChildDao childDao;
	
	@RequestMapping(value="/adminChildList")
	public ModelAndView adminChildList(SearchChildVO scvo, Integer nowPage){
		int start = 0;
		int end = 0;
		int total = childDao.childlisttotal();
		if(total == 0){
			numPerPage = 1;
			numPerBlock = 1;
		} else {
			numPerPage = 10;
			numPerBlock = 5;
			start = (nowPage - 1) * numPerPage + 1;
			end = start + numPerPage - 1;
		}
		Paging page = new Paging(total, nowPage, numPerPage, numPerBlock, "adminChildList");
		pagingCode = page.getPagingCode();
		ModelAndView mav = new ModelAndView("adminChildList");
		List<SearchChildVO> list = childDao.childlist(new SearchChildVO(start, end));
		mav.addObject("list", list);
		mav.addObject("nowPage",nowPage);
		mav.addObject("pagingCode",pagingCode);
		return mav;
	}
	
	
	@RequestMapping(value = "/adminChildListSearch", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView adminChildListSearch(SearchChildVO scvo, int nowPage){
		int start = (nowPage - 1) * numPerPage + 1;
		int end = start + numPerPage - 1;
		scvo.setStart(start);
		scvo.setEnd(end);
		int total = childDao.childlisttotalsearch(scvo);
		Paging page = new Paging(total, nowPage, numPerPage, numPerBlock, "adminChildListSearch", scvo.getSearchType(),
				scvo.getSearchValue());
		pagingCode = page.getPagingCode();
		ModelAndView mav = new ModelAndView("adminChildListSearch");
		List<SearchChildVO> list = childDao.childlistsearch(scvo);
		mav.addObject("list",list);
		mav.addObject("nowPage", nowPage);
		mav.addObject("pagingCode", pagingCode);
		return mav;
	}
	@RequestMapping(value="/adminChildDetail")
	public ModelAndView adminChildDetail(int c_num){
		SearchChildVO scvo = childDao.childdetailadmin(c_num);
		int nowPage = 1;
		if(scvo.getNowPage() > 0){
			nowPage = scvo.getNowPage();
		}
		ModelAndView mav = new ModelAndView("adminChildDetail");
		mav.addObject("scvo", scvo);
		mav.addObject("c_num", c_num);
		mav.addObject("nowPage", nowPage);
		return mav;
	}
	@RequestMapping(value="/adminChildDelete")
	public ModelAndView adminChildDelete(SearchChildVO scvo){
		childDao.childdeleteadmin(scvo.getC_num());
		int nowPage = 1;
		if(scvo.getNowPage() > 0){
			nowPage = scvo.getNowPage();
		}
		ModelAndView mav = new ModelAndView("redirect:/adminChildList?nowPage=" + nowPage);
		mav.addObject("c_num",scvo.getC_num());
		mav.addObject("nowPage", nowPage);
		return mav;
	}
	@RequestMapping(value = {"/children"})
	public String children() {
		return "children";
	}

	@RequestMapping(value = "/ciform")
	public String ciform() {
		System.out.println("TEST");
		return "ciform";
	}
	
	@RequestMapping(value="/childrenAdd", method=RequestMethod.POST)
	public ModelAndView childAdd(ChildVO cvo,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		// 이미지가 저장될 절대 경로 저장
		HttpSession session = request.getSession();
		// PageContext에 해당. // 실제 resources/img란 경로를 얻기 위함
		String r_path = session.getServletContext().getRealPath("/");
		System.out.println("Root_RealPath : " + r_path);
		String img_path = "\\resources\\upload\\";
		StringBuffer sb = new StringBuffer();
		sb.append(r_path).append(img_path);
		// ----------------------------------------
		// upload된 파일이름은 path에 설정
		String oriFn = cvo.getC_pic().getOriginalFilename();
		// 완성된 경로에 이미지 파일이름 추가
		sb.append(oriFn);
		// 경로와 파일의 완성----------------------------------------
		System.out.println("오리지널 파일 : " + oriFn);
		// 파일 업로드 시킬 경로를 추상화해서 File객체로 생성
		File f = new File(sb.toString());
		// 추상화한 File객체를 String에 초간단 파일 업로드 시킴
		try {
			cvo.getC_pic().transferTo(f); // 파일 업로드 끝
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		cvo.setC_img(oriFn);
		childdao.addChild(cvo);
		mav.setViewName("redirect:/parentdetail");
		return mav;
	}
}
