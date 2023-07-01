package br.inatel.labs.labrest_client;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.labs.labrest_client.model.dto.ProdutoDTO;
import ch.qos.logback.core.status.Status;

public class WebClientPutProduto {

	public static void main(String[] args)
	{
		ProdutoDTO produtoExistente=new ProdutoDTO();
		produtoExistente.setId(1l);
		produtoExistente.setDescricao("Furadeira a bateria");
		
		WebClient.create("http://localhost:8080")
		.put()
		.uri("/produto")
		.bodyValue(produtoExistente)
		.retrieve()
		.toBodilessEntity()
		.block();
		HttpStatusCode statusCode=responseEntity.getStatusCode();
		
		System.out.println("Status da resposta"+statusCode);
	}
	
	
	
	
	
}
