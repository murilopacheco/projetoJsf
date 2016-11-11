package daoAula;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;

import Mdelo.PerfilUsuario;

public class PerfilUsuarioDaoImp implements PerfilUsuarioDao {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	public void save(PerfilUsuario perfilUsuario) {
        this.session.saveOrUpdate(perfilUsuario);
    }
	
	public Set<PerfilUsuario> listaPerfis() {
		Set<PerfilUsuario> perfis = null;
		Criteria cri = session.createCriteria(PerfilUsuario.class);	
		List<PerfilUsuario> list = (List<PerfilUsuario>) cri.list();
		if(!list.isEmpty()){
		perfis = new HashSet<PerfilUsuario>(list);
		}
		return perfis;
	}
	

}
