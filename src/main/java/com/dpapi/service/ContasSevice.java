package com.dpapi.service;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

@Service
public class ContasSevice {
		

	public String salarioLiq(double salarioBr, int dependentes) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		double Inss = 0;
		double Irrf = 0;
		if(salarioBr <= 1556.94 ) {
			Inss = 0.08;
		} else if(salarioBr >= 1556.95 || salarioBr <= 2594.92) {
			Inss = 0.09;
		}else if(salarioBr >= 2954.93 || salarioBr <= 5189.82) {
			Inss = 0.11;
		}else if(salarioBr > 5189.82) {
			Inss = 0.111;
		}
		
		double salarioInss = salarioBr * Inss;
		double base = salarioBr - salarioInss - (dependentes * 189.59);
		
		if(base <= 1903.98) {
			Irrf = 0;
		}else if(base >= 1903.99 || base <= 2826.65) {
			Irrf = 7.5 / 100;
			base = (base * Irrf) - 142.80;
		}else if(base >= 2826.66 || base <= 3751.05) {
			Irrf = 15 / 100;
			base = (base * Irrf) - 354.80;
		}else if(base >= 3751.06 || base <= 4664.68) {
			Irrf = 22.5 / 100;
			base = (base * Irrf) - 636.13;
		}else if(base > 4664.68) {
			Irrf = 27.5 / 100;
			base = (base * Irrf) - 869.36;
		}

		double salarioLiquido = salarioBr - base - salarioInss;
		
		return df.format(salarioLiquido);
		
	}
	
	public double salarioInss(double salarioBr) {
		double salarioInss = 0;
        if(salarioBr <= 1600.00) {
            salarioInss = (salarioBr/100) * 8;
        }    else if(salarioBr >= 1600.01 && salarioBr <= 2599.99) {
            salarioInss = (salarioBr/100) * 9;
        }    else if(salarioBr >= 2600.00 && salarioBr <= 5189.82) {
            salarioInss = (salarioBr/100) * 11;
        }    else if(salarioBr >= 5189.83) {
            salarioInss = (salarioBr/100) * 11.10;
        }    else {
            salarioInss = 0;
        }
       
        return salarioInss;
	}
	
	public String salarioIrrs(double salarioBr, int dependentes) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		double Irrf = 0;
		double Inss = 0;
		
		if(salarioBr <= 1556.94 ) {
			Inss = 0.08;
		} else if(salarioBr >= 1556.95 || salarioBr <= 2594.92) {
			Inss = 0.09;
		}else if(salarioBr >= 2954.93 || salarioBr <= 5189.82) {
			Inss = 0.11;
		}else if(salarioBr > 5189.82) {
			Inss = 0.111;
		}
		
		double salarioInss = salarioBr * Inss;
		double base = salarioBr - salarioInss - (dependentes * 189.59);
		
		if(base <= 1903.98) {
			Irrf = 0;
		}else if(base >= 1903.99 || base <= 2826.65) {
			Irrf = 7.5 / 100;
			base = (base * Irrf) - 142.80;
		}else if(base >= 2826.66 || base <= 3751.05) {
			Irrf = 15 / 100;
			base = (base * Irrf) - 354.80;
		}else if(base >= 3751.06 || base <= 4664.68) {
			Irrf = 22.5 / 100;
			base = (base * Irrf) - 636.13;
		}else if(base > 4664.68) {
			Irrf = 27.5 / 100;
			base = (base * Irrf) - 869.36;
		}
		
		
		
		return df.format(base);
	}

	public String salarioFerias(double salarioBr, int dependentes, int diasFerias, double umtercoFerias
			, double abonoPecu, double tercoAbonoPecu, double Adiantamento) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		double valorFerias = (salarioBr/30) * diasFerias;
        
		umtercoFerias = valorFerias / 3;
		abonoPecu = (salarioBr/30) * 10;
		tercoAbonoPecu = abonoPecu / 3;
		Adiantamento = salarioBr /  2;
		
		double total = valorFerias + umtercoFerias + abonoPecu + tercoAbonoPecu + Adiantamento;
		
		double Inss = 0;
		double Irrf = 0;
		if(salarioBr <= 1556.94 ) {
			Inss = 0.08;
		} else if(salarioBr >= 1556.95 || salarioBr <= 2594.92) {
			Inss = 0.09;
		}else if(salarioBr >= 2954.93 || salarioBr <= 5189.82) {
			Inss = 0.11;
		}else if(salarioBr > 5189.82) {
			Inss = 0.111;
		}
		
		double salarioInss = salarioBr * Inss;
		double base = salarioBr - salarioInss - (dependentes * 189.59);
		
		if(base <= 1903.98) {
			Irrf = 0;
		}else if(base >= 1903.99 || base <= 2826.65) {
			Irrf = 7.5 / 100;
			base = (base * Irrf) - 142.80;
			//DeduImp = 142.80;
		}else if(base >= 2826.66 || base <= 3751.05) {
			Irrf = 15 / 100;
			base = (base * Irrf) - 354.80;
			//DeduImp = 354.80;
		}else if(base >= 3751.06 || base <= 4664.68) {
			Irrf = 22.5 / 100;
			base = (base * Irrf) - 636.13;
			//DeduImp = 636.13;
		}else if(base > 4664.68) {
			Irrf = 27.5 / 100;
			base = (base * Irrf) - 869.36;
			//DeduImp = 869.36;
		}
		
		double totalLiquido = total - base - salarioInss;
		
		return "Valor Férias: " + df.format(valorFerias) + "\n" 
		+ "1/3 férias: " + df.format(umtercoFerias) + "\n"
		+ "Abono Pecuniário: " + df.format(abonoPecu) + "\n"
		+ "1/3 Abono Pecuniário: " + df.format(tercoAbonoPecu) + "\n"
		+ "Adiantamento 1ª Parcela 13º: " + df.format(Adiantamento) + "\n" 
		+ "Salário Líquido Total: " + df.format(totalLiquido);
		
	}
	
}
