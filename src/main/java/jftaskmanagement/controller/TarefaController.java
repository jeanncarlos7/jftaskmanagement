package jftaskmanagement.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jftaskmanagement.repository.RecordTarefa;
import jftaskmanagement.repository.ResponseTarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jftaskmanagement.model.Tarefa;
import jftaskmanagement.repository.TarefaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharTarefa(@PathVariable String id) {
        return tarefaRepository.findById(id)
                .map(tarefa -> ResponseEntity.ok().body(tarefa))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity cadastrarTarefa(@RequestBody @Valid RecordTarefa data) {
        Tarefa tarefa = new Tarefa(data);

        Tarefa novaTarefa = tarefaRepository.save(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarTarefa(@RequestBody @Valid ResponseTarefa upData) {
        Optional<Tarefa> OptionalTarefa = tarefaRepository.findById(String.valueOf(upData.id()));
        if (!OptionalTarefa.isPresent())
            throw new EntityNotFoundException();

        Tarefa NewTarefa = OptionalTarefa.get();
        NewTarefa.UpTarefa(upData);

        return ResponseEntity.ok(upData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarTarefa(@PathVariable String id) {
        if (!tarefaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tarefaRepository.deleteById(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
