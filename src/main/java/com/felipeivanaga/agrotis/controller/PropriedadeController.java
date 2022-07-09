package com.felipeivanaga.agrotis.controller;

import com.felipeivanaga.agrotis.entity.Propriedade;
import com.felipeivanaga.agrotis.entity.form.PropriedadeForm;
import com.felipeivanaga.agrotis.entity.form.PropriedadeUpdateForm;
import com.felipeivanaga.agrotis.exception.PropriedadeNotFoundWithIdException;
import com.felipeivanaga.agrotis.service.IPropriedadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/propriedades")
public class PropriedadeController {

    @Autowired
    private IPropriedadeService service;

    @GetMapping
    public List<Propriedade> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propriedade> findOne(@PathVariable Long id) throws PropriedadeNotFoundWithIdException {
        return ResponseEntity.ok(service.findOne(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Propriedade create(@Valid @RequestBody PropriedadeForm propriedadeForm) {
        return service.create(propriedadeForm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Propriedade> update(@PathVariable Long id, @Valid @RequestBody PropriedadeUpdateForm propertyForm) throws PropriedadeNotFoundWithIdException {
        return ResponseEntity.ok(service.update(id, propertyForm));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.inactivate(id);
    }
}
