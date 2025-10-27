import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa {
    private int id;
    private List<Atendimento> historico;

    public Medico(int id, String nome, String CPF) {
        super(nome, CPF);
        this.id = id;
        this.historico = new ArrayList<>();
    }

    public void realizaAtendimento(Paciente paciente) {
        Atendimento atendimento = new Atendimento(paciente, this);
        paciente.setHoraAtendimento(java.time.LocalDateTime.now());
        paciente.setAtendido(true);
        historico.add(atendimento);
        System.out.println("Atendimento realizado pelo médico " + nome + " ao paciente " + paciente.getNome());
    }

    public void registrarAtendimento(Paciente paciente) {
        Atendimento atendimento = new Atendimento(paciente, this);
        historico.add(atendimento);
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public List<Atendimento> getHistorico() {
        return historico;
    }
}
