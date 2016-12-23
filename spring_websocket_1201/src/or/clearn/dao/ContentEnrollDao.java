package or.clearn.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.ContentEnrollVO;
 
@Repository 
public class ContentEnrollDao {  
	 
	//마이바티스 template 주입
	@Autowired   
	private SqlSessionTemplate ss; 
	  
	public void insertcontent(ContentEnrollVO ctvo){
		ss.insert("content.enroll", ctvo); 
	} 
      
}   
   