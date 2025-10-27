public abstract class Pessoa {
    private String nome;
    private String CPF;

    public Pessoa(String nome, String CPF) {
        // Usa setters que contêm a lógica de validação
        setNome(nome);
        setCPF(CPF);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("⚠️ Nome não pode estar vazio.");
        }

        // Verifica (nome e sobrenome)
        String[] partes = nome.trim().split("\\s+");
        if (partes.length < 2) {
            throw new IllegalArgumentException("⚠️ Informe o nome completo (nome e sobrenome).");
        }

        //  nome contém apenas letras e espaços
        if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
            throw new IllegalArgumentException("⚠️ Nome deve conter apenas letras e espaços.");
        }

        // Verifica se há pelo menos 6 letras úteis (ignorando espaços)
        String apenasLetras = nome.replaceAll("[^a-zA-ZÀ-ÿ]", "");
        if (apenasLetras.length() < 6) {
            throw new IllegalArgumentException("⚠️ Nome completo deve ter pelo menos 6 letras.");
        }

        this.nome = formatarNome(nome);
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        // Remove qualquer formatação antes de validar
        String apenasNumeros = CPF.replaceAll("[^0-9]", "");

        if (!apenasNumeros.matches("\\d{11}")) {
            throw new IllegalArgumentException("⚠️ CPF inválido: deve conter 11 dígitos numéricos.");
        }

        this.CPF = formatarCPF(apenasNumeros);
    }

    private String formatarNome(String nome) {
        String[] partes = nome.trim().toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String parte : partes) {
            if (!parte.isEmpty()) {
                nomeFormatado.append(Character.toUpperCase(parte.charAt(0)))
                        .append(parte.substring(1))
                        .append(" ");
            }
        }
        return nomeFormatado.toString().trim();
    }

    private String formatarCPF(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}