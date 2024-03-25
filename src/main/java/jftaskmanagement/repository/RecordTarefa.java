package jftaskmanagement.repository;

import jakarta.validation.constraints.*;

public record RecordTarefa(
        @NotBlank String nome,
        @NotBlank String icone
) {
}
