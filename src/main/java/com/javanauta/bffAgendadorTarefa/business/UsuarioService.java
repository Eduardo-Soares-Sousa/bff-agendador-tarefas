package com.javanauta.bffAgendadorTarefa.business;

import com.javanauta.bffAgendadorTarefa.business.in.EnderecoDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.in.LoginDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.in.TelefoneDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.in.UsuarioDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.out.EnderecoDtoResponse;
import com.javanauta.bffAgendadorTarefa.business.out.TelefoneDtoResponse;
import com.javanauta.bffAgendadorTarefa.business.out.UsuarioDtoResponse;
import com.javanauta.bffAgendadorTarefa.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioClient usuarioClient;

    public UsuarioDtoResponse salvaUsuario(UsuarioDtoRequest usuarioDto) {
        return usuarioClient.salvaUsuario(usuarioDto);
    }

    public String login(LoginDtoRequest usuarioDto) {
        return usuarioClient.login(usuarioDto);
    }

    public UsuarioDtoResponse buscaUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        usuarioClient.deletaUsuario(email, token);
    }

    public UsuarioDtoResponse atualizaDadosUsuario(UsuarioDtoRequest usuarioDto, String token) {
        return usuarioClient.atualizaDadosUsuario(usuarioDto, token);
    }

    public EnderecoDtoResponse atualizaEndereco(Long id, EnderecoDtoRequest enderecoDto, String token) {
        return usuarioClient.atualizaEndereco(enderecoDto, id, token);
    }

    public TelefoneDtoResponse atualizaTelefone(Long id, TelefoneDtoRequest telefoneDto, String token) {
        return usuarioClient.atualizaTelefone(telefoneDto, id, token);
    }

    public EnderecoDtoResponse cadastroEndereco(String token, EnderecoDtoRequest enderecoDto) {
        return usuarioClient.cadastrarEndereco(enderecoDto, token);
    }

    public TelefoneDtoResponse cadastroTelefone(String token, TelefoneDtoRequest telefoneDto) {
        return usuarioClient.cadastrarTelefone(telefoneDto, token);
    }
}
