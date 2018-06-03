package br.com.nutricao.JpaController;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote(AtividadeJpaControllerRemote.class)
public class AtividadeJpaController implements AtividadeJpaControllerRemote {

	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;

}
