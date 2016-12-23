package or.clearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import or.clearn.dao.MyClassDao;
import or.vo.MyClassVO;
import or.vo.RestVO;

@Transactional
@Service
public class MyclassVideoInsertImple implements MyclassVideoInsertInter {

	@Autowired
	private MyClassDao myclassDao;
	
	@Override
	public void insertMyclassVideo(MyClassVO mcvo, RestVO rvo) throws Exception {
		myclassDao.insertClass(mcvo);
		myclassDao.insertVideo(rvo);
	}

}
