package com.javanauta.bffAgendadorTarefa.infrastructure.client;

import com.javanauta.bffAgendadorTarefa.business.in.EnderecoDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.in.LoginDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.in.TelefoneDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.in.UsuarioDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.out.EnderecoDtoResponse;
import com.javanauta.bffAgendadorTarefa.business.out.TelefoneDtoResponse;
import com.javanauta.bffAgendadorTarefa.business.out.UsuarioDtoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {
    @GetMapping
    UsuarioDtoResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDtoResponse salvaUsuario(@RequestBody UsuarioDtoRequest usuarioDto);

    @PostMapping("/login")
    String login(@RequestBody LoginDtoRequest usuarioDto);

    @DeleteMapping("/{email}")
    void deletaUsuario(@PathVariable String email,
                       @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDtoResponse atualizaDadosUsuario(@RequestBody UsuarioDtoRequest usuarioDto,
                                            @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDtoResponse atualizaEndereco(@RequestBody EnderecoDtoRequest enderecoDto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDtoResponse atualizaTelefone(@RequestBody TelefoneDtoRequest telefoneDto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDtoResponse cadastrarEndereco(@RequestBody EnderecoDtoRequest enderecoDto,
                                          @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDtoResponse cadastrarTelefone(@RequestBody TelefoneDtoRequest telefoneDto,
                                          @RequestHeader("Authorization") String token);
}
