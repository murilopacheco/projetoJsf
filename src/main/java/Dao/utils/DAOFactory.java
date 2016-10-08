package Dao.utils;

import daoAula.PessoaDao;
import daoAula.PessoaDaoImp;
import daoAula.UsuarioDao;
import daoAula.UsuarioDaoImp;

public class DAOFactory {
	
	public static UsuarioDao createUsuario(){
        UsuarioDaoImp usuarioDaoImp = new UsuarioDaoImp();
        usuarioDaoImp.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioDaoImp;
    }
	public static PessoaDao createPessoa(){
		PessoaDaoImp pessoaDaoImp = new PessoaDaoImp();
		pessoaDaoImp.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return pessoaDaoImp;
	}

}
