package or.clearn.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.SearchNoticeVO;

@Repository
public class NoticeDao {
	@Autowired
	private SqlSessionTemplate ss;

	// 공지사항 등록
	public void noticeAdd(SearchNoticeVO snvo) {
		ss.insert("notice.noticeAdd", snvo);
	}

	// 공지사항 고정된 목록
	public List<SearchNoticeVO> noticeListFix() {
		return ss.selectList("notice.noticeListFix");
	}

	// 공지사항 모든 목록
	public List<SearchNoticeVO> noticeList(SearchNoticeVO snvo) {
		return ss.selectList("notice.noticeList", snvo);
	}

	// 공지사항 모든 목록 카운트
	public int noticeListTotal() {
		return ss.selectOne("notice.noticeListTotal");
	}

	// 공지사항 모든 목록 검색
	public List<SearchNoticeVO> noticeListSearch(SearchNoticeVO snvo) {
		// System.out.println("검색타입3:"+snvo.getSearchType());
		// System.out.println("검색value3:"+snvo.getSearchValue());
		System.out.println("start1:" + snvo.getStart());
		System.out.println("end1:" + snvo.getEnd());
		return ss.selectList("notice.noticeListSearch", snvo);
	}
	// 공지사항 모든 목록 검색 카운트
	public int noticeListSearchTotal(SearchNoticeVO snvo){
		return ss.selectOne("notice.noticeListSearchTotal",snvo);
	}
	// 공지사항 상세페이지
	public SearchNoticeVO noticeDetail(int n_num){
		return ss.selectOne("notice.noticeDetail", n_num);
	}
	// 공지사항 조회수 증가
	public void noticeUpdateHit(int n_num){
		ss.update("notice.noticeUpdateHit", n_num);
	}
	// 공지사항 수정
	public void noticeUpdate(SearchNoticeVO snvo){
		ss.update("notice.noticeUpdate",snvo);
	}
	// 공지사항 삭제
	public void noticeDelete(int n_num){
		ss.delete("notice.noticeDelete",n_num);
	}
}
