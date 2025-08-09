package com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.repository;

import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
