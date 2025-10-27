import java.util.Scanner;

public class Triagem {

    public static String classificar(Paciente paciente) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== TRIAGEM - " + paciente.getNome() + " ===");

        int pontuacao = 0;

        System.out.print("1. O paciente está com falta de ar ou dor no peito intensa (s/n)? ");
        if (lerResposta(sc).equalsIgnoreCase("s")) pontuacao += 4;

        System.out.print("2. O paciente está com sangramento descontrolado ou confusão mental (s/n)? ");
        if (lerResposta(sc).equalsIgnoreCase("s")) pontuacao += 3;

        System.out.print("3. O paciente está com dor moderada/febre alta, mas está estável (s/n)? ");
        if (lerResposta(sc).equalsIgnoreCase("s")) pontuacao += 1;

        System.out.print("4. O paciente tem queixas leves (resfriado, dor de cabeça leve, etc.) (s/n)? ");
        if (lerResposta(sc).equalsIgnoreCase("s")) pontuacao -= 2;

        String prioridade;

        if (pontuacao >= 4) {
            prioridade = "VERMELHO";
        } else if (pontuacao >= 3) {
            prioridade = "AMARELO";
        } else if (pontuacao >= 1) {
            prioridade = "VERDE";
        } else {
            prioridade = "AZUL";
        }

        System.out.println("\n✅ Classificação: " + prioridade + " (Pontuação: " + pontuacao + ")");
        return prioridade;
    }

    private static String lerResposta(Scanner sc) {
        String entrada;
        while (true) {
            entrada = sc.nextLine().trim().toLowerCase();
            if (entrada.equals("s") || entrada.equals("n")) {
                return entrada;
            } else {
                System.out.print("⚠️ Resposta inválida! Digite 's' para Sim ou 'n' para Não: ");
            }
        }
    }
}