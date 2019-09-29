package matc89.exercicio3;
import android.support.annotation.NonNull;

public class Tarefa implements Comparable<Tarefa>{
    private String descricao;
    private int prioridade;

    public Tarefa(String descricao, int prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    @Override
    public int compareTo(@NonNull Tarefa outraTarefa) {
        if(prioridade > outraTarefa.prioridade){
            return 1;
        }

        if (prioridade < outraTarefa.prioridade) {
            return -1;
        }
        return 0;
    }
}
