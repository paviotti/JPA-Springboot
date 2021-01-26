package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String agencia;
	private String numero;
	private float saldo;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Pessoa> proprietarios;
	
	public Conta() {
		super();
	}

	public Conta(String agencia, String numero, float saldo, List<Pessoa> proprietarios) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.proprietarios = proprietarios;
	}

	public Long getId() {
		return id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public List<Pessoa> getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(List<Pessoa> proprietarios) {
		this.proprietarios = proprietarios;
	}
	
	

}
