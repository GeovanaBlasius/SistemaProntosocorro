public enum ClassificacaoRisco {
    VERMELHO(1, "Emergência"),
    AMARELO(2, "Urgente"),
    VERDE(3, "Pouco urgente"),
    AZUL(4, "Não urgente");

    private final int prioridade;
    private final String descricao;

    ClassificacaoRisco(int prioridade, String descricao) {
        this.prioridade = prioridade;
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public String toString() {
        return name() + " - " + descricao;
    }
}
