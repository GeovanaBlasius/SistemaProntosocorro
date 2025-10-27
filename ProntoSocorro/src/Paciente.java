import java.time.LocalDateTime;

public class Paciente extends Pessoa {
    private int id;
    private String classificacao;
    private LocalDateTime horaChegada;
    private LocalDateTime horaAtendimento;
    private boolean atendido;

    public Paciente(int id, String nome, String CPF) {
        super(nome, CPF);
        this.id = id;
        this.horaChegada = LocalDateTime.now();
        this.atendido = false;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public LocalDateTime getHoraChegada() {
        return horaChegada;
    }

    public LocalDateTime getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(LocalDateTime horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }
}
