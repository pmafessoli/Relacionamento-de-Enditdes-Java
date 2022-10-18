package br.com.projeto.exemplo03;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.projeto.exemplo03.modelo.AlunoModelo;
import br.com.projeto.exemplo03.modelo.CursoModelo;
import br.com.projeto.exemplo03.repositorio.AlunoRepositorio;
import br.com.projeto.exemplo03.repositorio.CursoRepositorio;

@SpringBootApplication
public class Exemplo03Application {

	public static void main(String[] args) {
		SpringApplication.run(Exemplo03Application.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(AlunoRepositorio ar, CursoRepositorio cr) {
		return args -> {

			// Criar um aluno
			AlunoModelo aluno = new AlunoModelo();
			aluno.setNome("Ralf");

			// Cadastrar na tabela alunos
			ar.save(aluno);

			// Criar três cursos
			CursoModelo c1 = new CursoModelo();
			c1.setNome("Java - Spring Boot");

			CursoModelo c2 = new CursoModelo();
			c2.setNome("Python - Flask");

			CursoModelo c3 = new CursoModelo();
			c3.setNome("PHP - Laravel");

			// Cadastrar os cursos na tabela cursos
			cr.saveAll(Arrays.asList(c1, c2, c3));

			// Adicionar os primeiro e o terceiro curso no aluno
			aluno.getCursos().addAll(Arrays.asList(c1, c3));

			// Atualizar a lista de cursos do aluno
			ar.save(aluno);
		};
	}

}
