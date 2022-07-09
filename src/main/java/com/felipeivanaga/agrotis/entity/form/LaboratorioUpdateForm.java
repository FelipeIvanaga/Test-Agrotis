package com.felipeivanaga.agrotis.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaboratorioUpdateForm {
    @NotBlank(message = "informe o nome.")
    @Size(min = 3, max = 40, message = "Nome deve conter entre {min} e {max} caracteres.")
    private String nome;

    @NotNull(message = "informe o status(inativo=true ou false).")
    private Boolean inativo;
}
