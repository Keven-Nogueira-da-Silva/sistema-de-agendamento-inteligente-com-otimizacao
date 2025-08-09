package com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @NotNull(message = "O cliente é obrigatório")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    @NotNull(message = "O serviço é obrigatório")
    private Servico servico;

    @OneToOne
    @JoinColumn(name = "horario_id", nullable = false)
    @NotNull(message = "O horário é obrigatório")
    private HorarioDisponivel horarioDisponivel;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status = StatusAgendamento.CONFIRMADO;

    public enum StatusAgendamento {
        CONFIRMADO,
        CANCELADO
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public HorarioDisponivel getHorarioDisponivel() {
        return horarioDisponivel;
    }

    public void setHorarioDisponivel(HorarioDisponivel horarioDisponivel) {
        this.horarioDisponivel = horarioDisponivel;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
