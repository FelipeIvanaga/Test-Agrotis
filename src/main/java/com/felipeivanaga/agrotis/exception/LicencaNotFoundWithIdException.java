package com.felipeivanaga.agrotis.exception;

public class LicencaNotFoundWithIdException extends NotFoundWithIdException {
    public LicencaNotFoundWithIdException(Long id) {
        super("Licença com id: " + id + " não encontrada");
    }
}
