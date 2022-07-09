package com.felipeivanaga.agrotis.service;

import com.felipeivanaga.agrotis.entity.Licenca;
import com.felipeivanaga.agrotis.entity.form.LicencaForm;
import com.felipeivanaga.agrotis.exception.LicencaNotFoundWithIdException;
import com.felipeivanaga.agrotis.exception.NotFoundWithIdException;

import java.util.List;

public interface ILicencaService {
    Licenca create(LicencaForm licencaForm) throws NotFoundWithIdException;
    Licenca update(Long id, LicencaForm licencaForm) throws NotFoundWithIdException;
    List<Licenca> findAll();
    Licenca findOne(Long id) throws LicencaNotFoundWithIdException;
    void delete(Long id);
}
