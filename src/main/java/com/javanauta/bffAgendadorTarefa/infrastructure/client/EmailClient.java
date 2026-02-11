package com.javanauta.bffAgendadorTarefa.infrastructure.client;

import com.javanauta.bffAgendadorTarefa.business.out.TarefaDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {
    void enviarEmail(@RequestBody TarefaDtoResponse tarefaDto);
}
