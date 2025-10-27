public class Main {
    public static void main(String[] args) {
        Medico medico = new Medico("Dra. Ana Souza", "123.456.789-00");
        FilaAtendimento fila = new FilaAtendimento();

        // Pacientes simulados
        String[][] dados = {
                {"João", "111.111.111-11", "2"},
                {"Maria", "222.222.222-22", "3"},
                {"Carlos", "333.333.333-33", "1"},
                {"Fernanda", "444.444.444-44", "0"},
                {"Rita", "555.555.555-55", "2"}
        };

        for (String[] d : dados) {
            Paciente p = new Paciente(d[0], d[1]);
            int criticas = Integer.parseInt(d[2]);
            Triagem.classificarPaciente(p, criticas);
            fila.adicionarPaciente(p);
        }

        // Mostra fila inicial
        fila.exibirFila();

        // Atendimentos simulados
        while (!fila.isVazia()) {
            Paciente proximo = fila.proximoPaciente();
            Atendimento atendimento = new Atendimento(proximo, medico);
            medico.registrarAtendimento(atendimento);
            System.out.println("\n✅ " + atendimento);
        }

        // Exibe histórico
        System.out.println("\n📚 Histórico de atendimentos:");
        medico.getHistorico().forEach(System.out::println);
    }
}
