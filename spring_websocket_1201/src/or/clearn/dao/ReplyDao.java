package or.clearn.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import or.vo.ReplyVo;
@Controller
public class ReplyDao { 
	 
	//마이바티스 template 주입 
	@Autowired 
	private SqlSessionTemplate ss;
	
	public void insertrplay(ReplyVo vo){
		ss.insert("reply.insert", vo);
	}   
	     

	public void replyDelete(ReplyVo vo){ 
		ss.delete("reply.delete", vo);  
	}

	public int getp_num(String p_nickname) {
		return ss.selectOne("reply.pnum", p_nickname);
	}

}  
