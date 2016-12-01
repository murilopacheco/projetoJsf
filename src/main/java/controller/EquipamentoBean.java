package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Mdelo.Equipamento;
import negocio.EquipamentoNegocio;

@ManagedBean(name="equipamento")
@ViewScoped
public class EquipamentoBean {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Equipamento equipamento = null;
//	private Set<Equipamento> equipamentos ;
	private List<Equipamento> equipamentos;
//	private Set<Equipamento> equipamentosFiltrados ;
	private List<Equipamento> equipamentosFiltrados;
	
	
	@PostConstruct
	public void init(){
		equipamento = new Equipamento();
//		equipamentos = new HashSet<Equipamento>();
		equipamentos = new ArrayList<Equipamento>();
		equipamentosFiltrados = new ArrayList<Equipamento>();
		equipamentos = this.listaEquipamentos();
		equipamentosFiltrados = equipamentos;
		
	}
	
	public String salvar(){
			EquipamentoNegocio equipamentoNegocio = new EquipamentoNegocio();
			
			boolean salvo = false;
			if(equipamento.getId() == 0){
			salvo = equipamentoNegocio.salvar(equipamento);
			if(salvo == true){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Successful",  "equipamento salvo com sucesso!") );
				equipamentos.add(equipamento);
				equipamento = new Equipamento();
			}
			}else{
				salvo = equipamentoNegocio.salvar(equipamento);
				if(salvo == true){
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Successful",  "equipamento editado com sucesso!") );
					equipamento = new Equipamento();
			}
				
   
		}
		return "" ;
		
	}
	public void Editar(Equipamento equipamentoTela){
		equipamento = equipamentoTela;
	}
	
	public List<Equipamento> listaEquipamentos(){
		EquipamentoNegocio equipamentoNegocio = new EquipamentoNegocio();
		equipamentos = equipamentoNegocio.listaEquipamentos();
		equipamentosFiltrados = equipamentos;
		
		return equipamentos;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
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


	
	
}
