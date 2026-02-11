package com.javanauta.bffAgendadorTarefa.controller;

import com.javanauta.bffAgendadorTarefa.business.TarefaService;
import com.javanauta.bffAgendadorTarefa.business.in.TarefaDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.out.TarefaDtoResponse;
import com.javanauta.bffAgendadorTarefa.infrastructure.enums.Status;
import com.javanauta.bffAgendadorTarefa.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tarefa")
@Tag(name = "Tarefas", description = "Cadastro de tarefas de usuários")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefaController {
    private final TarefaService tarefaService;

    @PostMapping
    @Operation(summary = "Salvar tarefas", description = "Cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefaDtoResponse> salvarTarefa(@RequestHeader(value = "Authorization", required = false) String token,
                                                          @RequestBody TarefaDtoRequest tarefaDto) {
        return ResponseEntity.ok(tarefaService.salvarTarefa(token, tarefaDto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca tarefas de usuário por período", description = "Busca tarefas por período de tempo")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefaDtoResponse>> buscarTarefaPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.buscarTarefasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Busca tarefas de usuário", description = "Busca telefones por email de usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefaDtoResponse>> buscarTarefasPorEmailUsuario(
            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.buscarTarefasPorEmailUsuario(token));
    }

    @DeleteMapping
    @Operation(summary = "Deleta tarefas de usuário", description = "Deleta tarefas de usuário por id")
    @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletarTarefaPorId(@RequestParam("id") String id,
                                                   @RequestHeader(value = "Authorization", required = false) String token) {
        tarefaService.deletarTarefaPorId(id, token);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Atualiza Status da tarefa", description = "Atualiza Status da tarefa")
    @ApiResponse(responseCode = "200", description = "Status da tarefa alterado com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefaDtoResponse> atualizaStatus(@RequestParam("status") Status status,
                                                            @RequestParam("id") String id,
                                                            @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.atualizaStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Atualiza dados da tarefa", description = "Atualiza dados da tarefa")
    @ApiResponse(responseCode = "200", description = "Dados da tarefa atualizados com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefaDtoResponse> atualizaDadosTarefa(@RequestBody TarefaDtoRequest tarefaDto,
                                                                 @RequestParam("id") String id,
                                                                 @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefaService.atualizarDadosTarefa(tarefaDto, id, token));
    }
}
