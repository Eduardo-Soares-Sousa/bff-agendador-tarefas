package com.javanauta.bffAgendadorTarefa.business.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDtoResponse {
    private Long id;
    private String rua;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
}
