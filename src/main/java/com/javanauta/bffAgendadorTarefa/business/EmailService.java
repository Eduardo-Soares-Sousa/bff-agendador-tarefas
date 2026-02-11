package com.javanauta.bffAgendadorTarefa.business;

import com.javanauta.bffAgendadorTarefa.business.out.TarefaDtoResponse;
import com.javanauta.bffAgendadorTarefa.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailClient emailClient;

    public void enviarEmail(TarefaDtoResponse tarefaDto) {
        emailClient.enviarEmail(tarefaDto);
    }
}
