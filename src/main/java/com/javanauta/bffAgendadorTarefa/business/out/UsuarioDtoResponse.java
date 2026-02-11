package com.javanauta.bffAgendadorTarefa.business.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDtoResponse {
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDtoResponse> enderecoDto;
    private List<TelefoneDtoResponse> telefoneDto;
}
