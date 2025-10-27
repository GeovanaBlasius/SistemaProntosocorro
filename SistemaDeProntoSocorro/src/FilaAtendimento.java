import java.util.*;

public class FilaAtendimento {
    private List<Paciente> fila;
    private static final Map<String, Integer> PRIORIDADE_ORDEM = Map.of(
            "Vermelho", 1,
            "Amarelo", 2,
            "Verde", 3,
            "Azul", 4
    );

    public FilaAtendimento() {
        fila = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        fila.add(paciente);
        fila.sort(Comparator.comparing(p -> PRIORIDADE_ORDEM.get(p.getPrioridade())));
        System.out.println("Paciente " + paciente.getNome() + " adicionado à fila (" + paciente.getPrioridade() + ")");
    }

    public Paciente chamarProximo() {
        if (fila.isEmpty()) return null;
        return fila.remove(0);
    }

    public void mostrarFila() {
        System.out.println("\n--- Fila de Pacientes ---");
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
}
