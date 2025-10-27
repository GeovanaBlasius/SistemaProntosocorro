public class Medico extends Pessoa {
    private String especialidade;

    public Medico(String nome, String CPF, String especialidade) {
        super(nome, CPF);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void atenderPaciente(Paciente paciente) {
        paciente.registrarAtendimento(this.getNome());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Médico: ").append(getNome())
                .append(" | CPF: ").append(getCPF())
                .append(" | Especialidade: ").append(especialidade);
        return sb.toString();
    }
}
