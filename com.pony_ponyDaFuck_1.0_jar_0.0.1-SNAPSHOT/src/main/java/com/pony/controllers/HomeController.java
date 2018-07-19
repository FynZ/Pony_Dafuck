package com.pony.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pony.services.NewsService;
import com.pony.services.UserService;

@Controller
public class HomeController {
	
	private NewsService _newsService;
	
	@Autowired
	public HomeController(NewsService newsService) {
		_newsService = newsService;
	}
    @RequestMapping(value = {"", "/", "/home"})
    public ModelAndView home(Model model) {

        return new ModelAndView("home").addObject("newsList", _newsService.findAll());
    }
}