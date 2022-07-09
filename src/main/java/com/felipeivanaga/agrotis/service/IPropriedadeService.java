package com.felipeivanaga.agrotis.service;

import com.felipeivanaga.agrotis.entity.Propriedade;
import com.felipeivanaga.agrotis.entity.form.PropriedadeForm;
import com.felipeivanaga.agrotis.entity.form.PropriedadeUpdateForm;
import com.felipeivanaga.agrotis.exception.PropriedadeNotFoundWithIdException;

import java.util.List;
import java.util.Optional;

public interface IPropriedadeService {
    Propriedade create(PropriedadeForm propriedadeForm);
    List<Propriedade> findAll();
    Propriedade findOne(Long id) throws PropriedadeNotFoundWithIdException;
    Propriedade update(Long id, PropriedadeUpdateForm propertyForm) throws PropriedadeNotFoundWithIdException;
    void inactivate(Long id);
}