package or.clearn.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.RestVO;

@Repository
public class RestDao {

	@Autowired
	private SqlSessionTemplate ss;

	public void apiToken(RestVO restvo) {
		ss.update("rest.apiToken", restvo);
		ss.update("rest.apiTokenVideo", restvo);
	}

	public RestVO apiLogin(RestVO restvo) {
		return ss.selectOne("rest.apiLogin", restvo);
	}

	public RestVO apiVideo(RestVO restvo) {
		return ss.selectOne("rest.apiVideo", restvo);
	}

	public void apiFinish(int v_num) {
		ss.update("rest.apiFinish", v_num);
	}

	public void apiSave(RestVO restvo) {
		ss.update("rest.apiSave", restvo);
	}

	public void apiUpdate(RestVO restvo) {
		ss.update("rest.apiUpdate", restvo);
	}
	
	public void apiConnectResult(RestVO restvo) {
		ss.update("rest.apiConnectResult", restvo);
	}
	
	public void apiQuizResult(RestVO restvo) {
		ss.update("rest.apiQuizResult", restvo);
	}
	
	public String apiWatchCresult(int p_num) {
		return ss.selectOne("rest.apiWatchCresult", p_num);
	}
	
	public String apiWatchQresult(int p_num) {
		return ss.selectOne("rest.apiWatchQresult", p_num);
	}

}
