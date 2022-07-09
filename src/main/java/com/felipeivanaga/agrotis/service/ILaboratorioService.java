package com.felipeivanaga.agrotis.service;

import com.felipeivanaga.agrotis.entity.Laboratorio;
import com.felipeivanaga.agrotis.entity.form.LaboratorioForm;
import com.felipeivanaga.agrotis.entity.form.LaboratorioUpdateForm;
import com.felipeivanaga.agrotis.exception.LaboratorioNotFoundWithIdException;

import java.util.List;

public interface ILaboratorioService {
    Laboratorio create(LaboratorioForm laboratorioForm);
    Laboratorio update(Long id, LaboratorioUpdateForm laboratorioUpdateForm) throws LaboratorioNotFoundWithIdException;
    List<Laboratorio> findAll();
    Laboratorio findOne(Long id) throws LaboratorioNotFoundWithIdException;
    void delete(Long id);
}
