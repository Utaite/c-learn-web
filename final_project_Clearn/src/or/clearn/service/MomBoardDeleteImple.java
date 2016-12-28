package or.clearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import or.clearn.dao.MomBoardDao;

@Transactional
@Service
public class MomBoardDeleteImple implements MomBoardDeleteInter {

	@Autowired
	private MomBoardDao momBoardDao;
	// 게시글 삭제시 댓글을 먼저 삭제하고 삭제한다.
	@Override
	public void deleteAll(int ib_num) throws Exception {
		momBoardDao.momBoardCommDelete(ib_num);
		momBoardDao.momBoardDelete(ib_num);
	}

}
