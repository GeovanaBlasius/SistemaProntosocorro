import java.util.ArrayList;
import java.util.List;

public class SistemaAtendimento {
    private List<Medico> medicos;
    private FilaAtendimento fila;
    private List<Paciente> historico;

    public SistemaAtendimento() {
        medicos = new ArrayList<>();
        fila = new FilaAtendimento();
        historico = new ArrayList<>();
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais() {
        adicionarMedico(new Medico("Dr. Carlos Silva", "111.222.333-44", "Clínico Geral"));
        adicionarMedico(new Medico("Dra. Ana Santos", "222.333.444-55", "Pediatra"));
        adicionarMedico(new Medico("Dr. Paulo Oliveira", "333.444.555-66", "Cirurgião"));
        carregarPacientesExemplo();
    }

    private void carregarPacientesExemplo() {
        String[][] pacientes = {
                {"João Silva", "111.111.111-11", "Vermelho"},
                {"Maria Oliveira", "222.222.222-22", "Amarelo"},
                {"Pedro Santos", "333.333.333-33", "Azul"},
                {"Ana Costa", "444.444.444-44", "Verde"},
                {"Carlos Lima", "555.555.555-55", "Vermelho"},
                {"Juliana Pereira", "666.666.666-66", "Verde"},
                {"Roberto Alves", "777.777.777-77", "Amarelo"},
                {"Fernanda Souza", "888.888.888-88", "Azul"},
                {"Lucas Martins", "999.999.999-99", "Vermelho"},
                {"Patrícia Rocha", "101.101.101-10", "Verde"},
                {"Ricardo Ferreira", "202.202.202-20", "Verde"},
                {"Amanda Dias", "303.303.303-30", "Azul"},
                {"Bruno Cardoso", "404.404.404-40", "Amarelo"},
                {"Cristina Nunes", "505.505.505-50", "Verde"},
                {"Daniel Mendes", "606.606.606-60", "Vermelho"},
                {"Elaine Torres", "707.707.707-70", "Azul"},
                {"Fábio Ramos", "808.808.808-80", "Vermelho"},
                {"Gabriela Lopes", "909.909.909-90", "Verde"},
                {"Hugo Barbosa", "010.010.010-01", "Azul"},
                {"Isabela Castro", "020.020.020-02", "Vermelho"}
        };

        for (String[] dados : pacientes) {
            Paciente paciente = new Paciente(dados[0], dados[1]);
            paciente.setPrioridade(dados[2]);
            fila.adicionarPaciente(paciente);
        }

        System.out.println("Pacientes de exemplo carregados!");
    }

    public void adicionarMedico(Medico m) {
        medicos.add(m);
    }

    public void adicionarPaciente(Paciente paciente) {
        fila.adicionarPaciente(paciente);
    }

    public void mostrarMedicos() {
        System.out.println("\n--- Médicos disponíveis ---");
        for (Medico m : medicos) {
            System.out.println(" - " + m);
        }
    }

    public void mostrarFila() {
        fila.mostrarFila();
    }

    public void simularAtendimento() {
        if (fila.isVazia()) {
            System.out.println("\n--- Nenhum paciente aguardando atendimento! ---");
            return;
        }

        Paciente proximo = fila.chamarProximo();
        Medico medico = medicos.get((int) (Math.random() * medicos.size()));
        medico.atenderPaciente(proximo);
        historico.add(proximo);

        System.out.println("Paciente " + proximo.getNome() + " atendido por " + medico.getNome());
    }

    public void mostrarHistorico() {
        System.out.println("\n--- Histórico de Pacientes Atendidos ---");
        if (historico.isEmpty()) {
            System.out.println("Nenhum paciente foi atendido ainda.");
            return;
        }

        for (Paciente p : historico) {
            System.out.println(" - " + p);
        }
    }
}
