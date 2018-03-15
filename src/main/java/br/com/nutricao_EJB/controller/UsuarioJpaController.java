package br.com.nutricao_EJB.controller;



import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote(UsuarioControllerRemote.class)
public class UsuarioJpaController implements UsuarioControllerRemote {
	 @PersistenceContext(unitName = "nutricao-EJBPU")
	    private EntityManager em;
	public UsuarioJpaController() {
	}
	@Override
	public void create(br.com.nutricao_EJB.bean.Usuario usuario) {
		// TODO Auto-generated method stub
		em.persist(usuario);
		em.flush();
	}
	


	
}
