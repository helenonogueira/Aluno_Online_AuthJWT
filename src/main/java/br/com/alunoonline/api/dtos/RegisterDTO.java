package br.com.alunoonline.api.dtos;

import br.com.alunoonline.api.enums.Role;
import javax.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String senha,
        Role role
) {}