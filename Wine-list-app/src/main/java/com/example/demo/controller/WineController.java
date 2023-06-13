package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Wine;
import com.example.demo.service.WineService;

@Controller
public class WineController {

	@Autowired
	private WineService wineService;
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listWine", wineService.getAllWine());
		return "index";
	}
	
	@GetMapping("/showNewWineForm")
	public String showNewWineForm(Model model) {
		Wine wine = new Wine();
		model.addAttribute("wine", wine);
		return "new_wine";
	}
	
	@PostMapping("/saveWine")
	public String saveWine(@ModelAttribute("wine") Wine wine) {
		wineService.saveWine(wine);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		Wine wine = wineService.getWineById(id);
	
		model.addAttribute("wine", wine);
		return "update_wine";
		
	}
	
	@GetMapping("/deleteWine/{id}")
	public String deleteWine(@PathVariable (value = "id") long id) {	
		this.wineService.deleteWineById(id);
		return "redirect:/";
	}
}
	
