package com.estudos.api_controle_ponto.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "registro_ponto")
public class ControlePontoEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "data_atual")
    private LocalDate dataAtual;
    @Column(name = "hora_entrada")
    private LocalTime horaEntrada;
    @Column(name = "hora_almoco")
    private LocalTime horaAlmoco;
    @Column(name = "hora_volta_almoco")
    private LocalTime horaVoltaAlmoco;
    @Column(name = "hora_saida")
    private LocalTime horaSaida;

    @Override
    public String toString() {
        return "ControlePontoModel{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", dataAtual=" + dataAtual +
                ", horaEntrada=" + horaEntrada +
                ", horaAlmoco=" + horaAlmoco +
                ", horaVoltaAlmoco=" + horaVoltaAlmoco +
                ", horaSaida=" + horaSaida +
                '}';
    }
}
