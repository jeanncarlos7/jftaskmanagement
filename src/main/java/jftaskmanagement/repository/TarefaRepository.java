package jftaskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import jftaskmanagement.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, String> {}
