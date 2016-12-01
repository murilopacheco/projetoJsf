package daoAula;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import Mdelo.Equipamento;
import Mdelo.Reserva;
import Mdelo.Usuario;

public class ReservaDaoImp implements ReservaDao {
	
	private Session session;
	  
    public void setSession(Session session) {
        this.session = session;
    }
      
    public void save(Reserva reserva) {
        this.session.saveOrUpdate(reserva);
    }

    
    public List<Reserva> listaReservasUsuario(Usuario usuario) {
		List<Reserva> reservas = null;
		Criteria cri = session.createCriteria(Reserva.class);
				cri.add(Restrictions.eq("usuario.id", usuario.getId()));	
		List<Reserva> list = (List<Reserva>) cri.list();
		reservas = list;
		return reservas;
	}
    public List<Reserva> listaReservasPorEquipamento(Equipamento equipamento, Reserva reserva) {
		List<Reserva> reservas = null;
		Criteria cri = session.createCriteria(Reserva.class);
				cri.add(Restrictions.eq("equipamento.id", equipamento.getId()));
				cri.add(Restrictions.eq("dataReserva", reserva.getDataReserva()));
//				cri.add(Restrictions.between("horaInicio", reserva.getHoraInicio(), reserva.getHoraFim()));
		List<Reserva> list = (List<Reserva>) cri.list();
		reservas = list;
		return reservas;
	}
}
