package br.com.nutricao_EJB.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Paciente
 */
@Stateless
public class Paciente implements PacienteLocal {

    /**
     * Default constructor. 
     */
    public Paciente() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String doSomething() {
		// TODO Auto-generated method stub
		System.out.println("teste");
		
		return "vvvvvvvvvvvvvvVVvvvvvvvvvvvvvvv";
	}

}
