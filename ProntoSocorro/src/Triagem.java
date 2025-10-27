public class Triagem {
    private int id;
    private String classificacao;

    public Triagem(int id) {
        this.id = id;
    }

    public String classificar(Paciente paciente) {
        // Exemplo simples de classificação (pode ser expandido)
        double random = Math.random();
        if (random < 0.25) classificacao = "Vermelho - Emergência";
        else if (random < 0.5) classificacao = "Amarelo - Urgente";
        else if (random < 0.75) classificacao = "Verde - Pouco Urgente";
        else classificacao = "Azul - Não Urgente";

        paciente.setClassificacao(classificacao);
        return classificacao;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getClassificacao() {
        return classificacao;
    }
}
