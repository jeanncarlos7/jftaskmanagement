package jftaskmanagement.repository;

import jakarta.validation.constraints.*;
import jftaskmanagement.model.Tarefa;

public record ResponseTarefa(
        @NotNull Long id,
        String nome,
        String icone
) {
    public ResponseTarefa(Tarefa tarefa){
        this(
                tarefa.getId(),
                tarefa.getNome(),
                tarefa.getIcone()
        );
    }
}
