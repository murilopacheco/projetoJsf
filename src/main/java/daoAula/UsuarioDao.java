package daoAula;

import Mdelo.Usuario;
import java.util.List;

public interface UsuarioDao {

	 public void save(Usuario usuario);
	 
	 public default List<Usuario> listaUsuarios(){
		 UsuarioDaoImp usuariodaoImp = new UsuarioDaoImp();
		 List<Usuario> usuarios = usuariodaoImp.listaUsuarios();
		 return usuarios;
	 }
	 
	 public void delete(Usuario usuario);
	 
	 public default Usuario findByID(Usuario usuario){
		 
		 return usuario;
	 }
	 
	 public default Usuario findByLogin(Usuario usuario){
		 
		 return usuario;
	 }
}
