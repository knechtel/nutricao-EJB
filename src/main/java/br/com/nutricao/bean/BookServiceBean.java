package br.com.nutricao.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Stateless
public class BookServiceBean implements BookService {
	 @PersistenceContext(unitName = "nutricao-EJBPU")
    private EntityManager em;

    
    public BookServiceBean() {
    }
    
    public void remove(Book book) {
        em.remove(em.merge(book));
    }
    public Book find(Object id) {
        return em.find(Book.class, id);
    }

	@Override
	public void createOrUpdate(Book book) {
		
		em.merge(book);
		
	}
}
