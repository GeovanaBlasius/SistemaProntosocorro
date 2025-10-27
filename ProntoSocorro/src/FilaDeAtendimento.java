import java.util.*;

public class FilaAtendimento {
    private final PriorityQueue<Paciente> fila = new PriorityQueue<>(
            Comparator.comparingInt(p -> p.getClassificacao().getPrioridade())
    );

    public void adicionarPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente inválido.");
        }
        if (paciente.getClassificacao() == null) {
            throw new IllegalArgumentException("Paciente precisa ser classificado antes de entrar na fila.");
        }
        fila.add(paciente);
    }

    public Paciente proximoPaciente() {
        return fila.poll();
    }

    public boolean isVazia() {
        return fila.isEmpty();
    }

    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia.");
        } else {
            System.out.println("📋 Fila de Atendimento:");
            fila.forEach(p -> System.out.println(" - " + p));
        }
    }
}
