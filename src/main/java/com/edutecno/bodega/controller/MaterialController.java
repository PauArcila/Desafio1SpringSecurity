package com.edutecno.bodega.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.edutecno.bodega.dto.Material;


@Controller
public class MaterialController {
	@GetMapping("/materiales")
	public ModelAndView home(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("thymeleaf/materiales");
		modelAndView.addObject("material",new Material());
		modelAndView.addObject("valores", session.getAttribute("valores"));
		return modelAndView;
	}
	
	@PostMapping("/materiales")
	public RedirectView home(HttpSession session, @ModelAttribute Material materiales) {
		List<Material> valores = new ArrayList<Material>();
		if(session.getAttribute("valores")!=null) {
			valores.addAll((List<Material>) session.getAttribute("valores"));
		}
		valores.add(materiales);
		session.setAttribute("valores", valores);
		return new RedirectView("/materiales");
				
	}
}
