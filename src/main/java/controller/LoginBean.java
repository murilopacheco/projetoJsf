package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Mdelo.Usuario;
import negocio.UsuarioNegocio;
import utils.GenerateMD5;

@ManagedBean(name="login")
@SessionScoped
public class LoginBean implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario = null;
	
	private List<Usuario> usuarios = null; 
	private List<Usuario> usuariosFiltrados;
	
	
	@PostConstruct
	public void init(){
		usuario = new Usuario();
		usuario.setUsuarios(usuarios);
	}
	
	public String login() throws IOException{
		String navegacao = null;
		UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
		Usuario usuarioBanco = new Usuario();
		usuarioBanco = null;
		usuario.setPassword(GenerateMD5.generate(usuario.getPassword()));
		usuarioBanco = usuarioNegocio.findByLogin(usuario);
		if(usuarioBanco == null){
			FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                "Erro no Login!"));
		}else{
			
		if(usuarioBanco.getLogin().equals(usuario.getLogin())){
			if(usuarioBanco.getPassword().equals(usuario.getPassword())){
				FacesContext fc = FacesContext.getCurrentInstance();
				HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
				session.setAttribute("usuario", usuarioBanco);
				navegacao = "/public/index.xhtml?faces-redirect=true";
			}
			else{
				FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha incorreta!",
                                    "Erro no Login!"));
			}
		}
		}
		usuarioBanco = null;
		return navegacao;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}

	public void setUsuariosFiltrados(List<Usuario> usuariosFiltrados) {
		this.usuariosFiltrados = usuariosFiltrados;
	}
	
	

}
