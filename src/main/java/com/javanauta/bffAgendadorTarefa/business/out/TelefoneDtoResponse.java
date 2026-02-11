package com.javanauta.bffAgendadorTarefa.business.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDtoResponse {
    private Long id;
    private String numero;
    private String ddd;
}
