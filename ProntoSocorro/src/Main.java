import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilaAtendimento fila = new FilaAtendimento();
        Triagem triagem = new Triagem(1);
        Medico medico = new Medico(1, "Dr. João", "123.456.789-00");

        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE ATENDIMENTO MÉDICO ===");
            System.out.println("1 - Inserir novo paciente na fila");
            System.out.println("2 - Mostrar fila de pacientes");
            System.out.println("3 - Chamar próximo paciente");
            System.out.println("4 - Mostrar histórico de atendimentos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do paciente: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF do paciente: ");
                    String cpf = sc.nextLine();

                    Paciente p = new Paciente((int) (Math.random() * 1000), nome, cpf);
                    String classificacao = triagem.classificar(p);
                    System.out.println("Classificação do paciente: " + classificacao);
                    fila.adicionarPaciente(p);
                }

                case 2 -> fila.mostrarFila();

                case 3 -> {
                    Paciente proximo = fila.chamarProximo();
                    if (proximo != null) {
                        medico.realizaAtendimento(proximo);
                    }
                }

                case 4 -> {
                    System.out.println("\n--- Histórico de Atendimentos ---");
                    for (Atendimento a : medico.getHistorico()) {
                        System.out.println("Paciente: " + a.getPaciente().getNome() +
                                " | Médico: " + a.getMedico().getNome() +
                                " | Hora: " + a.getHoraAtendimento());
                    }
                }

                case 0 -> System.out.println("Encerrando o sistema...");

                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
