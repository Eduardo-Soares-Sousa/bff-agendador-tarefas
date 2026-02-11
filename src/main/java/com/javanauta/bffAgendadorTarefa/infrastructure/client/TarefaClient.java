package com.javanauta.bffAgendadorTarefa.infrastructure.client;

import com.javanauta.bffAgendadorTarefa.business.in.TarefaDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.out.TarefaDtoResponse;
import com.javanauta.bffAgendadorTarefa.infrastructure.enums.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefaClient {
    @PostMapping
    TarefaDtoResponse salvarTarefa(@RequestHeader("Authorization") String token,
                                   @RequestBody TarefaDtoRequest tarefaDto);

    @GetMapping("/eventos")
    List<TarefaDtoResponse> buscarTarefaPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("Authorization") String token);

    @GetMapping
    List<TarefaDtoResponse> buscarTarefasPorEmailUsuario(@RequestHeader("Authorization") String token);

    @DeleteMapping
    void deletarTarefaPorId(@RequestParam("id") String id, @RequestHeader("Authorization") String token);

    @PatchMapping
    TarefaDtoResponse atualizaStatus(@RequestParam("status") Status status,
                                     @RequestParam("id") String id,
                                     @RequestHeader("Authorization") String token);
    @PutMapping
    TarefaDtoResponse atualizaDadosTarefa(@RequestBody TarefaDtoRequest tarefaDto,
                                          @RequestParam("id") String id,
                                          @RequestHeader("Authorization") String token);
}
