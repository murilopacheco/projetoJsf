package negocio;

import java.util.List;

import Dao.utils.DAOFactory;
import Mdelo.Usuario;

import daoAula.UsuarioDao;

public class UsuarioNegocio {
	
	private UsuarioDao usuarioDao;
	
	public UsuarioNegocio(){
		super();
		setIUsuarioDao(DAOFactory.createUsuario());
	}
	
	 private void setIUsuarioDao(UsuarioDao usuarioDao) {
	        this.usuarioDao = usuarioDao;
	    }
	
	public boolean salvar(Usuario usuario){
		usuarioDao.save(usuario);
		return true;
	}
	
	public List<Usuario> listarUsuarios(){
		List<Usuario> usuarios = null;
		usuarios = usuarioDao.listaUsuarios();
		return usuarios;
	}
	
	public void delete(Usuario usuario){
		 this.usuarioDao.delete(usuario);
	}
	
	public Usuario findById(Usuario usuario){
		usuario = usuarioDao.findByID(usuario);
		return usuario;
	}
	
	public Usuario findByLogin(Usuario usuario){
		usuario = usuarioDao.findByLogin(usuario);
		return usuario;
	}
}

