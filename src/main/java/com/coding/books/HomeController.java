package com.coding.books;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	 @RequestMapping("/")
	 public String home(HttpSession session, Model model) {
		
		 return "Index.jsp";
	}

}
