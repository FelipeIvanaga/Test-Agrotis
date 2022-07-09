package com.felipeivanaga.agrotis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_licencas")
public class Licenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataInicial;
    private Date dataFinal;
    private String observacoes;

    @ManyToOne()
    @JoinColumn(name = "laboratorio_id")
    private Laboratorio laboratorio;

    @ManyToOne()
    @JoinColumn(name = "propriedade_id")
    private Propriedade propriedade;
}
