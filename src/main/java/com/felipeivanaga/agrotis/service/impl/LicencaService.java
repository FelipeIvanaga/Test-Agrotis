package com.felipeivanaga.agrotis.service.impl;

import com.felipeivanaga.agrotis.entity.Laboratorio;
import com.felipeivanaga.agrotis.entity.Licenca;
import com.felipeivanaga.agrotis.entity.Propriedade;
import com.felipeivanaga.agrotis.entity.form.LicencaForm;
import com.felipeivanaga.agrotis.exception.LaboratorioNotFoundWithIdException;
import com.felipeivanaga.agrotis.exception.LicencaNotFoundWithIdException;
import com.felipeivanaga.agrotis.exception.NotFoundWithIdException;
import com.felipeivanaga.agrotis.exception.PropriedadeNotFoundWithIdException;
import com.felipeivanaga.agrotis.repository.LaboratorioRepository;
import com.felipeivanaga.agrotis.repository.LicencaRepository;
import com.felipeivanaga.agrotis.repository.PropriedadeRepository;
import com.felipeivanaga.agrotis.service.ILicencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicencaService implements ILicencaService {

    @Autowired
    private LicencaRepository licencaRepository;
    @Autowired
    private LaboratorioRepository laboratorioRepository;
    @Autowired
    private PropriedadeRepository propriedadeRepository;

    @Override
    public List<Licenca> findAll() {
        return licencaRepository.findAll();
    }

    @Override
    public Licenca findOne(Long id) throws LicencaNotFoundWithIdException {
        Optional<Licenca> licenca = licencaRepository.findById(id);
        if (licenca.isEmpty()) {
            throw new LicencaNotFoundWithIdException(id);
        }
        return licenca.get();
    }

    @Override
    public Licenca create(LicencaForm licencaForm) throws NotFoundWithIdException {
        Licenca licenca = new Licenca();
        Optional<Laboratorio> laboratorio = laboratorioRepository.findById(licencaForm.getLaboratorio().getId());
        if (laboratorio.isEmpty()) {
            throw new LaboratorioNotFoundWithIdException(licencaForm.getLaboratorio().getId());
        }
        Optional<Propriedade> propriedade = propriedadeRepository.findById(licencaForm.getInfosPropriedade().getId());
        if (propriedade.isEmpty()) {
            throw new PropriedadeNotFoundWithIdException(licencaForm.getInfosPropriedade().getId());
        }

        System.out.println(licencaForm.getLaboratorio());

        licenca.setLaboratorio(laboratorio.get());
        licenca.setPropriedade(propriedade.get());
        licenca.setNome(licencaForm.getNome());
        licenca.setDataFinal(licencaForm.getDataFinal());
        licenca.setDataInicial(licencaForm.getDataInicial());
        if (licencaForm.getObservacoes() != null) {
            licenca.setObservacoes(licencaForm.getObservacoes());
        }
        return licencaRepository.save(licenca);
    }

    @Override
    public void delete(Long id) {
        Optional<Licenca> licenca = licencaRepository.findById(id);
        if (licenca.isPresent()) {
            licencaRepository.delete(licenca.get());
        }
    }

    @Override
    public Licenca update(Long id, LicencaForm licencaForm) throws NotFoundWithIdException {
        Optional<Licenca> licenca = licencaRepository.findById(id);
        if (licenca.isEmpty()) {
            throw new LicencaNotFoundWithIdException(id);
        }
        Optional<Laboratorio> laboratorio = laboratorioRepository.findById(licencaForm.getLaboratorio().getId());
        if (laboratorio.isEmpty()) {
            throw new LaboratorioNotFoundWithIdException(licencaForm.getLaboratorio().getId());
        }
        Optional<Propriedade> propriedade = propriedadeRepository.findById(licencaForm.getInfosPropriedade().getId());
        if (propriedade.isEmpty()) {
            throw new PropriedadeNotFoundWithIdException(licencaForm.getInfosPropriedade().getId());
        }

        System.out.println(licencaForm.getLaboratorio());

        licenca.get().setLaboratorio(laboratorio.get());
        licenca.get().setPropriedade(propriedade.get());
        licenca.get().setNome(licencaForm.getNome());
        licenca.get().setDataFinal(licencaForm.getDataFinal());
        licenca.get().setDataInicial(licencaForm.getDataInicial());
        licenca.get().setObservacoes(licencaForm.getObservacoes());
        return licencaRepository.save(licenca.get());
    }
}
