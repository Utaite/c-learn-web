package or.clearn.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.ContentVO;

@Repository
public class ContentDao {

	@Autowired
	private SqlSessionTemplate ss;

	public ContentVO getdetail(int ct_num) {
		return ss.selectOne("content.getdetail", ct_num);
	}
	
	public int getperiod(int ct_num){
		return ss.selectOne("content.getperiod", ct_num);
	}
}
