package com.javanauta.bffAgendadorTarefa.business.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDtoRequest {
    private String rua;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
}
