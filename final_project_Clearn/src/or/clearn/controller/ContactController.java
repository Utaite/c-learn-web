package or.clearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import or.clearn.dao.ContactDao;
import or.vo.ContactVO;

@Controller
public class ContactController {
	
	@Autowired
	private ContactDao contactDao;
	
	@RequestMapping(value="contact")
	public String contact(ContactVO vo){
		contactDao.addContact(vo);
		return "";
	}
	
}
