public class Medico extends Pessoa {
    private String especialidade;

    public Medico(String nome, String CPF, String especialidade) {
        super(nome, CPF);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void atenderPaciente(Paciente paciente) {
        paciente.registrarAtendimento(this.getNome());
    }

    @Override
    public String toString() {
        return "Médico: " + getNome() + " | Especialidade: " + especialidade;
    }
}