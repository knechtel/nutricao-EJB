package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.Atividade;


@Stateless
@Remote(AtividadeJpaControllerRemote.class)
public class AtividadeJpaController implements AtividadeJpaControllerRemote {

	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;
	
	public void create(Atividade atividade) {
		// TODO Auto-generated method stub
		em.persist(atividade);
	}

	public List<Atividade> findAll() {
		List<Atividade> listPaciente = em.createNamedQuery("Atividade.findAll",Atividade.class).getResultList();
		return listPaciente;
	}
}
