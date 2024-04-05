package br.com.vainaweb.escolat2.repository;

import br.com.vainaweb.escolat2.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
