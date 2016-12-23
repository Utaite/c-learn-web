package or.clearn.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.DostarVO;
import or.vo.RegisterAddListVO;
import or.vo.RegisterClassListVO;
import or.vo.RegisterDoingVO;
import or.vo.RegisterDoneVO;

@Repository
public class RegisterDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public List<RegisterAddListVO> registerAddList(int cc_num){
		return ss.selectList("register.registerAddList",cc_num);
	}
	public List<RegisterClassListVO> registerClassList(int ct_num){
		return ss.selectList("register.registerClassList", ct_num);
	}
	public List<RegisterDoingVO> registerDoginList(RegisterDoingVO vo) {
		return ss.selectList("register.registerDoginList", vo);
	}
	public int get_cntchnum(RegisterDoingVO vo) {
		return ss.selectOne("register.get_cntchnum", vo);
	}
	public int get_cntcldone(RegisterDoingVO vo) {
		return ss.selectOne("register.get_cntcldone", vo);
	}
	public List<Integer> getct_list(int p_num) {
		return ss.selectList("register.getct_list", p_num);
	}
	public List<RegisterDoingVO> getChaplist(RegisterDoingVO vo) {
		return ss.selectList("register.getChapList", vo);
	}
	public List<RegisterDoneVO> registerDoneList(RegisterDoneVO vo){
		return ss.selectList("register.registerDoneList",vo);
	}
	public int get_cntchnum_done(RegisterDoneVO vo){
		return ss.selectOne("register.get_cntchnum_done",vo);
	}
	public int get_cntcldone_done(RegisterDoneVO vo){
		return ss.selectOne("register.get_cntcldone_done", vo);
	}
	public List<Integer> getct_list_done(int p_num){
		return ss.selectList("register.getct_list_done",p_num);
	}
	public void dostarUpdate(DostarVO vo) {
		ss.update("register.dostarUpdate", vo);
	}
	public void contstarUpdate(DostarVO vo) {
		ss.update("register.contstarUpdate", vo);
	}
}