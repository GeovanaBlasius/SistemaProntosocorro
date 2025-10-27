import java.time.LocalDateTime;

public class Atendimento {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime horaAtendimento;

    public Atendimento(Paciente paciente, Medico medico) {
        this.paciente = paciente;
        this.medico = medico;
        this.horaAtendimento = LocalDateTime.now();
    }

    // Getters e Setters
    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getHoraAtendimento() {
        return horaAtendimento;
    }
}
