package com.example.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//precisa extender a interface JpaRepository
//public interface PessoaRepository extends JpaRepository<T, ID> { T= classe Pessoa e ID = Long 
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	//buscdores personailzados
	public List<Pessoa> findByNome(String nome);
	public List<Pessoa> findByCidade(String cidade);
	public Pessoa findByCpf(String cpf); //cpf é único, retorna uma única pessoa

}
