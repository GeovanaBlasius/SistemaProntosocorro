import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FilaAtendimento {
    private Queue<Paciente> fila;

    public FilaAtendimento() {
        fila = new LinkedList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        fila.add(paciente);
        System.out.println("Paciente " + paciente.getNome() + " adicionado à fila.");
    }

    public Paciente chamarProximo() {
        Paciente proximo = fila.poll();
        if (proximo != null) {
            System.out.println("Chamando paciente: " + proximo.getNome());
        } else {
            System.out.println("Nenhum paciente na fila.");
        }
        return proximo;
    }

    public void mostrarFila() {
        System.out.println("\n--- Fila de Atendimento ---");
        if (fila.isEmpty()) {
            System.out.println("Fila vazia.");
        } else {
            for (Paciente p : fila) {
                System.out.println(p.getNome() + " - Classificação: " + p.getClassificacao());
            }
        }
    }
}
