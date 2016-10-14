package Mdelo;



import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NaturalId;
import Mdelo.Produto;

@Entity
@Table(name="pedido")
public class Pedido {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	private Date dataPedido;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name="itens_pedidos", joinColumns=
 	{@JoinColumn(name="pedido_id")}, inverseJoinColumns=
   {@JoinColumn(name="produto_id")})
	private Set<Produto> produtos;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDataPedido() {
		return dataPedido;
	}


	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}


	public Set<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}


	
}
