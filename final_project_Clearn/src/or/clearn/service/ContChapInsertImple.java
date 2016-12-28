package or.clearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import or.clearn.dao.ChapterEnrollDao;
import or.clearn.dao.ContentEnrollDao;
import or.vo.ChapEnrollVO;
import or.vo.ContentEnrollVO;

@Transactional
@Service
public class ContChapInsertImple implements ContChapInsertInter {

	@Autowired
	private ContentEnrollDao contentEnrollDao;
	
	@Autowired
	private ChapterEnrollDao chapterEnrollDao;
	
	// 챕터 등록 전에 컨텐츠를 먼저 등록하고 등록한다.
	@Override
	public void insertAll(ContentEnrollVO ctvo, ChapEnrollVO chvo) throws Exception {
		contentEnrollDao.insertcontent(ctvo);
		chapterEnrollDao.insertrchapter(chvo);
	}

}
