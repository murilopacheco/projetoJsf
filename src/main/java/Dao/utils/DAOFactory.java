package Dao.utils;

import daoAula.EquipamentoDao;
import daoAula.EquipamentoDaoImp;
import daoAula.PedidoDao;
import daoAula.PedidoDaoImp;
import daoAula.PerfilUsuarioDao;
import daoAula.PerfilUsuarioDaoImp;
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
	
	public static PerfilUsuarioDao createPerfil(){
		PerfilUsuarioDaoImp perfilUsuarioDaoImp = new PerfilUsuarioDaoImp();
		perfilUsuarioDaoImp.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return perfilUsuarioDaoImp;
	}
	
	public static EquipamentoDao createEquipamento(){
		EquipamentoDaoImp equipamentoDaoImp = new EquipamentoDaoImp();
		equipamentoDaoImp.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return equipamentoDaoImp;
	}
}
