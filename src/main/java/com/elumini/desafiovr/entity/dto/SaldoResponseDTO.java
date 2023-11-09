package com.elumini.desafiovr.entity.dto;

import java.math.BigDecimal;

import com.elumini.desafiovr.entity.Saldo;

public class SaldoResponseDTO {
	private BigDecimal valor;
	
	public SaldoResponseDTO() {}
	
	public SaldoResponseDTO(Saldo saldo) {
		this.valor = saldo.getValorSaldo();
	}

	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
