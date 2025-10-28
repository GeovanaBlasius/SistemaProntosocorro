import java.util.Scanner;

public class Triagem {
    private String classificacao;

    public static String classificar(Paciente paciente) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== TRIAGEM - " + paciente.getNome() + " ===");

        int pontuacao = 0;

        System.out.println("1. Tem dor muito forte?");
        System.out.println("   [1] Sim || [2] Não ");
        System.out.print("Resposta: ");
        if (sc.nextLine().equals("1")) pontuacao += 1;

        System.out.println("\n2. Está sangrando muito?");
        System.out.println("   [1] Sim || [2] Não ");
        System.out.print("Resposta: ");
        if (sc.nextLine().equals("1")) pontuacao += 2;

        System.out.println("\n3. Está com febre alta?");
        System.out.println("   [1] Sim || [2] Não ");
        System.out.print("Resposta: ");
        if (sc.nextLine().equals("1")) pontuacao += 1;

        System.out.println("\n4. Está com falta de ar?");
        System.out.println("   [1] Sim || [2] Não ");
        System.out.print("Resposta: ");
        if (sc.nextLine().equals("1")) pontuacao += 2;

        String prioridade;
        if (pontuacao >= 4) {
            prioridade = "VERMELHO";    // Gravíssima
        } else if (pontuacao >= 2) {
            prioridade = "AMARELO";     // Grave
        } else if (pontuacao == 1) {
            prioridade = "VERDE";       // Leve
        } else {
            prioridade = "AZUL";        // Muito leve
        }

        System.out.println("\n✅ Prioridade: " + prioridade + " (" + pontuacao + "/4 pontos)");
        return prioridade;
    }

    public String getClassificacao() {
        return classificacao;
    }
}
