package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Mdelo.Usuario;

@ManagedBean
@SessionScoped
public class Index implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	   @PostConstruct
	   public void init(){
	      System.out.println("Bean executado!");
	      HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	      HttpServletRequest request = (HttpServletRequest) req;
	      HttpSession session = (HttpSession) request.getSession();
	      usuario = (Usuario) session.getAttribute("usuario");
	   }
	 
	   public String getMessage(){
	      return "Hello World JSF!";
	   }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	   
	   

}
