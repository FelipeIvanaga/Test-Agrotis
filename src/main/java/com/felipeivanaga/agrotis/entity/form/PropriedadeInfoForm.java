package com.felipeivanaga.agrotis.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropriedadeInfoForm {
    @NotNull(message = "informe o id da propriedade")
    private Long id;
    @NotNull(message = "informe o nome da propriedade")
    private String nome;
}
