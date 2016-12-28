package or.clearn.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.MomBoardVo;
import or.vo.ReplyVo;

@Repository
public class MomBoardDao { 
	@Autowired
	private SqlSessionTemplate ss;

	// 맘 게시판 등록
	public void insertMomBoard(MomBoardVo mvo) {
		ss.insert("momBoard.momBoardAdd", mvo);
	}

	// 맘 게시판 리스트
	public List<MomBoardVo> listMomBoard1(MomBoardVo mvo) {
		return ss.selectList("momBoard.momBoardList2", mvo);
	}

	// 맘 게시판 모든 목록 검색 카운트
	public int totalMomboard1() {
		return ss.selectOne("momBoard.momBoardTotal"); // ?
	}

	// 맘 게시판 모든 목록 검색

	public List<MomBoardVo> listMomBoard2(MomBoardVo mvo) {
		System.out.println("검색타입1:" + mvo.getSearchType());
		System.out.println("검색value1:" + mvo.getSearchValue());
		return ss.selectList("momBoard.momBoardListSearch", mvo);
	}

	// 맘 게시판 리스트 갯수(검색) 
	public int totalMomboard2(MomBoardVo mvo) {
		System.out.println("검색타입2:" + mvo.getSearchType());
		System.out.println("검색value2:" + mvo.getSearchValue());

		return ss.selectOne("momBoard.momBoardTotalSearch", mvo);
	}

	public List<ReplyVo> getreplyList(int ib_num) {
		return ss.selectList("reply.list", ib_num);
	}

	// 맘 게시판 상세페이지
	public MomBoardVo momBoardDetail(int ib_num) {
		return ss.selectOne("momBoard.momBoardDetail", ib_num);
	}

	// 맘 게시판 조회수 증가
	public void momBoardUpdateHit(int ib_num) {
		ss.update("momBoard.momBoardUpdateHit", ib_num);
	}

	// 맘 게시판 수정
	public void momBoardUpdate(MomBoardVo mvo) {
		ss.update("momBoard.momBoardUpdate", mvo);
	}

	// 맘 게시판 삭제
	public void momBoardDelete(int ib_num) {
		ss.delete("momBoard.momBoardDelete", ib_num);
	}
	
	// 맘 게시판 댓글 삭제
	public void momBoardCommDelete(int ib_num){
		ss.delete("momBoard.momBoardCommDelete",ib_num);
	}
}
