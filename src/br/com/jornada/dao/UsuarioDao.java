package br.com.jornada.dao;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import br.com.jornada.modelo.Usuario;

@Named
@Dependent
public class UsuarioDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioDao() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private EntityManager manager;
	
	public void adiciona(Usuario usuario) {
		manager.joinTransaction();
		manager.persist(usuario);
		System.out.println("persistiu");
		
	}
	public int count() {
		long result = (Long) manager.createQuery("select count(u) from Usuario u").getSingleResult();
		return (int) result;
	}

	public List<Usuario> listaComPaginacao(int first, int max) {
		CriteriaQuery<Usuario> query = manager.getCriteriaBuilder().createQuery(Usuario.class);
		query.select(query.from(Usuario.class));

		return manager.createQuery(query).setFirstResult(first).setMaxResults(max).getResultList();
	}
	

	public Usuario buscaPorId(Long id) {

		Usuario usuario = manager.find(Usuario.class, id);
		return usuario;
	}


}
