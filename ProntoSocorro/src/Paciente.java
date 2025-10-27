public class Paciente extends Pessoa {
    private ClassificacaoRisco classificacao;
    private final long horarioChegada;

    public Paciente(String nome, String CPF) {
        super(nome, CPF);
        this.horarioChegada = System.currentTimeMillis();
    }

    public ClassificacaoRisco getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoRisco classificacao) {
        if (classificacao == null) {
            throw new IllegalArgumentException("Classificação de risco não pode ser nula.");
        }
        this.classificacao = classificacao;
    }

    public long getHorarioChegada() {
        return horarioChegada;
    }

    @Override
    public String toString() {
        String risco = (classificacao != null) ? classificacao.getCor() : "Sem classificação";
        return super.toString() + " - Risco: " + risco;
    }
}
