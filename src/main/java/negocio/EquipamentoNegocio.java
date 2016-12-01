package negocio;

import java.util.List;

import Dao.utils.DAOFactory;
import Mdelo.Equipamento;
import Mdelo.Reserva;
import daoAula.EquipamentoDao;

public class EquipamentoNegocio {
	
private EquipamentoDao equipamentoDao;
	
	public EquipamentoNegocio() {
		// TODO Auto-generated constructor stub
		super();
		setEquipamentoDao(DAOFactory.createEquipamento());
	}
	
	public boolean salvar(Equipamento equipamento){
		equipamentoDao.save(equipamento);
		return true;
	}
	
	public List<Equipamento> listaEquipamentos() {
		List<Equipamento> equipamentos = null;
		equipamentos = equipamentoDao.listaEquipamentos();
		return equipamentos;
	}
	public List<Equipamento> listaEquipamentosPorReserva(Reserva reserva) {
		List<Equipamento> equipamentos = null;
		equipamentos = equipamentoDao.listaEquipamentosPorReserva(reserva);
		return equipamentos;
	}

	public EquipamentoDao getEquipamentoDao() {
		return equipamentoDao;
	}

	public void setEquipamentoDao(EquipamentoDao equipamentoDao) {
		this.equipamentoDao = equipamentoDao;
	}



}
