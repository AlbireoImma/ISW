package com.barbatos.demoproyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barbatos.demoproyecto.model.Maquina;
import com.barbatos.demoproyecto.service.api.MaquinaServiceAPI;

@Controller
public class MaquinaController {

	@Autowired
	private MaquinaServiceAPI maquinaServiceAPI;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", maquinaServiceAPI.getAll());
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if(id != null && id != 0) {
			model.addAttribute("maquina", maquinaServiceAPI.get(id));
		} else {
			model.addAttribute("maquina", new Maquina());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(Maquina maquina, Model model) {
		maquinaServiceAPI.save(maquina);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		maquinaServiceAPI.delete(id);
		return "redirect:/";
	}
}
