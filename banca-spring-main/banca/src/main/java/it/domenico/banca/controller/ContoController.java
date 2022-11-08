package it.domenico.banca.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.domenico.banca.model.Conto;
import it.domenico.banca.service.ContoService;
import it.domenico.banca.service.CorrentistaService;

@Controller
public class ContoController {
	
	@Autowired
	private ContoService contoService;
	
	@Autowired
	private CorrentistaService correntistaService;
	
	@GetMapping("/nuovoContoForm")
	public String nuovoContoForm(Model model) {
		
		Conto conto = new Conto();

		model.addAttribute("conto", conto);
		model.addAttribute("listaCorrentisti", correntistaService.getAllCorrentisti());
		return "inserimentoConto";
	}
	
	@PostMapping("/salvaConto")
	public String salvaConto(@ModelAttribute("conto") Conto conto) {
		
		contoService.salvaConto(conto);
		
		return "redirect:/";
	}
	
	@GetMapping("/modificaContoForm/{id}")
	public String modificaContoForm(@PathVariable(value="id")long id, Model model){
		
		Conto conto = contoService.getContoById(id);
		
		model.addAttribute("conto", conto);
		return "modificaConto";
	}
	
	@GetMapping("/cancellazioneConto/{id}")
	public String cancellaConto(@PathVariable(value="id")long id, Model model) {
		
		this.contoService.cancellaContoById(id);
		return "redirect:/";
	}
	
	/*@GetMapping("/versamentoForm/{id}")
	public String versamentoForm(@PathVariable(value="id")long id, Model model) {
		
		
	}*/
	
	
	
	

	
	@GetMapping("/prelievoForm/{id}")
	public String prelievoForm(@PathVariable(value="id")long id, Model model) {
		Conto conto = contoService.getContoById(id);
		model.addAttribute("conto", conto);
		
		
		return "prelievo";
	}
	
	
	
		
	
	@PostMapping("/prelievoSaldo")
	public String prelievoSaldo(@ModelAttribute("conto") Conto conto, HttpServletRequest request, double saldo) 
	{
		Double prelievo=Double.parseDouble(request.getParameter("prelievo"));
		double operazione = saldo - prelievo;
		
		conto.setSaldo(operazione);
		
		contoService.salvaConto(conto);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/versamentoForm/{id}")
	public String versamentoForm(@PathVariable(value="id")long id, Model model) {
		Conto conto = contoService.getContoById(id);
		model.addAttribute("conto", conto);
		
		return "versamento";
	}
	
	@PostMapping("/versamentoSaldo")
	public String versamentoSaldo(@ModelAttribute("conto")Conto conto, HttpServletRequest request, double saldo) {
		Double versamento= Double.parseDouble(request.getParameter("versamento"));
		double operazione = saldo + versamento;
		
		conto.setSaldo(operazione);
		
		contoService.salvaConto(conto);
		
		return "redirect:/";
	}
	
	

	
	
}
