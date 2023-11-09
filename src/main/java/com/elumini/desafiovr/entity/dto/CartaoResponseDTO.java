package com.elumini.desafiovr.entity.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.elumini.desafiovr.entity.Cartao;

public class CartaoResponseDTO {
	private String numeroCartao;
	private BigDecimal saldo;
	private LocalDate dataCriacao;
	
	public CartaoResponseDTO(Cartao cartao) {
		this.numeroCartao = cartao.getNumeroCartao();
		this.dataCriacao = cartao.getDataCriacaoCartao();
		this.saldo = cartao.getSaldo().getValorSaldo();
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
