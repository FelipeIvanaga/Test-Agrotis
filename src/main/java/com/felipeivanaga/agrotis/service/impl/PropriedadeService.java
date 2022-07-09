package com.felipeivanaga.agrotis.service.impl;

import com.felipeivanaga.agrotis.entity.Propriedade;
import com.felipeivanaga.agrotis.entity.form.PropriedadeForm;
import com.felipeivanaga.agrotis.entity.form.PropriedadeUpdateForm;
import com.felipeivanaga.agrotis.exception.PropriedadeNotFoundWithIdException;
import com.felipeivanaga.agrotis.repository.PropriedadeRepository;
import com.felipeivanaga.agrotis.service.IPropriedadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropriedadeService implements IPropriedadeService {

    @Autowired
    private PropriedadeRepository propriedadeRepository;

    @Override
    public Propriedade create(PropriedadeForm propriedadeForm) {
        Propriedade propriedade = new Propriedade();
        propriedade.setCnpj(propriedadeForm.getCnpj());
        propriedade.setNome(propriedadeForm.getNome());

        return propriedadeRepository.save(propriedade);
    }

    @Override
    public List<Propriedade> findAll() {
        return propriedadeRepository.findAll();
    }

    @Override
    public Propriedade findOne(Long id) throws PropriedadeNotFoundWithIdException {
        Optional<Propriedade> propriedade = propriedadeRepository.findById(id);
        if (propriedade.isPresent()) {
            return propriedade.get();
        }
        throw new PropriedadeNotFoundWithIdException(id);
    }

    @Override
    public Propriedade update(Long id, PropriedadeUpdateForm propertyForm) throws PropriedadeNotFoundWithIdException {
        Optional<Propriedade> property = propriedadeRepository.findById(id);
        if (property.isEmpty()) {
            throw new PropriedadeNotFoundWithIdException(id);
        }
        property.get().setNome(propertyForm.getNome());
        property.get().setInativo(propertyForm.getInativo());
        return propriedadeRepository.save(property.get());
    }

    @Override
    public void inactivate(Long id) {
        Optional<Propriedade> property = propriedadeRepository.findById(id);
        if (!property.isEmpty()) {
            property.get().setInativo(true);
            propriedadeRepository.save(property.get());
        }
    }
}
