package or.clearn.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.ChapEnrollVO; 

@Repository 
public class ChapterEnrollDao { 
	  
	//마이바티스 template 주입
	@Autowired   
	private SqlSessionTemplate ss; 
	 
	public void insertrchapter(ChapEnrollVO chvo){
		ss.insert("chapter.enroll2", chvo);
	}     
	   
}    
   