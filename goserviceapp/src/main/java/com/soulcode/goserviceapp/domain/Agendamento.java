package com.soulcode.goserviceapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GenerateValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo do agendamento referente ao cliente não pode " +
            "ser vazio.")
    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @NotNull(message = "O campo do agendamento referente ao prestador não " +
            "pode ser vazio.")
    @ManyToOne
    @JoinColumn(nullable = false)
    private Prestador prestador;

    @NotNull(message = "O campo do agendamento referente ao serviço não pode " +
            "ser vazio.")
    @ManyToOne
    @JoinColumn(nullable = false)
    private Servico servico;

    @NotNull(message = "O status do agendamento não pode ser vazio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAgendamento statusAgendamento;

    @NotNull(message = "A data do agendamento não pode ser vazia.")
    @Column(nullable = false)
    private LocalDate data;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataHoraRegistro;

    public Agendamento(){
        this.statusAgendamento = StatusAgendamento.AGUARDANDO_CONFIRMACAO;
    }
}
