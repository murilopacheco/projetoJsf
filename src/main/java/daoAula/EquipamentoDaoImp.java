package daoAula;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import Mdelo.Equipamento;

public class EquipamentoDaoImp implements EquipamentoDao {
	
	private Session session;
	  
    public void setSession(Session session) {
        this.session = session;
    }
      
    public void save(Equipamento equipamento) {
        this.session.saveOrUpdate(equipamento);
    }

    
    public List<Equipamento> listaEquipamentos() {
		List<Equipamento> equipamentos = null;
		Criteria cri = session.createCriteria(Equipamento.class);	
		List<Equipamento> list = (List<Equipamento>) cri.list();
		equipamentos = list;
		return equipamentos;
	}
}
