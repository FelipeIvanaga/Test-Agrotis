package com.felipeivanaga.agrotis.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicencaForm {
    @NotBlank(message = "informe o nome.")
    @Size(min = 3, max = 40, message = "Nome deve conter entre {min} e {max} caracteres.")
    private String nome;

    @DateTimeFormat
    @NotNull(message = "informe a data inicial")
    private Date dataInicial;

    @DateTimeFormat
    @NotNull(message = "informe a data final")
    private Date dataFinal;

    @CNPJ
    @NotNull(message = "informe o CNPJ")
    private String cnpj;

    private String observacoes;
    @Valid
    @NotNull(message = "informe os dados do laboratorio")
    private LaboratorioInfoForm laboratorio;
    @Valid
    @NotNull(message = "informe os dados da propriedade")
    private PropriedadeInfoForm infosPropriedade;
}
