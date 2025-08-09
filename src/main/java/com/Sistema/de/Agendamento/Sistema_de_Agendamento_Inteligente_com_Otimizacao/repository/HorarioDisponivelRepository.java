package com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.repository;

import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.model.HorarioDisponivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HorarioDisponivelRepository extends JpaRepository<HorarioDisponivel, Long> {
    List<HorarioDisponivel> findByOcupadoFalseAndDataHoraInicioAfter (LocalDateTime agora);
}
