package com.elumini.desafiovr.exception;

import java.time.LocalDateTime;

public class DetalheErros {
	private LocalDateTime dataHora;
	private String mensagem;
	private String detalhes;
	
	public DetalheErros(LocalDateTime dataHora, String mensagem, String detalhes) {
		super();
		this.dataHora = dataHora;
		this.mensagem = mensagem;
		this.detalhes = detalhes;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getDetalhes() {
		return detalhes;
	}
}
