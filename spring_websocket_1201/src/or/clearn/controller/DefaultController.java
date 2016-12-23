package or.clearn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	
	@RequestMapping(value={"/","/index"})
	public String viewIndex(){
		return "index";
	}   
	
	@RequestMapping(value="/adminMain")
	public String viewAdminMain(){
		return "adminMainPage";
	}
}  
 