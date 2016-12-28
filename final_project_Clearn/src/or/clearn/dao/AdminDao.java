package or.clearn.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.AdminVO;

@Repository
public class AdminDao {
	@Autowired
	private SqlSessionTemplate ss;

	public void addAdmin(AdminVO vo) {
		ss.insert("admin.add", vo);
	}

	public int checkId(String a_id) {
		return ss.selectOne("admin.check", a_id);
	}

	public int checknickname(String a_nickname) {
		return ss.selectOne("admin.nickname", a_nickname);
	}
}
