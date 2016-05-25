package br.com.jornada.primefaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.jornada.modelo.Usuario;
 
/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class LazyUsuarioDataModel extends LazyDataModel<Usuario> {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;
     
    public LazyUsuarioDataModel(List<Usuario> usuarios) {
		// TODO Auto-generated constructor stub
    	this.usuarios = usuarios;
	}
    
     
    @Override
    public Usuario getRowData(String rowKey) {
        for(Usuario user : usuarios) {
            if(user.getId().equals(rowKey))
                return user;
        }
 
        return null;
    }
 
    @Override
    public Object getRowKey(Usuario user) {
        return user.getId();
    }
 
    @Override
    public List<Usuario> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<Usuario> data = new ArrayList<Usuario>();
 
        //filter
        for(Usuario user : usuarios) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(user.getClass().getField(filterProperty).get(user));
 
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                    }
                    else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }
 
            if(match) {
                data.add(user);
            }
        }
 
        //sort
//        if(sortField != null) {
//            Collections.sort(data, new LazySorter(sortField, sortOrder));
//        }
 
        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);
 
        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}