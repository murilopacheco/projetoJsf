package negocio;

import java.util.List;

import Dao.utils.DAOFactory;
import Mdelo.Equipamento;
import Mdelo.Reserva;
import Mdelo.Usuario;
import daoAula.EquipamentoDao;
import daoAula.ReservaDao;

public class ReservaNegocio {
	
private ReservaDao reservaDao;
	
	public ReservaNegocio() {
		// TODO Auto-generated constructor stub
		super();
		setReservaDao(DAOFactory.createReserva());
	}
	
	public boolean salvar(Reserva reserva){
		reservaDao.save(reserva);
		return true;
	}
	
	public List<Reserva> listaReservasUsuario(Usuario usuario) {
		List<Reserva> reservas = null;
		reservas = reservaDao.listaReservasUsuario(usuario);
		return reservas;
	}
	
	public List<Reserva> listaReservasPorEquipamento(Equipamento equipamento, Reserva reserva) {
		List<Reserva> reservas = null;
		reservas = reservaDao.listaReservasPorEquipamento( equipamento,  reserva);
		return reservas;
	}

	public ReservaDao getReservaDao() {
		return reservaDao;
	}

	public void setReservaDao(ReservaDao reservaDao) {
		this.reservaDao = reservaDao;
	}

	



}
