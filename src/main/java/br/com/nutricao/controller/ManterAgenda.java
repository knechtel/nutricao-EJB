package br.com.nutricao.controller;

import javax.ejb.Stateless;
import javax.inject.Named;

@Stateless
@Named("manterAgenda")

public class ManterAgenda {
	
	
	public String doTest() {
		return "/manterAgenda.jsf";
	}

}
