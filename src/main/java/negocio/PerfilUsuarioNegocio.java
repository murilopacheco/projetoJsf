package negocio;

import java.util.Set;

import Dao.utils.DAOFactory;
import Mdelo.PerfilUsuario;
import daoAula.PerfilUsuarioDao;

public class PerfilUsuarioNegocio {
	
	private PerfilUsuarioDao perfilUsuarioDao;

	public PerfilUsuarioNegocio() {
		super();
		// TODO Auto-generated constructor stub
		setPerfilUsuarioDao(DAOFactory.createPerfil());
	}

	public boolean salvar(PerfilUsuario perfilUsuario){
		perfilUsuarioDao.save(perfilUsuario);
		return true;
	}
	
	public Set<PerfilUsuario> listaPerfis() {
		Set<PerfilUsuario> perfis = null;
		perfis = perfilUsuarioDao.listaPerfis();
		return perfis;
	}
	public PerfilUsuarioDao getPerfilUsuarioDao() {
		return perfilUsuarioDao;
	}

	public void setPerfilUsuarioDao(PerfilUsuarioDao perfilUsuarioDao) {
		this.perfilUsuarioDao = perfilUsuarioDao;
	}
	
	

}
