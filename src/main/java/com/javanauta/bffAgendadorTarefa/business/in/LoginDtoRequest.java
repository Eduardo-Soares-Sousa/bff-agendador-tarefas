package com.javanauta.bffAgendadorTarefa.business.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDtoRequest {
    private String email;
    private String senha;
}
