package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Mdelo.Usuario;
import negocio.UsuarioNegocio;
import utils.GenerateMD5;
import utils.GenerateValidation;


@ManagedBean(name="usuario")
@ViewScoped
public class UsuarioBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario = null;
	private String message;
	private List<Usuario> usuarios = null; 
	private List<Usuario> usuariosFiltrados;
	
	
	@PostConstruct
	public void init(){
		usuario = new Usuario();
		usuarios = this.listaUsuarios();
		usuario.setUsuarios(usuarios);
		
	}
	
	public String salvar(){
		if(usuario.getLogin() != null && !usuario.getLogin().equals("")){
			usuario.setPassword(GenerateMD5.generate(usuario.getPassword()));
			usuario.setValidacao(GenerateValidation.keyValidation());
			usuario.setAtivo(false);
			UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
			boolean salvo = usuarioNegocio.salvar(usuario);
			if(salvo == true){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Successful",  "Usuario salvo com sucesso!") );
			    
			    
			   usuarios.add(usuario);	
		}    
		}
		return "usuario recebido com sucesso" + usuario.getLogin() +" " +  usuario.getEmail() + " " + usuario.getAtivo();
		
		
	}


	public List<Usuario> listaUsuarios(){
		UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
		usuarios = usuarioNegocio.listarUsuarios();
		usuariosFiltrados = usuarios;
		return usuarios;
	}
	
	public void delete(Usuario usuario){
		if(usuario != null){
		UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
		usuarioNegocio.delete(usuario);
		usuarios.remove(usuario);
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null, new FacesMessage("Successo!",  "Usuario excluido com sucesso!") );
		}
	}
	
	
	public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
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
