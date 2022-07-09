package com.felipeivanaga.agrotis.controller;

import com.felipeivanaga.agrotis.entity.Laboratorio;
import com.felipeivanaga.agrotis.entity.form.LaboratorioForm;
import com.felipeivanaga.agrotis.entity.form.LaboratorioUpdateForm;
import com.felipeivanaga.agrotis.exception.LaboratorioNotFoundWithIdException;
import com.felipeivanaga.agrotis.service.ILaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/laboratorios")
public class LaboratorioController {

    @Autowired
    private ILaboratorioService service;

    @GetMapping
    public List<Laboratorio> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratorio> findOne(@PathVariable Long id) throws LaboratorioNotFoundWithIdException {
        return ResponseEntity.ok(service.findOne(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Laboratorio create(@Valid @RequestBody LaboratorioForm laboratorioForm) {
        return service.create(laboratorioForm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratorio> update(@PathVariable Long id,
                                              @Valid @RequestBody LaboratorioUpdateForm laboratorioUpdateForm) throws LaboratorioNotFoundWithIdException {
        return ResponseEntity.ok(service.update(id, laboratorioUpdateForm));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
