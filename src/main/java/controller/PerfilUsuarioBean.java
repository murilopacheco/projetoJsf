package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Mdelo.PerfilUsuario;
import negocio.PerfilUsuarioNegocio;

@ManagedBean(name = "perfilUsuario")
@ViewScoped
public class PerfilUsuarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PerfilUsuario perfilUsuario = null;
	private Set<PerfilUsuario> perfis = new HashSet<PerfilUsuario>(0);
	private List<PerfilUsuario> perfisFiltrados = new ArrayList<PerfilUsuario>();
	private List<PerfilUsuario> perfisList;

	@PostConstruct
	public void init() {
		perfilUsuario = new PerfilUsuario();
		perfis = this.listaPerfis();
		perfisList = new ArrayList<PerfilUsuario>(perfis);
		perfisFiltrados = new ArrayList<PerfilUsuario>(perfis);
	}

	public String salvar() {
		PerfilUsuarioNegocio perfilUsuarioNegocio = new PerfilUsuarioNegocio();

		boolean salvo = false;
		salvo = perfilUsuarioNegocio.salvar(perfilUsuario);
		if (salvo == true) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Successful", "pefil salvo com sucesso!"));
			perfis.add(perfilUsuario);
			perfisList.add(perfilUsuario);
		}
		return "pessoa recebido com sucesso";

	}

		public Set<PerfilUsuario> listaPerfis() {
		PerfilUsuarioNegocio perfilUsuarioNegocio = new PerfilUsuarioNegocio();	
		perfis = perfilUsuarioNegocio.listaPerfis();
		
		return perfis;
	}
		
		public void delete(PerfilUsuario perfilUsuario){
			// TODO Auto-generated constructor stub
		}

		public PerfilUsuario getPerfilUsuario() {
			return perfilUsuario;
		}

		public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
			this.perfilUsuario = perfilUsuario;
		}

		public Set<PerfilUsuario> getPerfis() {
			return perfis;
		}

		public void setPerfis(Set<PerfilUsuario> perfis) {
			this.perfis = perfis;
		}


		public List<PerfilUsuario> getPerfisFiltrados() {
			return perfisFiltrados;
		}

		public void setPerfisFiltrados(List<PerfilUsuario> perfisFiltrados) {
			this.perfisFiltrados = perfisFiltrados;
		}

		public List<PerfilUsuario> getPerfisList() {
			return perfisList;
		}

		public void setPerfisList(List<PerfilUsuario> perfisList) {
			this.perfisList = perfisList;
		}
		
		
}
