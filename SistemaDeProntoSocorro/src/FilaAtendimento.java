import java.util.*;
import java.time.LocalDateTime;

public class FilaAtendimento {
    private List<Paciente> fila;

    private static final Map<String, Integer> PRIORIDADE_ORDEM = Map.of(
            "VERMELHO", 1,
            "AMARELO", 2,
            "VERDE", 3,
            "AZUL", 4
    );

    public FilaAtendimento() {
        fila = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        String prioridade = paciente.getPrioridade();

        if (prioridade == null || !PRIORIDADE_ORDEM.containsKey(prioridade)) {
            System.out.println("⚠️ Erro de prioridade: " + prioridade);
            return;
        }

        fila.add(paciente);

        // Ordena por prioridade (cor) e depois por hora de chegada (graças ao método getHoraChegada() na classe Paciente)//
        fila.sort(Comparator
                .comparing((Paciente p) -> PRIORIDADE_ORDEM.get(p.getPrioridade()))
                .thenComparing(Paciente::getHoraChegada));

        System.out.println("✅ Paciente " + paciente.getNome() + " adicionado à fila (" + paciente.getPrioridade() + ")");
    }

    public Paciente chamarProximo() {
        if (fila.isEmpty()) return null;
        return fila.remove(0);
    }

    public void mostrarFila() {
        if (fila.isEmpty()) {
            System.out.println("Nenhum paciente aguardando.");
            return;
        }

        for (int i = 0; i < fila.size(); i++) {
            Paciente p = fila.get(i);
            System.out.println((i + 1) + " - " + p);
        }
    }

    public boolean isVazia() {
        return fila.isEmpty();
    }

    public int getTamanho() {
        return fila.size();
    }
}