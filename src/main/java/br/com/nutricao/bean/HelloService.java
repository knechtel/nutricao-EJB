package br.com.nutricao.bean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nutricao.JpaController.UsuarioControllerRemote;


@Stateless

@Named("helloService")

public class HelloService {

	@EJB
	UsuarioControllerRemote usuarioController;
	
	@EJB
	UsuarioControllerRemote usuarioControllerFind;
	
	public String getHello() {

Usuario u  = new Usuario();
u.setNome("micheliknechtel");
u.setPassword("micheliknechtel");
		Usuario us = usuarioController.findByLoginAndSenha(u);
		return "Hello from EJB / CDI: "+us.getNome() ;

	}

}