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

	public UsuarioJpaController() {
	}

	@Override
	public void create(br.com.nutricao.bean.Usuario usuario) {
		// TODO Auto-generated method stub
		em.persist(usuario);
		em.flush();
	}

	public List<Usuario> findAll() {
		try {
			@SuppressWarnings("unchecked")
			List<Usuario> list = em.createNamedQuery("Usuario.findAll").getResultList();
			return list;
		} finally {

		}
	}

	public Usuario findByLoginAndSenha(Usuario usuario) {

		if (usuario.getNome().equals("") || usuario.getPassword().equals(""))
			return null;

		if (usuario.getNome() == null || usuario.getPassword() == null)
			return null;

		// tratar se for null
		List<Usuario> list = em.createNamedQuery("Usuario.findByLoginAndPassword",Usuario.class)
				.setParameter("nome", usuario.getNome()).setParameter("senha", usuario.getPassword()).getResultList();

		if (list == null || list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	public Usuario findUsuario() {
		return null;
	}

}
