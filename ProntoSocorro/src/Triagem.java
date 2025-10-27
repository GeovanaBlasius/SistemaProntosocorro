public class Triagem {
    public static void classificarPaciente(Paciente paciente, int respostasCriticas) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente inválido para triagem.");
        }

        ClassificacaoRisco classificacao;
        if (respostasCriticas >= 3) {
            classificacao = new ClassificacaoRisco("Vermelho", 1, "Emergência - Atender imediatamente");
        } else if (respostasCriticas == 2) {
            classificacao = new ClassificacaoRisco("Laranja", 2, "Muito urgente - até 10 minutos");
        } else if (respostasCriticas == 1) {
            classificacao = new ClassificacaoRisco("Amarelo", 3, "Urgente - até 30 minutos");
        } else {
            classificacao = new ClassificacaoRisco("Verde", 4, "Pouco urgente - pode esperar");
        }

        paciente.setClassificacao(classificacao);
    }
}
