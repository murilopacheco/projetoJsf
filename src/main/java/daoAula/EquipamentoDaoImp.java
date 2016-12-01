package daoAula;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import Mdelo.Equipamento;
import Mdelo.Reserva;

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
    
    public List<Equipamento> listaEquipamentosPorReserva(Reserva reserva) {
		List<Equipamento> equipamentos = null;
	//	Criteria cri = session.createCriteria(Equipamento.class).add(Restrictions.not(Restrictions.between("reserva.horaInicio", reserva.getHoraInicio(), reserva.getHoraFim())));	
	//	cri.add(Restrictions.not(Restrictions.eq("reserva.datareserva", reserva.getDataReserva())));
//		String hql = ("select  eq.* from equipamento eq " +
//				"inner join reserva r " +
//				"where eq.id = r.id_equipamento " +
//				"and not(r.dataReserva =   :data_reserva " +
//				"and "+ reserva.getHoraInicio() +" between r.horaInicio and r.horaFim);");
//				SQLQuery  q =  (SQLQuery) session.createSQLQuery(hql).setParameter("data_reserva", reserva.getDataReserva());
//				q.addEntity(Equipamento.class);
		String hql = ("Select distinct eq.* from equipamento eq " +
				"inner join reserva r " +
				"where eq.id = r.id_equipamento " +
				"and not(r.dataReserva = "  + ":reserva_data " +
				"and "+ ":reserva_hora" +" between r.horaInicio and r.horaFim)");
				
				SQLQuery  q =   session.createSQLQuery(hql);
				q.setParameter("reserva_data", reserva.getDataReserva());
				q.setParameter("reserva_hora", reserva.getHoraInicio());
				q.addEntity(Equipamento.class);
				List<Equipamento> list = (List<Equipamento>) q.list();
				
				
	//List<Equipamento> list = (List<Equipamento>) cri.list();
		equipamentos = list;
		return equipamentos;
	}
}
