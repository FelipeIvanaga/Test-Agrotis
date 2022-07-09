package com.felipeivanaga.agrotis.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaboratorioForm {
    @NotBlank(message = "informe o nome.")
    @Size(min = 3, max = 40, message = "Nome deve conter entre {min} e {max} caracteres.")
    private String nome;
}
