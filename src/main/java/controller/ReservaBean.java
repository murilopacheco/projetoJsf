package controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.SelectEvent;

import Mdelo.Equipamento;
import Mdelo.Reserva;
import Mdelo.Usuario;
import negocio.EquipamentoNegocio;
import negocio.ReservaNegocio;

@ManagedBean(name = "reserva")
@SessionScoped
public class ReservaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Reserva reserva = null;

	private List<Equipamento> equipamentos;
	private List<Equipamento> equipamentosFiltrados;
	private List<Equipamento> equipamentosSelecionados;
	private List<Equipamento> equipamentosLivres;
	private Usuario usuario = null;
	private List<Reserva> reservas;
	private List<Reserva> reservasFiltradas;
	private Date dataMinima;
	private Date dataMaxima;
	private Date dataSelecionada;
	

	public List<Reserva> getReservasFiltradas() {
		return reservasFiltradas;
	}

	public void setReservasFiltradas(List<Reserva> reservasFiltradas) {
		this.reservasFiltradas = reservasFiltradas;
	}

	@PostConstruct
	public void init() {
		dataMinima = new Date();
		dataMaxima =  this.dataMaximaParaReserva();
		this.usuario = recuperarrUsuarioSessão();
		reserva = new Reserva();
		equipamentos = new ArrayList<Equipamento>();
		equipamentosSelecionados = new ArrayList<Equipamento>();
		reservas = new ArrayList<Reserva>();
		reservas = listaReservasUsuario();
		reservasFiltradas = reservas;
		// equipamentosFiltrados = new ArrayList<Equipamento>();
		// equipamentos = this.listaEquipamentos();
		// equipamentosFiltrados = equipamentos;

	}

	public String salvar() {
		String navegacao = "";
		if (usuario != null) {
			ReservaNegocio reservaNegocio = new ReservaNegocio();
			List<Reserva> reservas = new ArrayList<Reserva>();
			Reserva reserva1 = null;
			
			for (Equipamento equipamento : equipamentosSelecionados) {
				reserva1 = new Reserva();
				reserva1.setHoraInicio(this.SetarDataHoraReserva(reserva ,reserva.getHoraInicio()));
				reserva1.setHoraFim(this.SetarDataHoraReserva(reserva, reserva.getHoraFim()));
//				reserva1.setHoraInicio(reserva.getHoraInicio());
//				reserva1.setHoraFim(reserva.getHoraFim());
				reserva1.setDataReserva(reserva.getDataReserva());
				reserva1.setEquipamento(equipamento);
				reserva1.setUsuario(usuario);
				reservas.add(reserva1);
			}
			boolean salvo = false;
			for (Reserva reserva : reservas) {
				salvo = reservaNegocio.salvar(reserva);
			}

			if (salvo == true) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Successful", "Reserva efetuada com sucesso!"));
				equipamentosLivres = this.listaEquipamentosPorReserva();
				reserva = new Reserva();

			}
		}else{
			navegacao = "/public/login.jsf";
			}

		return navegacao;

	}

	public void Delete(Equipamento equipamento) {
		String teste;
	}

	public List<Equipamento> listaEquipamentos() {
		EquipamentoNegocio equipamentoNegocio = new EquipamentoNegocio();
		equipamentos = equipamentoNegocio.listaEquipamentos();
		if (!equipamentos.isEmpty() && equipamentos != null) {
			for (Equipamento equipamento : equipamentos) {
				Reserva reserva1 = new Reserva();
				List<Reserva> reservasList = new ArrayList<Reserva>();
				reservasList = equipamento.getReservas();
			//	if (!equipamento.getReserva().isEmpty() && equipamento.getReserva() != null) {
					for (Reserva reservaList : equipamento.getReservas()) {
						reservaList.setHoraInicio(this.SetarDataHoraReserva(reservaList ,reservaList.getHoraInicio()));
						reservaList.setHoraFim(this.SetarDataHoraReserva(reservaList, reservaList.getHoraFim()));
						if((reservaList.getHoraInicio().compareTo(reserva.getHoraInicio()) >= 0) && (reservaList.getHoraInicio().compareTo(reserva.getHoraFim()) >= 0)){
							String teste = "";
						}
					//}
				}

			}
		}
		equipamentosFiltrados = equipamentos;

		return equipamentos;
	}
	
	public List<Equipamento> listaEquipamentosPorReserva() {
		reserva.setHoraInicio(this.SetarDataHoraReserva(reserva, reserva.getHoraInicio()));
		reserva.setHoraFim(this.SetarDataHoraReserva(reserva, reserva.getHoraFim()));
		EquipamentoNegocio equipamentoNegocio = new EquipamentoNegocio();
		ReservaNegocio reservaNegocio = new ReservaNegocio();
		// equipamentos =
		// equipamentoNegocio.listaEquipamentosPorReserva(reserva);
		equipamentos = equipamentoNegocio.listaEquipamentos();
		equipamentosLivres = new ArrayList<Equipamento>();
		if (!equipamentos.isEmpty() && equipamentos != null) {
			for (Equipamento equipamento : equipamentos) {
				List<Reserva> reservasList = new ArrayList<Reserva>();
				reservasList = reservaNegocio.listaReservasPorEquipamento(equipamento, reserva);
				if (!reservasList.isEmpty() && reservasList != null) {
					for (Reserva reservaL : reservasList) {
						reservaL.setHoraInicio(this.SetarDataHoraReserva(reservaL, reservaL.getHoraInicio()));
						reservaL.setHoraFim(this.SetarDataHoraReserva(reservaL, reservaL.getHoraFim()));
//						if (((reserva.getHoraInicio().equals(reservaL.getHoraInicio())
//								|| (reserva.getHoraInicio().after(reservaL.getHoraInicio())))
//								&& ((reserva.getHoraFim().equals(reservaL.getHoraInicio())
//										|| (reserva.getHoraFim().before(reservaL.getHoraInicio())))))) {
						if(
								(reserva.getHoraInicio().equals(reservaL.getHoraInicio())
										|| reserva.getHoraInicio().after(reservaL.getHoraInicio()))
								&& ((reserva.getHoraFim().equals(reservaL.getHoraFim())
										|| reserva.getHoraFim().after(reservaL.getHoraFim())))
								){
							//equipamento está na lista..
						}else{
							this.adicionarEquipamentoDisponivel(equipamento);
						}

					}

				}else{
					this.adicionarEquipamentoDisponivel(equipamento);
				}
			}
		}
		equipamentosFiltrados = equipamentos;

		return equipamentosLivres;
	}
	
	public List<Reserva> listaReservasUsuario() {
		ReservaNegocio reservaNegocio = new ReservaNegocio();
		reservas = reservaNegocio.listaReservasUsuario(usuario);

		return reservas;
	}

	public Usuario recuperarrUsuarioSessão() {
		usuario = new Usuario();
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		usuario = (Usuario) session.getAttribute("usuario");
		return usuario;
	}
	public Date dataMaximaParaReserva(){
		dataMaxima = new Date();
		Calendar c =  Calendar.getInstance();
		c.setTime(dataMaxima); 
		c.set(Calendar.DAY_OF_MONTH,c.get(Calendar.DAY_OF_MONTH)+7);
		
		return c.getTime();
	}
	
	public String formatahora(Date data){
		SimpleDateFormat dataFormatada = new SimpleDateFormat("hh:mm");
		String horas = null;
		horas = dataFormatada.format(data);
		return horas;
	}
	
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dataSelecionada = (Date) event.getObject();
       }
	
	public Date SetarDataHoraReserva(Reserva reserva , Date hora){
		Calendar c =  Calendar.getInstance();
		c.setTime(reserva.getDataReserva());
		int ano = c.get(Calendar.YEAR);
		int mes = c.get(Calendar.MONTH);
		int dia = c.get(Calendar.DAY_OF_MONTH);
		
		c.setTime(hora);
		int horaDoDia = c.get(Calendar.HOUR_OF_DAY);
		int minuto = c.get(Calendar.MINUTE);
		c.set(Calendar.YEAR, ano);
		c.set(Calendar.MONTH, mes);
		c.set(Calendar.DAY_OF_MONTH, dia);
		c.set(Calendar.HOUR_OF_DAY, horaDoDia);
		c.set(Calendar.MINUTE, minuto);
		
		hora = c.getTime();
		
		
		return hora;
	}

	public void adicionarEquipamentoDisponivel(Equipamento equipamento) {
		boolean equipamentoNaLista = false;
		if (equipamentosLivres != null && !equipamentosLivres.isEmpty()) {
			for (Equipamento equipamentoLivre : equipamentosLivres) {
				if (equipamentoLivre.getTipo() == equipamento.getTipo()) {
					equipamentoNaLista = true;
				}
			}
				if (!equipamentoNaLista) {
					equipamentosLivres.add(equipamento);
				}
			
		}else{
			equipamentosLivres.add(equipamento);
		}

	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public List<Equipamento> getEquipamentosFiltrados() {
		return equipamentosFiltrados;
	}

	public void setEquipamentosFiltrados(List<Equipamento> equipamentosFiltrados) {
		this.equipamentosFiltrados = equipamentosFiltrados;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Equipamento> getEquipamentosSelecionados() {
		return equipamentosSelecionados;
	}

	public void setEquipamentosSelecionados(List<Equipamento> equipamentosSelecionados) {
		this.equipamentosSelecionados = equipamentosSelecionados;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Date getDataMinima() {
		return dataMinima;
	}

	public void setDataMinima(Date dataMinima) {
		this.dataMinima = dataMinima;
	}

	public Date getDataMaxima() {
		return dataMaxima;
	}

	public void setDataMaxima(Date dataMaxima) {
		this.dataMaxima = dataMaxima;
	}

	public Date getDataSelecionada() {
		return dataSelecionada;
	}

	public void setDataSelecionada(Date dataSelecionada) {
		this.dataSelecionada = dataSelecionada;
	}

	public List<Equipamento> getEquipamentosLivres() {
		return equipamentosLivres;
	}

	public void setEquipamentosLivres(List<Equipamento> equipamentosLivres) {
		this.equipamentosLivres = equipamentosLivres;
	}
	
	

}
