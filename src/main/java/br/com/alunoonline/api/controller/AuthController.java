package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.*;
import br.com.alunoonline.api.model.Usuario;
import br.com.alunoonline.api.repository.UsuarioRepository;
import br.com.alunoonline.api.infra.security.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager,
                          UsuarioRepository usuarioRepository,
                          TokenService tokenService,
                          BCryptPasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
            var auth = this.authenticationManager.authenticate(usernamePassword);
            var token = tokenService.gerarToken((Usuario) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new LoginResponseDTO("Credenciais inválidas"));
        }
    }

    @Transactional
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        try {
            // DEBUG: Verifica quantos usuários existem no banco
            System.out.println("DEBUG: Total de usuários no banco: " + usuarioRepository.count());

            // Verifica se email já existe
            if (usuarioRepository.existsByEmail(data.email())) {
                System.out.println("DEBUG: Tentativa de cadastro com email existente: " + data.email());
                return ResponseEntity
                        .badRequest()
                        .body(new ErrorResponse("Email já está em uso"));
            }

            // Criptografa a senha
            String encryptedPassword = passwordEncoder.encode(data.senha());

            // Cria novo usuário
            Usuario novoUsuario = new Usuario(
                    data.nome(),
                    data.email(),
                    encryptedPassword,
                    data.role()
            );

            // Salva no banco
            usuarioRepository.save(novoUsuario);
            System.out.println("DEBUG: Usuário cadastrado com sucesso: " + novoUsuario.getEmail());

            return ResponseEntity
                    .ok()
                    .body(new MessageResponse("Usuário registrado com sucesso"));

        } catch (Exception e) {
            System.err.println("ERRO ao registrar usuário: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity
                    .internalServerError()
                    .body(new ErrorResponse("Erro ao registrar usuário: " + e.getMessage()));
        }
    }
}