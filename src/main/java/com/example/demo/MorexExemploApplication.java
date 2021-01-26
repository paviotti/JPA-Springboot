package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MorexExemploApplication {

	private static final Logger Log = LoggerFactory.getLogger(MorexExemploApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MorexExemploApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PessoaRepository repository, ContaRepository cRepository) {
		
		return (args) -> {
			//codigo de teste
			Pessoa pessoinha  = new Pessoa("Jéssica", "325.668.895-2", "10/10/2001","Capivari"); 
			repository.save(pessoinha);
			repository.save(new Pessoa("Joselina","345.555.234-4", "06/06/1977","Corumbataí"));
			repository.save(new Pessoa("Jorge","222.658.458-4","02/10/1963","Capivari"));
			repository.save(new Pessoa("Josenilda","453.265.568-5","01/02/1991","Alegre"));
			
			Log.info("------ DEMONSTRAÇÃO ---------");
			Log.info("Pessoas encontradas con findALL()");
			Log.info("-----------------------------");
			
			for(Pessoa p: repository.findAll()) {
				Log.info("Nome: " + p.getNome() + " é de " + p.getCidade());
			}
			
			Log.info("---------- FIM ---------");
			
			//busca por pessoas de uma cidade
			Log.info("Pessoas da cidade de Capivari");
			Log.info("-----------------------------");
			//precisa inserir na classe PessoaRepository
			for(Pessoa pessoa : repository.findByCidade("Capivari")) {
				Log.info("Nome: " + pessoa.getNome() + " é de " + pessoa.getCidade());
				
			}
			Log.info("---------- FIM ---------");
			
			//criar uma conta conjunta de duas pessoas já cdastradas
			List<Pessoa> props = new ArrayList<>();
			props.add((Pessoa) repository.findByCpf("345.555.234-4")); //Joselina
			props.add( repository.findByCpf("222.658.458-4")); //jorge
			
			cRepository.save(new Conta("123-4", "5699-9", 251000, props)); //adiciona os dois proprietarios a conta
			Log.info(" O numero da conta é: " + cRepository.findByProprietariosCpf("345.555.234-4").getNumero()); //imprime o numero da conta
			
		};
	}
		

}
