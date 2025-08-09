package com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.repository;

import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}
