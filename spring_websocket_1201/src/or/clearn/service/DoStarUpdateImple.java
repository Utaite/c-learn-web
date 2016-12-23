package or.clearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import or.clearn.dao.ChapterEnrollDao;
import or.clearn.dao.ContentEnrollDao;
import or.clearn.dao.RegisterDao;
import or.vo.ChapEnrollVO;
import or.vo.ContentEnrollVO;
import or.vo.DostarVO;

@Transactional
@Service
public class DoStarUpdateImple implements DoStarUpdateInter {

	@Autowired
	private RegisterDao registerDao;

	@Override
	public void starUpdate(DostarVO vo) throws Exception {
		System.out.println("222vo.getc_star : " + vo.getCt_star());
		System.out.println("222vo.getp_num : " + vo.getP_num());
		System.out.println("222vo.getct_num : " + vo.getCt_num());
		registerDao.dostarUpdate(vo);
		System.out.println("肺弊 户具户具22222");
		registerDao.contstarUpdate(vo);
	}
	

}
