package negocio;

import Dao.utils.DAOFactory;
import Mdelo.Pedido;
import daoAula.PedidoDao;

public class PedidoNegocio {
	
	private PedidoDao pedidoDao;
	
	public PedidoNegocio() {
		super();
		setPedidoDao(DAOFactory.createPedido());
	}
	
	public boolean salvar(Pedido pedido){
		pedidoDao.save(pedido);
		return true;
	}

	public PedidoDao getPedidoDao() {
		return pedidoDao;
	}

	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}
	
	
	
	
}
