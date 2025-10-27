import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa {
    private final List<Atendimento> historico = new ArrayList<>();

    public Medico(String nome, String CPF) {
        super(nome, CPF);
    }

    public void registrarAtendimento(Atendimento atendimento) {
        if (atendimento == null) {
            throw new IllegalArgumentException("Atendimento não pode ser nulo.");
        }
        historico.add(atendimento);
    }

    public List<Atendimento> getHistorico() {
        return new ArrayList<>(historico);
    }
}
