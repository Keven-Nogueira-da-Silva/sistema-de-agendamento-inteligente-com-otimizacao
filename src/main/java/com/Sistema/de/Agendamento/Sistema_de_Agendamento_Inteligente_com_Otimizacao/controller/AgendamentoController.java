package com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.controller;


import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.model.Agendamento;
import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<?> criarAgendamento(
            @RequestParam @NotNull Long clienteId,
            @RequestParam @NotNull Long servicoId) {
        try {
            Agendamento agendamento = agendamentoService.criarAgendamento(clienteId, servicoId);
            return ResponseEntity.ok(agendamento);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
