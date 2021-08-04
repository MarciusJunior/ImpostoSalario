package com.dpapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dpapi.service.ContasSevice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/salario")
public class SalarioController {
	
	private ContasSevice contasService;
	
	@GetMapping("/salarioliquido/{salarioBr}/{dependentes}")
	public String SalarioLiquido(@PathVariable double salarioBr, @PathVariable int dependentes) {
		return contasService.salarioLiq(salarioBr, dependentes);
	}
	
	@GetMapping("/inss/{salarioBr}")
	public double SalarioInss(@PathVariable double salarioBr) {
		return contasService.salarioInss(salarioBr);
	}
	
	@GetMapping("/irrs/{salarioBr}/{dependentes}")
	public String SalarioIrrs(@PathVariable double salarioBr, @PathVariable int dependentes) {
		return contasService.salarioIrrs(salarioBr, dependentes);
	}
	
	@GetMapping("/ferias/{salarioBr}/{dependentes}/{diasFerias}")
	public String SalarioFerias(@PathVariable double salarioBr, @PathVariable int dependentes, @PathVariable int diasFerias) {
		return contasService.salarioFerias(salarioBr, dependentes, diasFerias, diasFerias, salarioBr, dependentes, diasFerias);
	}

}
