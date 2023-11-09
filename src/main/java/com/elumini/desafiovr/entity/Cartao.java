package com.elumini.desafiovr.entity;

import java.time.LocalDate;

import com.elumini.desafiovr.entity.dto.CartaoRequestDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="cartao")
public class Cartao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="numero_cartao")
	@NotNull
	private String numeroCartao;
	
	@Column(name="senha_cartao")
	@NotNull
	private String senhaCartao;
	
	@Column(name="data_criacao")
	private LocalDate dataCriacaoCartao;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_saldo", referencedColumnName="id")
	private Saldo saldo;
	
	public Cartao() {
	}
	
	public Cartao(CartaoRequestDTO cartaoRequestDTO) {
		this.numeroCartao = cartaoRequestDTO.getNumeroCartao();
		this.senhaCartao = cartaoRequestDTO.getSenhaCartao();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getSenhaCartao() {
		return senhaCartao;
	}
	public void setSenhaCartao(String senhaCartao) {
		this.senhaCartao = senhaCartao;
	}

	public LocalDate getDataCriacaoCartao() {
		return dataCriacaoCartao;
	}
	public void setDataCriacaoCartao(LocalDate dataCriacaoCartao) {
		this.dataCriacaoCartao = dataCriacaoCartao;
	}

	public Saldo getSaldo() {
		return saldo;
	}
	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}
}
