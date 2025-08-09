package com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.service;

import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.model.Agendamento;
import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.model.Cliente;
import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.model.HorarioDisponivel;
import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.model.Servico;
import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.repository.AgendamentoRepository;
import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.repository.ClienteRepository;
import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.repository.HorarioDisponivelRepository;
import com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {


    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private HorarioDisponivelRepository horarioDisponivelRepository;

    @Transactional
    public Agendamento criarAgendamento(Long clienteId, Long servicoId) throws Exception {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new Exception("Cliente não encontrado"));

        Servico servico = servicoRepository.findById(servicoId)
                .orElseThrow(() -> new Exception("Serviço não encontrado"));

        LocalDateTime agora = LocalDateTime.now();
        List<HorarioDisponivel> horariosLivres = horarioDisponivelRepository
                .findByOcupadoFalseAndDataHoraInicioAfter(agora);

        if(horariosLivres.isEmpty()) {
            throw new Exception("Nenhum horário diponível");
        }

        Optional<HorarioDisponivel> melhorHorarioOpt = horariosLivres.stream()
                .min(Comparator.comparing((HorarioDisponivel::getDataHoraInicio)));

        if (melhorHorarioOpt.isEmpty()){
            throw new Exception("Nenhum horário adequado encontrado");
        }

        HorarioDisponivel melhorHorario = melhorHorarioOpt.get();

        melhorHorario.setOcupado(true);
        horarioDisponivelRepository.save(melhorHorario);

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setServico(servico);
        agendamento.setHorarioDisponivel(melhorHorario);
        agendamento.setStatus(Agendamento.StatusAgendamento.CONFIRMADO);

        return agendamentoRepository.save(agendamento);

    }
}
