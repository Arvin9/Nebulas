package site.nebulas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UMeditorController {
	@RequestMapping("umEditor")
	public String umEditor(){
		
		return "umEditor";
	}
}
