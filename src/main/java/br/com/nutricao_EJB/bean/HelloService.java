package br.com.nutricao_EJB.bean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;


import br.com.nutricao_EJB.controller.UsuarioControllerRemote;


@Stateless

@Named("helloService")

public class HelloService {

	@EJB
	PacienteLocal clockService;


	@EJB
	UsuarioControllerRemote usuarioController;
	
	public String getHello() {

		
		Usuario usuario = new Usuario();
		usuario.setNome("Mauricio123");
		
		usuarioController.create(usuario);
		return "Hello from EJB / CDI: " + clockService.doSomething();

	}

}