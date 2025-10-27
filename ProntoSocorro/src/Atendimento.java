import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Atendimento {
    private final Paciente paciente;
    private final Medico medico;
    private final LocalDateTime horarioAtendimento;

    public Atendimento(Paciente paciente, Medico medico) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente não pode ser nulo.");
        }
        if (medico == null) {
            throw new IllegalArgumentException("Médico não pode ser nulo.");
        }
        this.paciente = paciente;
        this.medico = medico;
        this.horarioAtendimento = LocalDateTime.now();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getHorarioAtendimento() {
        return horarioAtendimento;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Atendimento de " + paciente.getNome() + " por " + medico.getNome()
                + " em " + horarioAtendimento.format(fmt);
    }
}
