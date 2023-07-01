package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
@Entity
public class NotaCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@OneToMany(mappedBy = "notaCompra")
	private List<NotaCompraItem> notaCompraItem;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<NotaCompraItem> getNotaCompraItem() {
		return notaCompraItem;
	}
	public NotaCompra() {
		super();
	}
	
	
	public NotaCompra( LocalDate dataEmissao,Fornecedor fornecedo) {
		super();
		this.fornecedor = fornecedor;
		this.dataEmissao = dataEmissao;
	}

	@Override
	public String toString() {
		return "NotaCompra [id=" + id + ", dataEmissao=" + dataEmissao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaCompra other = (NotaCompra) obj;
		return id == other.id;
	}

	public void setNotaCompraItem(List<NotaCompraItem> notaCompraItem) {
		this.notaCompraItem = notaCompraItem;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	@ManyToOne
	private Fornecedor fornecedor;
	@NotNull
	@Past
	private LocalDate dataEmissao;
	
	public BigDecimal  getCalculoTotalItem() {
		
		BigDecimal total=this.notaCompraItem.stream()
				.map(i ->i.getCalculoTotalItem())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		return total;
	}

}
