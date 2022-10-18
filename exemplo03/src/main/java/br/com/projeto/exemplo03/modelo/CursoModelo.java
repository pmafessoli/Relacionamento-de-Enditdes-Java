package br.com.projeto.exemplo03.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cursos")
@Getter
@Setter
public class CursoModelo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long codigo;
  private String nome;

  @ManyToMany(mappedBy = "cursos")
  private List<AlunoModelo> alunos = new ArrayList<>();

}
