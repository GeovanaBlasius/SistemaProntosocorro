import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilaAtendimento fila = new FilaAtendimento();
        Triagem triagem = new Triagem();

        // ====== Carregamento automático de dados ======
        List<Paciente> pacientesIniciais = DadosExemplo.carregarPacientes();
        List<Medico> medicosIniciais = DadosExemplo.carregarMedicos();
        Medico medico = medicosIniciais.get(0);

        for (Paciente p : pacientesIniciais) {
            fila.adicionarPaciente(p, false); // não mostra mensagem
        }

        // ====== Mensagem de inicialização ======
        System.out.println("\n========================================");
        System.out.println("🩺  SISTEMA DE ATENDIMENTO MÉDICO INICIADO");
        System.out.println("========================================");
        System.out.println("✅ " + pacientesIniciais.size() + " pacientes carregados");
        System.out.println("✅ " + medicosIniciais.size() + " médicos disponíveis");
        System.out.println("----------------------------------------\n");

        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Inserir novo paciente na fila");
            System.out.println("2 - Mostrar fila de pacientes");
            System.out.println("3 - Chamar próximo paciente");
            System.out.println("4 - Mostrar histórico de atendimentos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    // ======= Cadastro manual de paciente =======
                    String nome;
                        while (true) {
                            System.out.print("Nome completo do paciente: ");
                            nome = sc.nextLine().trim();

                            if (nome.isEmpty()) {
                                System.out.println("⚠️ Nome não pode estar vazio!");
                            }
                            else if (nome.length() < 5) {
                                System.out.println("⚠️ Nome deve ter pelo menos 5 caracteres!");
                            }
                            else if (!nome.matches("^[a-zA-ZÀ-ÿ]+(\\s+[a-zA-ZÀ-ÿ]+)+$")) {
                                System.out.println("⚠️ Informe o nome completo (ex: João da Silva).");
                            }
                            else {
                                break;
                            }
                        }

                    // ======= Validação do CPF =======
                    String cpf;
                    while (true) {
                        System.out.print("CPF do paciente (000.000.000-00): ");
                        String entrada = sc.nextLine().trim();

                        if (entrada.isEmpty()) {
                            System.out.println("⚠️ CPF não pode estar vazio!");
                            continue;
                        }

                        if (!entrada.matches("[0-9.\\-]+")) {
                            System.out.println("⚠️ CPF deve conter apenas números e caracteres válidos (ponto e traço)!");
                            continue;
                        }

                        cpf = entrada.replaceAll("[^0-9]", ""); // remove pontos e traços para padronizar

                        if (cpf.length() != 11) {
                            System.out.println("⚠️ CPF deve conter exatamente 11 dígitos!");
                            continue;
                        }

                        if (cpf.matches("(\\d)\\1{10}")) {
                            System.out.println("⚠️ CPF inválido! Todos os dígitos são iguais.");
                            continue;
                        }

                        break; // CPF válido
                    }


                    Paciente p = new Paciente(nome, cpf);
                    String classificacao = triagem.classificar(p);
                    p.setClassificacao(classificacao);
                    fila.adicionarPaciente(p, true); // ← exibe mensagem de confirmação
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

                case 0 -> System.out.println("\n👋 Encerrando o sistema... Até logo!");

                default -> System.out.println("⚠️ Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        sc.close();
    }
}
