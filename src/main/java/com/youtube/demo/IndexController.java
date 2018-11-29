package com.youtube.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	/**
	 * Indica que redirija a la pagina index cuando no se escriba algun nombre de pagina es decir
	 * por ejemplo http:localhost:8080/demo/
	 * @return
	 */
	@RequestMapping("/")
	public String getIndexPage() {
		return "index";
	}

}
