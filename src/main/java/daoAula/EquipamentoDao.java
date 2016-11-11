package daoAula;

import java.util.List;

import Mdelo.Equipamento;

public interface EquipamentoDao {
	
	public void save(Equipamento equipamento);
	
	public default List<Equipamento> listaEquipamentos(){
		 EquipamentoDaoImp equipamentoDaoImp = new EquipamentoDaoImp();
		 List<Equipamento> equipamentos = equipamentoDaoImp.listaEquipamentos();
		 return equipamentos;
	 }

}
