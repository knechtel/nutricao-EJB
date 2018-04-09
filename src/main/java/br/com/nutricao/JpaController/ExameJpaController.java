package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.Exame;
import br.com.nutricao.bean.Paciente;

@Stateless
@Remote(ExameJpaControllerRemote.class)
public class ExameJpaController implements ExameJpaControllerRemote {
	
	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;

	@Override
	public void create(Exame exame) {
		// TODO Auto-generated method stub
		em.persist(exame);
	}
	
	public List<Exame> findByIdPaciente(Integer id){
		return em.createQuery("FROM Exame e  WHERE  e.paciente.id = :id  ",Exame.class).setParameter("id", id).getResultList();
	}
	
	public void delete(Exame exame) {
		em.createQuery("DELETE FROM Exame e WHERE id=" + exame.getId()).executeUpdate();
		if (em.contains(exame)){
		     em.remove(exame);
		}
	}

}
