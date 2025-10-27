import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Paciente extends Pessoa {
    private String prioridade;
    private LocalDateTime horaChegada;
    private LocalDateTime horaAtendimento;
    private String medicoResponsavel;

    public Paciente(String nome, String CPF) {
        super(nome, CPF);
        this.horaChegada = LocalDateTime.now();
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade.toUpperCase();
    }

    // Essencial para a ordenação na FilaAtendimento
    public LocalDateTime getHoraChegada() {
        return horaChegada;
    }

    public void registrarAtendimento(String medico) {
        this.medicoResponsavel = medico;
        this.horaAtendimento = LocalDateTime.now();
    }

    public String getHoraAtendimentoFormatada() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        return horaAtendimento != null ? horaAtendimento.format(fmt) : "N/A";
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(getNome())
                .append(" | Prioridade: ").append(prioridade)
                .append(" | Chegada: ").append(horaChegada.format(fmt));

        if (horaAtendimento != null) {
            sb.append(" | Atendido por: ").append(medicoResponsavel)
                    .append(" às ").append(horaAtendimento.format(fmt));
        }
        return sb.toString();
    }
}