package br.inatel.labs.labjpa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.Fornecedor;
import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.service.FornecedorService;
import br.inatel.labs.labjpa.service.ProdutoService;
import br.inatel.labs.labjpa.service.notaCompraService;

@SpringBootTest
class DataLoader {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private FornecedorService fornecedorService;
	@Autowired
	private notaCompraService notaCompraService;
	
	
	
	@Test
	void load() {
		
		Produto p1=new Produto("Furadeira");
		Produto p2=new Produto("Lixadeira");
		Produto p3=new Produto("Plaina");
		Produto p4=new Produto("Tupia");
		Produto p5=new Produto("Serra Circular");
		
		p1=produtoService.salvar(p1);
		p2=produtoService.salvar(p2);
		p3=produtoService.salvar(p3);
		p4=produtoService.salvar(p4);
		p5=produtoService.salvar(p5);
		
		List<Produto> produtos=produtoService.listar();
		produtos.forEach(System.out::println);
		
		Fornecedor f1=new Fornecedor("Gasômetro Madeiras");
		Fornecedor f2=new Fornecedor("Loja do Mecânico");
		f1=fornecedorService.salvar(f1);
		f2=fornecedorService.salvar(f2);
		
		List<Fornecedor>fornecedores=fornecedorService.listar();
		fornecedores.forEach(System.out::println);
		
		NotaCompra nc1= new NotaCompra(LocalDate.of(2021,1,15),f1);
		nc1=notaCompraService.salvarNotaCompra(nc1);
		NotaCompra nc2= new NotaCompra(LocalDate.of(2021,1,15),f2);
		nc1=notaCompraService.salvarNotaCompra(nc1);
		
		notaCompraService.listarNotaCompra().forEach(System.out::println);
		
		NotaCompraItem i1_1=new NotaCompraItem(nc1,p1,new BigDecimal("300.00"),2);
		i1_1=notaCompraService.salvarNotaCompraItem(i1_1);
		
		notaCompraService.listaNotaCompraItem().forEach(System.out::println);
		
	}

}
