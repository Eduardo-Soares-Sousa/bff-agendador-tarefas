package com.javanauta.bffAgendadorTarefa.business.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDtoRequest {
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDtoRequest> enderecoDtoRequest;
    private List<TelefoneDtoRequest> telefoneDtoRequests;
}
