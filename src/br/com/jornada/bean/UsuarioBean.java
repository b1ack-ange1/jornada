package br.com.jornada.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.model.LazyDataModel;

import br.com.jornada.dao.UsuarioDao;
import br.com.jornada.modelo.Usuario;

@Named
@RequestScoped
public class UsuarioBean {

	@Inject
	private Usuario usuario;
	private List<Usuario> usuarios;
	

	@Inject
	private UsuarioDao dao;
	
	@Transactional
	public void cadastrar(){
		this.dao.adiciona(usuario);
		this.atualiza();
	}
	
	public List<Usuario> getUsuarios(){
		if (usuarios == null) {
			System.out.println("Carregando usuarios..");
			atualizaTabela();
		}
		return this.usuarios;
	}
	
	//Metódo para Atualizar/Buscar Lista
	public void atualizaTabela() {
		this.usuarios = dao.listaTodos();
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
