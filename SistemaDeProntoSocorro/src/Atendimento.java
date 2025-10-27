import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Atendimento {
    private List<Medico> medicos;
    private FilaAtendimento fila;
    private List<Paciente> historico;

    public Atendimento() {
        medicos = new ArrayList<>();
        fila = new FilaAtendimento();
        historico = new ArrayList<>();
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais() {
        // Médicos
        adicionarMedico(new Medico("Dr Carlos Silva", "11122233344", "Clínico Geral"));
        adicionarMedico(new Medico("Dra Ana Santos", "22233344455", "Pediatra"));
        adicionarMedico(new Medico("Dr Paulo Oliveira", "33344455566", "Cirurgião"));

        carregarPacientesExemplo();
    }

    // Requisito: 20 pacientes na inicialização
    private void carregarPacientesExemplo() {
        String[][] pacientes = {
                {"João Silva", "11111111111", "VERMELHO"}, {"Maria Oliveira", "22222222222", "AMARELO"},
                {"Pedro Santos", "33333333333", "AZUL"}, {"Ana Costa", "44444444444", "VERDE"},
                {"Carlos Lima", "55555555555", "VERMELHO"}, {"Juliana Pereira", "66666666666", "VERDE"},
                {"Roberto Alves", "77777777777", "AMARELO"}, {"Fernanda Souza", "88888888888", "AZUL"},
                {"Lucas Martins", "99999999999", "VERMELHO"}, {"Patrícia Rocha", "10110110110", "VERDE"},
                {"Ricardo Ferreira", "20220220220", "VERDE"}, {"Amanda Dias", "30330330330", "AZUL"},
                {"Bruno Cardoso", "40440440440", "AMARELO"}, {"Cristina Nunes", "50550550550", "VERDE"},
                {"Daniel Mendes", "60660660660", "VERMELHO"}, {"Elaine Torres", "70770770770", "AZUL"},
                {"Fábio Ramos", "80880880880", "VERMELHO"}, {"Gabriela Lopes", "90990990990", "VERDE"},
                {"Hugo Barbosa", "01001001001", "AZUL"}, {"Isabela Castro", "02002002002", "VERMELHO"}
        };

        for (String[] dados : pacientes) {
            try {
                Paciente paciente = new Paciente(dados[0], dados[1]);
                paciente.setPrioridade(dados[2]);
                fila.adicionarPaciente(paciente);
            } catch (IllegalArgumentException e) {
                // Captura erros de validação da Pessoa/CPF/Nome nos dados de exemplo
            }
        }
        System.out.println("\n✅ Sistema iniciado com 3 médicos e 20 pacientes na fila.");
    }

    public void adicionarMedico(Medico m) {
        medicos.add(m);
    }

    public void adicionarPaciente(Paciente paciente) {
        fila.adicionarPaciente(paciente);
    }

    public void mostrarFila() {
        System.out.println("\n--- FILA ÚNICA (Ordenada por Prioridade) ---");
        fila.mostrarFila();
    }

    public void simularAtendimento() {
        if (fila.isVazia()) {
            System.out.println("\n--- Nenhum paciente aguardando atendimento! ---");
            return;
        }
        if (medicos.isEmpty()) {
            System.out.println("\n--- Nenhum médico disponível para atender! ---");
            return;
        }

        Paciente proximo = fila.chamarProximo();

        // Seleciona um médico aleatoriamente
        Medico medico = medicos.get((int) (Math.random() * medicos.size()));

        medico.atenderPaciente(proximo);
        historico.add(proximo);

        System.out.println("\n✅ ATENDIMENTO INICIADO:");
        System.out.println("   Paciente: " + proximo.getNome() + " (" + proximo.getPrioridade() + ")");
        System.out.println("   Atendido por: " + medico.getNome());
    }

    // Requisito: Histórico de atendidos e aguardando
    public void mostrarHistorico() {
        System.out.println("\n====================== HISTÓRICO GERAL ======================");

        System.out.println("\n--- PACIENTES ATENDIDOS (" + historico.size() + ") ---");
        if (historico.isEmpty()) {
            System.out.println("Nenhum paciente foi atendido ainda.");
        } else {
            for (Paciente p : historico) {
                System.out.println(" - " + p);
            }
        }

        System.out.println("\n--- PACIENTES AGUARDANDO NA FILA (" + fila.getTamanho() + ") ---");
        fila.mostrarFila();

        System.out.println("===============================================================");
    }
}