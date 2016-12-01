package daoAula;

import java.util.List;

import Mdelo.Equipamento;
import Mdelo.Reserva;

public interface EquipamentoDao {
	
	public void save(Equipamento equipamento);
	
	public default List<Equipamento> listaEquipamentos(){
		 EquipamentoDaoImp equipamentoDaoImp = new EquipamentoDaoImp();
		 List<Equipamento> equipamentos = equipamentoDaoImp.listaEquipamentos();
		 return equipamentos;
	 }
	
	public default List<Equipamento> listaEquipamentosPorReserva(Reserva reserva){
		 EquipamentoDaoImp equipamentoDaoImp = new EquipamentoDaoImp();
		 List<Equipamento> equipamentos = equipamentoDaoImp.listaEquipamentosPorReserva(reserva);
		 return equipamentos;
	 }

}
