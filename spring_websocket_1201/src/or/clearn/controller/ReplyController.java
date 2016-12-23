package or.clearn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import or.clearn.dao.ReplyDao;
import or.vo.ReplyVo; 

@Controller
public class ReplyController {
  
	@Autowired 
	private ReplyDao dao;

	// bbs1Comm.kosta : insert Comment
	@RequestMapping(value = "/replyComm", method = RequestMethod.POST)
	public ModelAndView replyComm(ReplyVo vo, String p_nickname) {
		System.out.println("여기까지는 온거니?");
		int p_num = dao.getp_num(p_nickname);
		vo.setP_num(p_num);
		dao.insertrplay(vo);
		// Deatil로 이동 시 get방식으로 실제 detail의 식별자인
		// kcode값으로 지정해야 한다.!
		StringBuffer redirect = new StringBuffer();
		redirect.append("redirect:/momBoardDetail?ib_num=");
		redirect.append(vo.getIb_num());
		return new ModelAndView(redirect.toString());
	}

	// 댓글 리스트
//	@RequestMapping(value = "/replyList") 
//	public ModelAndView replyList(int ib_num, int ic_num) {
//		System.out.println("여기까지는 되는건가?"); 
//		ModelAndView mav = new ModelAndView("replyList");
//		System.out.println("이 위로 안되는 거지?");  
//		List<ReplyVo> list = dao.getreplyList(ib_num); 
//		mav.addObject("list", list);
//		mav.addObject("ib_num", ib_num);
//		mav.addObject("ic_num", ic_num);
//		return mav;
//	}    
//	
	@RequestMapping(value = "/replyDel") 
	public ModelAndView replyDel(ReplyVo vo) {
		System.out.println("댓글 지울거야");
		ModelAndView mav = new ModelAndView("redirect:/momBoardDetail?ib_num="+vo.getIb_num());
		System.out.println("이 위로 안되는 거지?");  
		dao.replyDelete(vo); 
		return mav;
	}
}    
