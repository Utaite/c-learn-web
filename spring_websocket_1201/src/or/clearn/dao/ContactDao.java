package or.clearn.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import or.vo.ContactVO;

@Repository
public class ContactDao {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public void addContact(ContactVO vo) {
		ss.insert("contact.addcontact", vo);
	}
}
