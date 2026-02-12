package com.javanauta.bffAgendadorTarefa.business;

import com.javanauta.bffAgendadorTarefa.business.in.LoginDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.out.TarefaDtoResponse;
import com.javanauta.bffAgendadorTarefa.infrastructure.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CronService {
    private TarefaService tarefaService;
    private EmailService emailService;
    private UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;
    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")
    public void buscaTarefaSProximaHora(){
        String token = login(converterParaRequestDto());

        LocalDateTime horaAtual = LocalDateTime.now();
        LocalDateTime horaFutura = LocalDateTime.now().plusMinutes(5);

        List<TarefaDtoResponse> listaTarefas = tarefaService
                .buscarTarefasPorPeriodo(horaAtual, horaFutura, token);

        listaTarefas.forEach(tarefa -> {emailService.enviarEmail(tarefa);
            tarefaService.atualizaStatus(Status.NOTIFICADO, tarefa.getId(), token);});
    }

    public String login(LoginDtoRequest loginDtoRequest) {
        return usuarioService.login(loginDtoRequest);
    }

    public LoginDtoRequest converterParaRequestDto() {
        return LoginDtoRequest.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
