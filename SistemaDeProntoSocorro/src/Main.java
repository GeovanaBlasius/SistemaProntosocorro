import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaAtendimento sistema = new SistemaAtendimento();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE ATENDIMENTO MÉDICO ===");
            System.out.println("1 - Inserir novo paciente na fila");
            System.out.println("2 - Mostrar fila de pacientes");
            System.out.println("3 - Mostrar médicos disponíveis");
            System.out.println("4 - Simular atendimento");
            System.out.println("5 - Mostrar histórico geral");
            System.out.println("0 - Encerrar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    // Validação do Nome
                    String nome;
                    while (true) {
                        System.out.print("Nome do paciente: ");
                        nome = sc.nextLine();
                        if (nome.isEmpty()) {
                            System.out.println("⚠️ Nome não pode estar vazio!");
                        } else if (nome.length() < 2) {
                            System.out.println("⚠️ Nome deve ter pelo menos 2 caracteres!");
                        } else if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+")) {
                            System.out.println("⚠️ Nome deve conter apenas letras e espaços!");
                        } else {
                            break;
                        }
                    }

                    // Validação do CPF
                    String cpf;
                    while (true) {
                        System.out.print("CPF do paciente (000.000.000-00): ");
                        cpf = sc.nextLine().trim().replaceAll("[^0-9]", "");

                        if (cpf == sc.nextLine().trim().replaceAll("[^A-Z]", ""));{
                            System.out.println("️ ⚠️ CPF só pode conter Números!");
                        }

                        if (cpf.isEmpty()) {
                            System.out.println("⚠️ CPF não pode estar vazio!");
                        } else if (cpf.length() != 11) {
                            System.out.println("⚠️ CPF deve ter 11 dígitos!");
                        } else {
                            break;
                        }
                    }

                    Paciente paciente = new Paciente(nome, cpf);
                    String prioridade = Triagem.classificar(paciente);
                    paciente.setPrioridade(prioridade);

                    sistema.adicionarPaciente(paciente);
                    System.out.println("✅ Paciente inserido na fila com sucesso!");
                }
                case 2 -> sistema.mostrarFila();
                case 3 -> sistema.mostrarMedicos();
                case 4 -> sistema.simularAtendimento();
                case 5 -> sistema.mostrarHistorico();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("⚠️ Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
