package it.domenico.banca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.domenico.banca.model.Correntista;
import it.domenico.banca.service.ContoService;
import it.domenico.banca.service.CorrentistaService;

@Controller
public class CorrentistaController {
	
	@Autowired
	private CorrentistaService correntistaService;
	
	@Autowired
	private ContoService contoService;
	
	
	@GetMapping("/")
	public String homePage(Model model) {
		
		model.addAttribute("listaCorrentisti", correntistaService.getAllCorrentisti());
		
		return "home";
	}
	
	@GetMapping("/nuovoCorrentistaForm")
	public String nuovoCorrentista(Model model) {
		
		Correntista correntista = new Correntista();
		
		model.addAttribute("correntista", correntista);
		
		return "inserimentoCorrentista";
	}
	
	@PostMapping("/salvaCorrentista")
	public String salvaCorrentista(@ModelAttribute("Correntista")Correntista correntista) {
		correntistaService.salvaCorrentista(correntista);
		
		return "redirect:/";
	}
	
	@GetMapping("/modificaCorrentistaForm/{id}")
	public String modificaCorrentistaForm(@PathVariable(value="id") long id, Model model) {
		Correntista correntista = correntistaService.getCorrentistaById(id);
		
		model.addAttribute("correntista", correntista);
		
		return "modificaCorrentista";
	}
	
	@GetMapping("/cancellazioneCorrentista/{id}")
	public String cancellaCorrentista(@PathVariable(value="id") long id, Model model) {
		
		this.correntistaService.cancellaCorrentistaById(id);
		
		return "redirect:/";
	}
	
	@GetMapping("/visualizzaDettagliForm/{id}")
	public String visualizzaDettagliForm(@PathVariable(value="id")long id, Model model) {
		
		Correntista utente = correntistaService.getCorrentistaById(id);
		model.addAttribute("utente", contoService.findAllContiByCorrentista(utente));
		
		return "visualizzaDettagli";
		
	}
	
}
