package com.javanauta.bffAgendadorTarefa.infrastructure.client.config;

import com.javanauta.bffAgendadorTarefa.infrastructure.exceptions.BusinessException;
import com.javanauta.bffAgendadorTarefa.infrastructure.exceptions.ConflitException;
import com.javanauta.bffAgendadorTarefa.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta.bffAgendadorTarefa.infrastructure.exceptions.UnauthorizeException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch(response.status()) {
            case 401:
                return new UnauthorizeException("Erro - usuário não autorizado");
            case 403:
                return new ResourceNotFoundException("Erro - atributo não encontrado");
            case 409:
                return new ConflitException("Erro - atributo já existente");
            default:
                return new BusinessException("Erro de servidor");
        }
    }
}
