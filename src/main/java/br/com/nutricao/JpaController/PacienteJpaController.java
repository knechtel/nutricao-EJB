package br.com.nutricao.JpaController;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.Paciente;

@Stateless

@Remote(PacienteJpaControllerRemote.class)
public class PacienteJpaController implements PacienteJpaControllerRemote {
	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;
	@Override
	public void create(Paciente paciente) {
		// TODO Auto-generated method stub
		em.persist(paciente);
	}

}
