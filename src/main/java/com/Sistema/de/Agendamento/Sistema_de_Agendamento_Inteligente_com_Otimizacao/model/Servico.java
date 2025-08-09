package com.Sistema.de.Agendamento.Sistema_de_Agendamento_Inteligente_com_Otimizacao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do serviço é obrigatório")
    private String nome;

    @Min(value = 1, message = "A duração deve ser pelo menos 1 minuto")
    private int deracaoMinutos;
}
