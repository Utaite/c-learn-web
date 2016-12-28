package or.clearn.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import or.clearn.dao.ParentDao;
import or.clearn.service.Paging;
import or.vo.ParentVO;
import or.vo.SearchParentVO;

@Controller
public class ParentController {
	@Autowired
	private ParentDao parentDao;
	private String pagingCode;
	@RequestMapping(value =  "/member")
	public String member() {
		return "member";
	}
	
	@Value("#{props['numPerBlock']}")
	private int numPerBlock;

	@Value("#{props['numPerPage']}")
	private int numPerPage;

	public ParentController() {
		int nowPage = 1;
	}

	@Autowired
	private ParentDao parentdao;
	
	@RequestMapping(value="/adminParentList")
	public ModelAndView adminParentList(SearchParentVO spvo, Integer nowPage){
		int start = 0;
		int end = 0;
		int total = parentdao.parentlisttotal();
		if(total == 0){
			numPerPage = 1;
			numPerBlock = 1;
		} else {
			numPerPage = 10;
			numPerBlock = 5;
			start = (nowPage - 1) * numPerPage + 1;
			end = start + numPerPage - 1;
		}
		Paging page = new Paging(total, nowPage, numPerPage, numPerBlock, "adminParentList");
		pagingCode = page.getPagingCode();
		ModelAndView mav = new ModelAndView("adminParentList");
		List<SearchParentVO> list = parentdao.parentlist(new SearchParentVO(start, end));
		mav.addObject("list", list);
		mav.addObject("nowPage",nowPage);
		mav.addObject("pagingCode",pagingCode);
		return mav;
	}
	@RequestMapping(value = "/adminParentListSearch", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView adminParentListSearch(SearchParentVO spvo, int nowPage){
		int start = (nowPage - 1) * numPerPage + 1;
		int end = start + numPerPage - 1;
		spvo.setStart(start);
		spvo.setEnd(end);
		int total = parentdao.parentlisttotalsearch(spvo);
		Paging page = new Paging(total, nowPage, numPerPage, numPerBlock, "adminParentListSearch", spvo.getSearchType(),
				spvo.getSearchValue());
		pagingCode = page.getPagingCode();
		ModelAndView mav = new ModelAndView("adminParentListSearch");
		List<SearchParentVO> list = parentdao.parentlistsearch(spvo);
		mav.addObject("list",list);
		mav.addObject("nowPage", nowPage);
		mav.addObject("pagingCode", pagingCode);
		return mav;
	}
	@RequestMapping(value="/adminParentDetail")
	public ModelAndView adminParentDetail(int p_num){
		SearchParentVO spvo = parentdao.parentdetailadmin(p_num);
		int nowPage = 1;
		if(spvo.getNowPage() > 0){
			nowPage = spvo.getNowPage();
		}
		ModelAndView mav = new ModelAndView("adminParentDetail");
		mav.addObject("spvo", spvo);
		mav.addObject("p_num", p_num);
		mav.addObject("nowPage", nowPage);
		return mav;
	}
	
	// 회원가입이터 처리0 00
	@RequestMapping(value = "/memberadd", method = RequestMethod.POST)
	public ModelAndView addMem(ParentVO vo, String p_phone1, String p_phone2, String p_phone3, MultipartFile img_file,
			HttpServletRequest request) {
		// -----------------------------------
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
		String oriFn = img_file.getOriginalFilename();
		// 완성된 경로에 이미지 파일이름 추가
		sb.append(oriFn);
		// 경로와 파일의 완성----------------------------------------
		System.out.println("오리지널 파일 : " + oriFn);
		// 파일 업로드 시킬 경로를 추상화해서 File객체로 생성
		File f = new File(sb.toString());
		// 추상화한 File객체를 String에 초간단 파일 업로드 시킴
		try {
			img_file.transferTo(f); // 파일 업로드 끝
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		vo.setP_pic(oriFn);
		vo.setP_phone(p_phone1 + p_phone2 + p_phone3);
		vo.setP_token(UUID.randomUUID().toString().replace("-", ""));
		parentDao.addParent(vo);
		mav.setViewName("redirect:/index");
		return mav;
		// ------------------------------------
		// vo.setP_phone(p_phone1 + p_phone2+ p_phone3);
		// vo.setP_token(UUID.randomUUID().toString().replace("-", ""));
		// parentDao.addParent(vo);
		// return new ModelAndView("redirect:/member");
	}

	// 아이디 중복 확인
	@RequestMapping(value = "/parentIdChk")
	public ModelAndView checkId(String p_id) {
		int res = parentDao.checkId(p_id);
		String m = "";
		char chrInput = ' ';
		System.out.println("리설트 값 : " + res);
		for (int i = 0; i < p_id.length(); i++) {
			chrInput = p_id.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크
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
	@RequestMapping(value = "/parentNicknamechk")
	public ModelAndView checknickname(String p_nickname) throws UnsupportedEncodingException {
		p_nickname = URLDecoder.decode(p_nickname, "utf-8");
		int res = parentDao.checknickname(p_nickname);
		System.out.println("res : "+res);
		System.out.println("인코딩이 안됐니?"+p_nickname);
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

	@RequestMapping(value = "/parentupform")
	public ModelAndView parentupform(int p_num) throws UnsupportedEncodingException {
		ParentVO pvo = parentDao.parentdetail(p_num);
		pvo.setP_pic(URLDecoder.decode(pvo.getP_pic(), "utf-8"));
		ModelAndView mav = new ModelAndView("parentupform");
		String phone2 = pvo.getP_phone().substring(3, 7);
		String phone3 = pvo.getP_phone().substring(7, 11);
		System.out.println(phone2);
		System.out.println(phone3);
		mav.addObject("pvo", pvo);
		mav.addObject("phone2",phone2);
		mav.addObject("phone3",phone3);
		mav.addObject("p_num", p_num);
		return mav;
	}

	@RequestMapping(value = "/parentdetail")
	public ModelAndView pardetail(HttpSession session) throws UnsupportedEncodingException {
		ParentVO res = parentDao.parentdetail((int) session.getAttribute("p_num"));
		res.setP_pic(URLDecoder.decode(res.getP_pic(), "utf-8"));
		System.out.println(res.getP_pic().toString());
		ModelAndView mav = new ModelAndView("parentdetail");
		mav.addObject("parentVO", res);
		return mav;
	}

	@RequestMapping(value = "/parentupdate", method = RequestMethod.POST)
	public ModelAndView parentupdate(ParentVO vo, String p_phone1, String p_phone2, String p_phone3,
			MultipartFile img_file, HttpServletRequest request) {
		System.out.println("테스트");
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
		String oriFn = img_file.getOriginalFilename();
		// 완성된 경로에 이미지 파일이름 추가
		sb.append(oriFn);
		// 경로와 파일의 완성----------------------------------------
		System.out.println("오리지널 파일 : " + oriFn);
		// 파일 업로드 시킬 경로를 추상화해서 File객체로 생성
		File f = new File(sb.toString());
		String delete_file = parentDao.getdeletefile(vo.getP_num());
		File delete_f = new File(r_path+img_path + delete_file);
		System.out.println("로그로그 파일 이름"+delete_f);
		System.out.println("로그로그" + delete_f.exists());
		if (delete_f.exists()) {
			delete_f.delete();
		}
		// 추상화한 File객체를 String에 초간단 파일 업로드 시킴
		try {
			img_file.transferTo(f); // 파일 업로드 끝
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		vo.setP_pic(oriFn);
		vo.setP_phone(p_phone1 + p_phone2 + p_phone3);
		// vo.setP_token(UUID.randomUUID().toString().replace("-", ""));
		parentDao.parentupdate(vo);
		int p_num = vo.getP_num();
		mav.setViewName("redirect:/parentdetail?p_num=" + p_num);
		return mav;
		// parentDao.parentupdate(vo);
		// int p_num = vo.getP_num();
		// System.out.println("업데이트 성공"+vo.getP_num());
		// ModelAndView mav = new ModelAndView();
		// System.out.println("한에지 노답 : " + p_num);
		// mav.setViewName("redirect:/parentdetail?p_num="+p_num);
		// return mav;
	}

	// 정보변경 닉네임중복확인
	@RequestMapping(value = "/parentupnickname")
	public ModelAndView parnickname(String p_nickname) {
		int res = parentDao.checknickname(p_nickname);
		System.out.println(res);
		System.out.println(p_nickname);
		String m = "";
		if (res > 0) {
			m = "<p style='color:red'> 이미 존재하는 닉네임 입니다. </p>";
		} else {
			m = "<p style='color:blue'> 사용 가능한 닉네임 입니다. </p>";
		}
		ModelAndView mav = new ModelAndView("parentupnickname");
		mav.addObject("res", m);
		return mav;
	}
}
