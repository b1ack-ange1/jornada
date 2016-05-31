package br.com.jornada.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.jornada.modelo.Usuario;

public class DataModelUsuarios extends LazyDataModel<Usuario> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
    private UsuarioDao dao;

    @PostConstruct
    public void inicializaTotal() {
        this.setRowCount(dao.count());
    }



	public List<Usuario> load (int inicio, int quantidade, String campoOrdenacao, SortOrder sentidoOrdenacao, Map<String,Object> filtros) {
	        return dao.listaComPaginacao(inicio, quantidade);
    }	
}