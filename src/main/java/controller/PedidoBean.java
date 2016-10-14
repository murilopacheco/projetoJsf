package controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Mdelo.EndereçoPessoa;
import Mdelo.Pedido;
import Mdelo.Pessoa;
import Mdelo.Produto;
import Mdelo.TelefonePessoa;
import negocio.PedidoNegocio;
import negocio.PessoaNegocio;


@ManagedBean(name="pedido")
@ViewScoped
public class PedidoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pedido pedido = null;
	private Set<Produto> produtos;
	
	
	@PostConstruct
	public void init(){
		pedido = new Pedido();
		produtos = new HashSet<Produto>();
		
	}
	
	public String salvar(){
		
			PedidoNegocio pedidoNegocio = new PedidoNegocio();
			
			Produto produto = new Produto();
			produto.setNome("produto4");
			produto.setQuantidade(10);;
			Produto produto2 = new Produto();
			produto2.setNome("produto5");
			produto2.setQuantidade(10);;
			Produto produto3 = new Produto();
			produto3.setNome("produto6");
			produto3.setQuantidade(10);
			produtos.add(produto);
			produtos.add(produto2);
			produtos.add(produto3);
			pedido.setProdutos(produtos);
			boolean salvo = false;
			salvo = pedidoNegocio.salvar(pedido);
			if(salvo == true){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Successful",  "Pedido salvo com sucesso!") );
   
		}
		return "pessoa recebido com sucesso" ;
		
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
	
}
