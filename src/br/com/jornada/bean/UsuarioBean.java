package br.com.jornada.bean;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.model.LazyDataModel;

import br.com.jornada.dao.DataModelUsuarios;
import br.com.jornada.dao.UsuarioDao;
import br.com.jornada.modelo.Usuario;

@Named
@RequestScoped
public class UsuarioBean {

	
	private Usuario usuario = new Usuario();
	
	
	@Inject
	private DataModelUsuarios dataModel;

	public LazyDataModel<Usuario> getDataModel() {
	    return dataModel;
	}

	@Inject
	private UsuarioDao dao;
	
	@Transactional
	public void cadastrar(){
		this.dao.adiciona(usuario);
		this.atualiza();
		System.out.println("Cadastrado usuário");
	}
	
	
	public void atualiza(){
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

}
