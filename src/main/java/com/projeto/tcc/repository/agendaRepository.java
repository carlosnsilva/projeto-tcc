package com.projeto.tcc.repository;

import com.projeto.tcc.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface agendaRepository extends JpaRepository<Agenda, Long> {
}
