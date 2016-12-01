package daoAula;

import java.util.List;

import Mdelo.Equipamento;
import Mdelo.Reserva;
import Mdelo.Usuario;

public interface ReservaDao {
	
	public void save(Reserva reserva);
	
	public default List<Reserva> listaReservasUsuario(Usuario usuario){
		 ReservaDaoImp reservaDaoImp = new ReservaDaoImp();
		 List<Reserva> reservas = reservaDaoImp.listaReservasUsuario(usuario);
		 return reservas;
	 }
	public default List<Reserva> listaReservasPorEquipamento(Equipamento equipamento, Reserva reserva){
		 ReservaDaoImp reservaDaoImp = new ReservaDaoImp();
		 List<Reserva> reservas = reservaDaoImp.listaReservasPorEquipamento(equipamento, reserva);
		 return reservas;
	 }

}
