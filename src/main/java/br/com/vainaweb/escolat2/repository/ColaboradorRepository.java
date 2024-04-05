package br.com.vainaweb.escolat2.repository;

import br.com.vainaweb.escolat2.colaborador.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
