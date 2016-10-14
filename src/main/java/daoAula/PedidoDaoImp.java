package daoAula;

import org.hibernate.Session;

import Mdelo.Pedido;

public class PedidoDaoImp implements PedidoDao {
	
	private Session session;
	  
    public void setSession(Session session) {
        this.session = session;
    }
      
    public void save(Pedido pedido) {
        this.session.saveOrUpdate(pedido);
    }

}
