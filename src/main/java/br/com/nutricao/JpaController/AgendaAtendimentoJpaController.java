package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.AgendaAtendimento;

@Stateless
@Remote(AgendaAtendimentoJpaControllerRemote.class)
public class AgendaAtendimentoJpaController implements AgendaAtendimentoJpaControllerRemote {


	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;
	

	public void create(AgendaAtendimento agendaAtendimento) {
		// TODO Auto-generated method stub
		em.persist(agendaAtendimento);
	}


	public List<AgendaAtendimento> findAll() {
		List<AgendaAtendimento> listAgendaAtendimento = em.createNamedQuery("AgendaAtendimento.findAll",AgendaAtendimento.class).getResultList();
		return listAgendaAtendimento;
	}
}
