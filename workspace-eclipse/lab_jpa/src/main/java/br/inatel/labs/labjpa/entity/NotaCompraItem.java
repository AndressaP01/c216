package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
@Entity
public class NotaCompraItem {
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	

	public NotaCompraItem() {
		super();
	}



	public NotaCompraItem(NotaCompra notaCompra, Produto produto, @NotNull @Positive BigDecimal valorCampraProduto,
			@NotNull @Positive Integer quantidade) {
		super();
		this.notaCompra = notaCompra;
		this.produto = produto;
		this.valorCampraProduto = valorCampraProduto;
		this.quantidade = quantidade;
	}



	@Override
	public String toString() {
		return "NotaCompraItem [id=" + id + ", valorCampraProduto=" + valorCampraProduto + ", quantidade=" + quantidade
				+ "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaCompraItem other = (NotaCompraItem) obj;
		return id == other.id;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public NotaCompra getNotaCompra() {
		return notaCompra;
	}


	public void setNotaCompra(NotaCompra notaCompra) {
		this.notaCompra = notaCompra;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public BigDecimal getValorCampraProduto() {
		return valorCampraProduto;
	}


	public void setValorCampraProduto(BigDecimal valorCampraProduto) {
		this.valorCampraProduto = valorCampraProduto;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private NotaCompra notaCompra;
	@ManyToOne
	private Produto produto;
	@NotNull
	@Positive
	private BigDecimal valorCampraProduto;
	@NotNull
	@Positive
	private Integer quantidade=1;
	
	
	public BigDecimal getCalculoTotalItem() {
		return valorCampraProduto.multiply(BigDecimal.valueOf(quantidade));
	}
}
