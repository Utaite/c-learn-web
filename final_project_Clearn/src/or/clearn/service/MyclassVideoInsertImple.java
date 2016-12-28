package or.clearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import or.clearn.dao.MyClassDao;
import or.vo.MyClassVO;
import or.vo.RestVO;

// 트랜잭션 처리를 하기 위해서 @Transactional어노테이션을 사용하고,
//@Autowired를 사용하기 위해서 @Service 어노테이션을 사용한다.
@Transactional
@Service
public class MyclassVideoInsertImple implements MyclassVideoInsertInter {

	// MyClassDao를 가져오고 자동빈 묶기를 한다.
	@Autowired
	private MyClassDao myclassDao;
	
	// 수강신청 시 비디오도 같이 등록해준다.
	// 트랜잭션 처리를 한다.
	@Override
	public void insertMyclassVideo(MyClassVO mcvo, RestVO rvo) throws Exception {
		myclassDao.insertClass(mcvo);
		myclassDao.insertVideo(rvo);
	}

}
