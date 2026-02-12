package com.javanauta.bffAgendadorTarefa.controller;

import com.javanauta.bffAgendadorTarefa.business.UsuarioService;
import com.javanauta.bffAgendadorTarefa.business.in.EnderecoDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.in.LoginDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.in.TelefoneDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.in.UsuarioDtoRequest;
import com.javanauta.bffAgendadorTarefa.business.out.EnderecoDtoResponse;
import com.javanauta.bffAgendadorTarefa.business.out.TelefoneDtoResponse;
import com.javanauta.bffAgendadorTarefa.business.out.UsuarioDtoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuário", description = "Cadastro e login de usuários")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    @Operation(summary = "Salvar usuários", description = "Cria um novo usuário")
    @ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
    @ApiResponse(responseCode = "409", description = "Usuário já cadastrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDtoResponse> salvaUsuario(@RequestBody UsuarioDtoRequest usuarioDto) {
        return ResponseEntity.ok(usuarioService.salvaUsuario(usuarioDto));
    }

    @PostMapping("/login")
    @Operation(summary = "Login de usuários", description = "login do usuário")
    @ApiResponse(responseCode = "200", description = "Login efetuado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public String login(@RequestBody LoginDtoRequest usuarioDto) {
        return usuarioService.login(usuarioDto);
    }

    @GetMapping
    @Operation(summary = "Buscar dados de usuário por email", description = "Buscar dados de usuário")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDtoResponse> buscaUsuarioPorEmail(@RequestParam("email") String email,
                                                                   @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.buscaUsuarioPorEmail(email, token));
    }

    @DeleteMapping("/{email}")
    @Operation(summary = "Deleta usuário por email", description = "Deleta usuário")
    @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletaUsuario(@PathVariable String email,
                                              @RequestHeader(value = "Authorization", required = false) String token) {
        usuarioService.deletaUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Operation(summary = "Atualiza dados de usuário", description = "Atualiza dados de usuário")
    @ApiResponse(responseCode = "200", description = "Dados atualizados com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<UsuarioDtoResponse> atualizaDadosUsuario(@RequestBody UsuarioDtoRequest usuarioDto,
                                                                   @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaDadosUsuario(usuarioDto, token));
    }

    @PutMapping("/endereco")
    @Operation(summary = "Atualiza endereço do usuário", description = "Atualiza endereço do usuário")
    @ApiResponse(responseCode = "200", description = "Dados atualizados com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDtoResponse> atualizaEndereco(@RequestBody EnderecoDtoRequest enderecoDto,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaEndereco(id, enderecoDto, token));
    }

    @PutMapping("/telefone")
    @Operation(summary = "Atualiza telefone do usuário", description = "Atualiza telefone do usuário")
    @ApiResponse(responseCode = "200", description = "Dados atualizados com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDtoResponse> atualizaTelefone(@RequestBody TelefoneDtoRequest telefoneDto,
                                                                @RequestParam("id") Long id,
                                                                @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.atualizaTelefone(id, telefoneDto, token));
    }

    @PostMapping("/endereco")
    @Operation(summary = "Cadastro de endereço do usuário", description = "Salva endereço do usuário")
    @ApiResponse(responseCode = "200", description = "Endereço salvo com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<EnderecoDtoResponse> cadastrarEndereco(@RequestBody EnderecoDtoRequest enderecoDto,
                                                                 @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.cadastroEndereco(token, enderecoDto));
    }

    @PostMapping("/telefone")
    @Operation(summary = "Cadastro de telefone do usuário", description = "Salva telefone do usuário")
    @ApiResponse(responseCode = "200", description = "telefone salvo com sucesso")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "403", description = "Usuário não encontrado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TelefoneDtoResponse> cadastrarTelefone(@RequestBody TelefoneDtoRequest telefoneDto,
                                                                 @RequestHeader(value = "Authorization", required = false) String token) {
        return ResponseEntity.ok(usuarioService.cadastroTelefone(token, telefoneDto));
    }
}
