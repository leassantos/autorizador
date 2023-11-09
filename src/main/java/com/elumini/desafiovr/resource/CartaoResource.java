package com.elumini.desafiovr.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elumini.desafiovr.entity.Cartao;
import com.elumini.desafiovr.entity.dto.CartaoRequestDTO;
import com.elumini.desafiovr.entity.dto.CartaoResponseDTO;
import com.elumini.desafiovr.entity.dto.SaldoResponseDTO;
import com.elumini.desafiovr.service.CartaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cartoes")
public class CartaoResource {
	
	private CartaoService cartaoService;
	
	public CartaoResource(CartaoService cartaoService) {
		this.cartaoService = cartaoService;
	}
	
	@PostMapping
	public ResponseEntity<CartaoResponseDTO> gerarCartao(@Valid @RequestBody CartaoRequestDTO cartaoRequestDTO) {
		CartaoResponseDTO cartaoGerado = cartaoService.gerarCartao(new Cartao(cartaoRequestDTO));
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(cartaoGerado);
	} 
	
	@GetMapping
	public List<CartaoResponseDTO> listarCartoes(){
		return cartaoService.listarCartoes();
	}
	
	@GetMapping(path="/{numeroCartao}")
	public ResponseEntity<SaldoResponseDTO> obterSaldoCartao(
			@Valid @PathVariable("numeroCartao") String numeroCartao) {
		SaldoResponseDTO saldo = cartaoService.obterSaldoCartao(numeroCartao);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(saldo);
	}
}
