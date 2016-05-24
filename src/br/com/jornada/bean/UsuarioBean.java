package br.com.jornada.bean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.jornada.dao.UsuarioDao;
import br.com.jornada.modelo.Usuario;

@Model
public class UsuarioBean {

	private Usuario usuario = new Usuario();

	@Inject
	private UsuarioDao dao;
	
	@Transactional
	public String cadastrar(){
		dao.adiciona(getUsuario());

		return "cadastro_evento?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 
}
