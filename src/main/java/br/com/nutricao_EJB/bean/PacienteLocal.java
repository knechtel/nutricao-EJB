package br.com.nutricao_EJB.bean;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface PacienteLocal {
	
	String doSomething();

}
