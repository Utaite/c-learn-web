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
	
	@Override
	public void deleteAll(int ib_num) throws Exception {
		momBoardDao.momBoardCommDelete(ib_num);
		momBoardDao.momBoardDelete(ib_num);
	}

}
