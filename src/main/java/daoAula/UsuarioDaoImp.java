package daoAula;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import Mdelo.Usuario;

public class UsuarioDaoImp implements UsuarioDao {
	
	private Session session;
	  
    public void setSession(Session session) {
        this.session = session;
    }
      
    @Override
    public void save(Usuario usuario) {
        this.session.saveOrUpdate(usuario);
    }
    

	public List<Usuario> listaUsuarios() {
		List<Usuario> usuarios = null;
		Criteria cri = session.createCriteria(Usuario.class);	
		List<Usuario> list = (List<Usuario>) cri.list();
		usuarios = list;
		return usuarios;
	}
	
	public void delete(Usuario usuario){
		this.session.delete(usuario);
	}
	
	public Usuario findById(Usuario usuario){
		Criteria cri = session.createCriteria(Usuario.class);	
		usuario = (Usuario) cri.list().get(0);
		return usuario;
	}
	
	public Usuario findByLogin(Usuario usuario){
		Criteria cri = session.createCriteria(Usuario.class).add(Restrictions.eq("login", usuario.getLogin()));	
		if(!cri.list().isEmpty()){
		usuario = (Usuario) cri.list().get(0);
		}
		else {
			usuario = null;
		}
		
		return usuario;
	}

}
