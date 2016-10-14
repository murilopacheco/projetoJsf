package Dao.utils;

import daoAula.PedidoDao;
import daoAula.PedidoDaoImp;
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
	public static PedidoDao createPedido(){
		PedidoDaoImp pedidoDaoImp = new PedidoDaoImp();
		pedidoDaoImp.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return pedidoDaoImp;
	}
}
