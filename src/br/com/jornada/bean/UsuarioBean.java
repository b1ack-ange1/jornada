package br.com.jornada.bean;

import javax.enterprise.inject.Model;

import br.com.jornada.modelo.Usuario;

@Model
public class UsuarioBean {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 
}
