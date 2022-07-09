package com.felipeivanaga.agrotis.service.impl;

import com.felipeivanaga.agrotis.entity.Laboratorio;
import com.felipeivanaga.agrotis.entity.form.LaboratorioForm;
import com.felipeivanaga.agrotis.entity.form.LaboratorioUpdateForm;
import com.felipeivanaga.agrotis.exception.LaboratorioNotFoundWithIdException;
import com.felipeivanaga.agrotis.repository.LaboratorioRepository;
import com.felipeivanaga.agrotis.service.ILaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratorioService implements ILaboratorioService {

    @Autowired
    private LaboratorioRepository laboratorioRepository;

    @Override
    public Laboratorio create(LaboratorioForm laboratorioForm) {
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setNome(laboratorioForm.getNome());
        return laboratorioRepository.save(laboratorio);
    }

    @Override
    public Laboratorio update(Long id, LaboratorioUpdateForm laboratorioUpdateForm) throws LaboratorioNotFoundWithIdException {
        Optional<Laboratorio> lab = laboratorioRepository.findById(id);
        if(lab.isEmpty()) {
            throw new LaboratorioNotFoundWithIdException(id);
        }
        lab.get().setNome(laboratorioUpdateForm.getNome());
        lab.get().setInativo(laboratorioUpdateForm.getInativo());
        return laboratorioRepository.save(lab.get());
    }

    @Override
    public List<Laboratorio> findAll() {
        return laboratorioRepository.findAll();
    }

    @Override
    public Laboratorio findOne(Long id) throws LaboratorioNotFoundWithIdException {
        Optional<Laboratorio> laboratorio = laboratorioRepository.findById(id);
        if (laboratorio.isPresent()) {
            return laboratorio.get();
        }
        throw new LaboratorioNotFoundWithIdException(id);
    }

    @Override
    public void delete(Long id) {
        Optional<Laboratorio> lab = laboratorioRepository.findById(id);
        if (!lab.isEmpty()) {
            lab.get().setInativo(true);
            laboratorioRepository.save(lab.get());
        }
    }
}
