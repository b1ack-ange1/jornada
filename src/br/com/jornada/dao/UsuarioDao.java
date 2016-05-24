package br.com.jornada.dao;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

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
		manager.persist(usuario);
		
	}

}
