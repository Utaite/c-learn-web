package or.clearn.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.SearchFaqBoardVO;

@Repository
public class FaqBoardDao {
	@Autowired
	private SqlSessionTemplate ss;
	// 자주하는 질문 게시판 목록 
	public List<SearchFaqBoardVO> faqboardList(){
		return ss.selectList("faqboard.faqboardList");
	}
}
