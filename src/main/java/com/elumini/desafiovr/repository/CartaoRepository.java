package com.elumini.desafiovr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elumini.desafiovr.entity.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Integer>{

	Optional<Cartao> findByNumeroCartao(String numeroCartao);
}
