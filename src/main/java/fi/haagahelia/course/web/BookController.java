package fi.haagahelia.course.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Book;

@Controller
public class BookController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("books", new Book());
		return "index";
	}

}
