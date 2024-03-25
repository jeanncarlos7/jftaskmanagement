package jftaskmanagement.model;

import jakarta.persistence.*;
import jftaskmanagement.repository.RecordTarefa;
import jftaskmanagement.repository.ResponseTarefa;
import lombok.*;

@Entity
@Table(name = "tarefa")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String icone;

    public Tarefa(RecordTarefa recordTarefa) {
        this.nome = recordTarefa.nome();
        this.icone = recordTarefa.icone();
    }

    public Tarefa UpTarefa (ResponseTarefa responseTarefa){
        Tarefa tarefaUp = new Tarefa();
        this.nome = responseTarefa.nome();
        this.icone = responseTarefa.icone();

        return tarefaUp;
    }
}
