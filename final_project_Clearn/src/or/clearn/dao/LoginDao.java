package or.clearn.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.AdminVO;
import or.vo.ParentVO;

@Repository
public class LoginDao {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	// Login Ã³¸®(id, pwd)
	public int userloginProcess(String id, String pw){
		ParentVO vo = new ParentVO();
		vo.setP_id(id); vo.setP_pw(pw);
		return ss.selectOne("login.userChk", vo);
	}
	
	public int adminloginProcess(String id, String pw){
		AdminVO vo = new AdminVO();
		vo.setA_id(id); vo.setA_pwd(pw);
		return ss.selectOne("login.adminChk", vo);
	}
	
	public String getAdminNick(String id){
		String res = ss.selectOne("login.adminNick",id);
		return res;
	}
	
	public ParentVO getParent(String id){
		return ss.selectOne("login.getParent", id);
	}

	public int checkID(ParentVO vo) {
		return ss.selectOne("login.checkid", vo);
	}
	
	public int checkPWD(ParentVO vo) {
		return ss.selectOne("login.checkpwd", vo);
	}

	public void newpwUpdate(String p_id, String p_pw) {
		ParentVO vo = new ParentVO();
		vo.setP_id(p_id); vo.setP_pw(p_pw);
		ss.update("login.newpwd", vo);
	}

	public String yourid(String p_mail) {
		return ss.selectOne("login.yourid", p_mail);
	}

	public int getAdminNum(String id) {
		return ss.selectOne("login.getAdminNum", id);
	}

}
