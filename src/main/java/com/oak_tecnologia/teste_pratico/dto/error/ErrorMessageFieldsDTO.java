package com.oak_tecnologia.teste_pratico.dto.error;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ErrorMessageFieldsDTO extends ErrorMessageDTO{

    private List<ErrorFieldsDTO> errors = new ArrayList<>();

    public ErrorMessageFieldsDTO(Instant timestamp, Integer status, String message, String path) {
        super(timestamp, status, message, path);
    }

    public List<ErrorFieldsDTO> getErrors() {
        return errors;
    }
}
