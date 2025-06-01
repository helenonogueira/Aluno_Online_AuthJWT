package br.com.alunoonline.api.dtos;

import javax.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank String email,
        @NotBlank String senha
) {}