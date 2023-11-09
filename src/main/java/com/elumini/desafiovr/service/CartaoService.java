package com.elumini.desafiovr.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.elumini.desafiovr.entity.Cartao;
import com.elumini.desafiovr.entity.Saldo;
import com.elumini.desafiovr.entity.dto.CartaoResponseDTO;
import com.elumini.desafiovr.entity.dto.SaldoResponseDTO;
import com.elumini.desafiovr.exception.EntityBusinessException;
import com.elumini.desafiovr.exception.EntidadeExistenteException;
import com.elumini.desafiovr.exception.EntidadeNaoEncontradaException;
import com.elumini.desafiovr.repository.CartaoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartaoService {

	private CartaoRepository cartaoRepository;
	
	public CartaoService(CartaoRepository cartaoRepository) {
		this.cartaoRepository = cartaoRepository;
	}

	public CartaoResponseDTO gerarCartao(Cartao cartao) {
		this.validarDuplicidadeCartao(cartao);
		
		try {			
			Saldo saldo = new Saldo();
			saldo.setValorSaldo(new BigDecimal(500));
			
			cartao.setSaldo(saldo);
			cartao.setDataCriacaoCartao(LocalDate.now());
			
			Cartao cartaoGerado = cartaoRepository.save(cartao);
			
			return new CartaoResponseDTO(cartaoGerado);
		}catch(Exception ex) {
			throw new EntityBusinessException("Erro na criação do cartão!");
		}
	}
	
	private void validarDuplicidadeCartao(Cartao cartao) {
		cartaoRepository
				.findByNumeroCartao(cartao.getNumeroCartao())
				.ifPresent(cartaoDuplicado ->{
					throw new EntidadeExistenteException("O número do cartão já existe!");
				});
	}
	
	public List<CartaoResponseDTO> listarCartoes(){
		return cartaoRepository.findAll().stream().map(cartao ->{
			return new CartaoResponseDTO(cartao);
		}).collect(Collectors.toList());
	}

	public SaldoResponseDTO obterSaldoCartao(String numeroCartao) {
		 Cartao cartao = cartaoRepository
				 .findByNumeroCartao(numeroCartao)
				 .orElseThrow(() -> new EntidadeNaoEncontradaException("Cartão " + numeroCartao + " não encontrado!"));
		 
		 return new SaldoResponseDTO(cartao.getSaldo());
	}
}
