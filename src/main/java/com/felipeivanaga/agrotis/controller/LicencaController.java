package com.felipeivanaga.agrotis.controller;

import com.felipeivanaga.agrotis.entity.Licenca;
import com.felipeivanaga.agrotis.entity.form.LicencaForm;
import com.felipeivanaga.agrotis.exception.LicencaNotFoundWithIdException;
import com.felipeivanaga.agrotis.exception.NotFoundWithIdException;
import com.felipeivanaga.agrotis.service.ILicencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/licencas")
public class LicencaController {

    @Autowired
    private ILicencaService permitService;

    @GetMapping
    public List<Licenca> findAll() {
        return permitService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Licenca> findOne(@PathVariable Long id) throws LicencaNotFoundWithIdException {
        return ResponseEntity.ok(permitService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Licenca> create(@Valid @RequestBody LicencaForm licencaForm) throws Exception {
        return ResponseEntity.ok(permitService.create(licencaForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Licenca> update(@PathVariable Long id,
    @RequestBody LicencaForm licencaForm) throws NotFoundWithIdException {
        return ResponseEntity.ok(permitService.update(id, licencaForm));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        permitService.delete(id);
    }
}
