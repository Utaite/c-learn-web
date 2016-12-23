package or.clearn.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.ChapterVO;

@Repository
public class ChapterDao {
	
	@Autowired
	private SqlSessionTemplate ss;

	public List<ChapterVO> getlist(int ct_num) {
		return ss.selectList("chapter.getlist", ct_num);
	}

	public int chapnum(int ct_num) {
		return ss.selectOne("chapter.chapnum", ct_num);
	}

	public List<Integer> chaplist(int ct_num) {
		return ss.selectList("chapter.chaplist", ct_num);
	}
}