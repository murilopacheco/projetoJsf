package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Mdelo.EndereçoPessoa;
import Mdelo.Pessoa;
import Mdelo.TelefonePessoa;
import negocio.PessoaNegocio;


@ManagedBean(name="pessoa")
@ViewScoped
public class PessoaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pessoa pessoa = null;
	private List<Pessoa> pessoas = null;
	private List<Pessoa> pessoasFiltradas = null;
	private EndereçoPessoa endereço = null;
	private TelefonePessoa telefone = null;
	private List<TelefonePessoa> telefones = null;
	
	@PostConstruct
	public void init(){
		pessoa = new Pessoa();
		endereço = new EndereçoPessoa();
		pessoas = this.listaPessoas();
		pessoa.setPessoas(pessoas);
		pessoa.setPessoasFiltradas(pessoas);
		telefone = new TelefonePessoa();
		telefones = new ArrayList<TelefonePessoa>();
		pessoa.setTelefones(telefones);
		
	}
	
	public String salvar(){
		if(pessoa.getNome() != null && !pessoa.getNome().equals("")){
			PessoaNegocio pessoaNegocio = new PessoaNegocio();
			boolean salvo = false;
			if(pessoa.getId() == 0){
			pessoa.setEndereço(endereço);
			pessoa.setTelefones(telefones);
			salvo = pessoaNegocio.salvar(pessoa);
			if(salvo == true){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Successful",  "Pesssoa salva com sucesso!") );
			   pessoas.add(pessoa);	
			}
			else{
				pessoa.setEndereço(endereço);
				salvo = pessoaNegocio.salvar(pessoa);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Successful",  "Pesssoa editada com sucesso!") );
			   pessoas = this.listaPessoas();	
			}
		}    
		}
		return "pessoa recebido com sucesso" + pessoa.getNome();
		
		
	}
	
	public void delete(Pessoa pessoa){
		if(pessoa != null){
		PessoaNegocio pessoaNegocio = new PessoaNegocio();
		pessoaNegocio.delete(pessoa);
		pessoas.remove(pessoa);
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null, new FacesMessage("Successo!",  "Usuario excluido com sucesso!") );
		}
	}
	public void editar(Pessoa pe){
		if(pessoa != null){
		PessoaNegocio pessoaNegocio = new PessoaNegocio();
		pessoa = pe;
		endereço = pe.getEndereço();
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null, new FacesMessage("Successo!",  "Usuario excluido com sucesso!") );
		}
	}
	
	public List<Pessoa> listaPessoas(){
		PessoaNegocio pessoaNegocio = new PessoaNegocio();
		pessoas = pessoaNegocio.listaPessoas();
		pessoasFiltradas = pessoas;
		
		return pessoas;
	}
	
	public void addTelefone(){
		telefones.add(telefone);
	}
	
	public void removerTelefone(TelefonePessoa telefone){
		telefones.remove(telefone);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Pessoa> getPessoasFiltradas() {
		return pessoasFiltradas;
	}

	public void setPessoasFiltradas(List<Pessoa> pessoasFiltradas) {
		this.pessoasFiltradas = pessoasFiltradas;
	}

	public EndereçoPessoa getEndereço() {
		return endereço;
	}

	public void setEndereço(EndereçoPessoa endereço) {
		this.endereço = endereço;
	}

	public TelefonePessoa getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefonePessoa telefone) {
		this.telefone = telefone;
	}

	public List<TelefonePessoa> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefonePessoa> telefones) {
		this.telefones = telefones;
	}
	
	
	
	
	
	
}
