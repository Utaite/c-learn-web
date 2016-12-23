package or.clearn.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.ChildVO;
import or.vo.SearchChildVO;

@Repository
public class ChildDao {
	@Autowired
	private SqlSessionTemplate ss;

	public void addChild(ChildVO vo){
		ss.insert("child.add",vo);
	}
	
	public List<SearchChildVO> childlist(SearchChildVO scvo) {
		return ss.selectList("child.childlist", scvo);
	}
	// 자녀의 모든 목록의 총수
	public int childlisttotal() {
		return ss.selectOne("child.childlisttotal");
	}
	// 자녀의 모든 목록의 검색
	public List<SearchChildVO> childlistsearch(SearchChildVO scvo) {
		return ss.selectList("child.childlistsearch", scvo);
	}
	// 자녀의 모든 목록의 총수의 검색
	public int childlisttotalsearch(SearchChildVO scvo){
		return ss.selectOne("child.childlisttotalsearch",scvo);
	}
	// 자녀의 상세페이지
	public SearchChildVO childdetailadmin(int c_num){
		return ss.selectOne("child.childdetailadmin", c_num);
	}
	// 자녀 탈퇴시키기
	public void childdeleteadmin(int c_num){
		ss.delete("child.childdeleteadmin",c_num);
	}
}
