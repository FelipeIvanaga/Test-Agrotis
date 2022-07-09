package com.felipeivanaga.agrotis.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaboratorioInfoForm {
    @NotNull(message = "informe o id do laboratorio")
    private Long id;

    @NotNull(message = "informe o nome do laboratorio.")
    private String nome;
}
