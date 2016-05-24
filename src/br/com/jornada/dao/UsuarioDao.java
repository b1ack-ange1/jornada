package br.com.jornada.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.jornada.modelo.Usuario;

public class UsuarioDao {
	
	public UsuarioDao() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private EntityManager manager;
	
	public void adiciona(Usuario usuario) {
		
		manager.persist(usuario);
		
	}

}
