public abstract class Pessoa {
    protected String nome;
    protected String CPF;

    public Pessoa(String nome, String CPF) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (CPF == null || CPF.isBlank()) {
            throw new IllegalArgumentException("CPF não pode ser vazio.");
        }
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        if (CPF == null || CPF.isBlank()) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return nome + " (CPF: " + CPF + ")";
    }
}
