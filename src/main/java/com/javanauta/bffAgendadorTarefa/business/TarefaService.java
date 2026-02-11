package com.javanauta.bffAgendadorTarefa.business;

import com.javanauta.bffAgendadorTarefa.business.in.TarefaDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.out.TarefaDtoResponse;
import com.javanauta.bffAgendadorTarefa.infrastructure.client.TarefaClient;
import com.javanauta.bffAgendadorTarefa.infrastructure.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaClient tarefaClient;

    public TarefaDtoResponse salvarTarefa(String token, TarefaDtoRequest tarefaDto) {
        return tarefaClient.salvarTarefa(token, tarefaDto);
    }

    public List<TarefaDtoResponse> buscarTarefasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal, String token) {
        return tarefaClient.buscarTarefaPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefaDtoResponse> buscarTarefasPorEmailUsuario(String token) {
        return tarefaClient.buscarTarefasPorEmailUsuario(token);
    }

    public void deletarTarefaPorId(String id, String token) {
        tarefaClient.deletarTarefaPorId(id, token);
    }

    public TarefaDtoResponse atualizaStatus(Status status, String id, String token) {
        return tarefaClient.atualizaStatus(status, id, token);
    }

    public TarefaDtoResponse atualizarDadosTarefa(TarefaDtoRequest tarefaDto, String id, String token) {
        return tarefaClient.atualizaDadosTarefa(tarefaDto, id, token);
    }
}
