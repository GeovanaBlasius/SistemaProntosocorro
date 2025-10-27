import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Atendimento sistema = new Atendimento();

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE ATENDIMENTO MÉDICO ===");
            System.out.println("1 - Inserir novo paciente na fila (Triagem)");
            System.out.println("2 - Mostrar fila de pacientes");
            System.out.println("3 - Simular atendimento");
            System.out.println("4 - Mostrar histórico geral");
            System.out.println("0 - Encerrar");
            System.out.print("Escolha uma opção: ");

            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("⚠️ Entrada inválida! Digite um número.");
                sc.nextLine();
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1 -> {
                    String nome;
                    String cpf;

                    while (true) {
                        try {
                            System.out.print("Nome Completo do paciente: ");
                            nome = sc.nextLine();

                            System.out.print("CPF do paciente (11 dígitos): ");
                            cpf = sc.nextLine();

                            Paciente paciente = new Paciente(nome, cpf);

                            String prioridade = Triagem.classificar(paciente);
                            paciente.setPrioridade(prioridade);

                            sistema.adicionarPaciente(paciente);
                            break;

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }

                case 2 -> sistema.mostrarFila();
                case 3 -> sistema.simularAtendimento();
                case 4 -> sistema.mostrarHistorico();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("⚠️ Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();
    }
}