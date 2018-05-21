package br.com.nutricao.JpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.nutricao.bean.Usuario;

@Stateless
@Remote(UsuarioJpaControllerRemote.class)
public class UsuarioJpaController implements UsuarioJpaControllerRemote {
	
	@PersistenceContext(unitName = "nutricao-EJBPU")
	private EntityManager em;
	
	@Override
	public void create(br.com.nutricao.bean.Usuario usuario) {
		em.persist(usuario);
		em.flush();
	}

	public List<Usuario> findAll() {
		return em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
	}
	
	public List<Usuario> findAllAdmins() {
		return em.createNamedQuery("Usuario.findAllByTipo", Usuario.class)
			.setParameter("tipo", Usuario.TIPO_ADMIN)
			.getResultList();
	}

	public Usuario findByLoginAndSenha(Usuario usuario) {
		if (
			usuario.getEmail().equals("")
			|| usuario.getPassword().equals("")
			|| usuario.getEmail() == null
			|| usuario.getPassword() == null
		) {
			return null;
		}

		List<Usuario> list = em.createNamedQuery("Usuario.findByLoginAndPassword", Usuario.class)
				.setParameter("email", usuario.getEmail())
				.setParameter("senha", usuario.getPassword())
				.setMaxResults(1)
				.getResultList();

		if (list == null || list.size() == 0)
			return null;
		else
			return list.get(0);
	}
	
	@Override
	public void delete(Usuario usuario) {
		em.createQuery("DELETE FROM Usuario WHERE id=" + usuario.getId()).executeUpdate();
		if (em.contains(usuario)){
		     em.remove(usuario);
		}
	}
}
