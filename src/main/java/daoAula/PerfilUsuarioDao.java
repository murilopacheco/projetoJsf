package daoAula;

import java.util.Set;

import Mdelo.PerfilUsuario;

public interface PerfilUsuarioDao {
	
	public void save(PerfilUsuario perfilUsuario);
	
	public default Set<PerfilUsuario> listaPerfis(){
		Set<PerfilUsuario> perfis = null;
		PerfilUsuarioDaoImp perfilUsuarioDaoImp = new PerfilUsuarioDaoImp();
		perfis = perfilUsuarioDaoImp.listaPerfis();
		 return perfis;
	 }

}
