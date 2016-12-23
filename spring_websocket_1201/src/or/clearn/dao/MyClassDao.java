package or.clearn.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.MyClassVO;
import or.vo.ParentVO;
import or.vo.RestVO;

@Repository
public class MyClassDao {

	@Autowired
	private SqlSessionTemplate ss;

	public void insertClass(MyClassVO vo) {
		ss.insert("myclass.insertclass", vo);
	}
	
	public void insertVideo(RestVO restvo){
		ss.insert("myclass.insertvideo",restvo);
	}
	
	public ParentVO selectIdToken(int p_num){
		return ss.selectOne("myclass.selectIdToken",p_num);
	}
}
