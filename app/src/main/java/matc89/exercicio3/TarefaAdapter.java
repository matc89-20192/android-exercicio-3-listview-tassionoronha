package matc89.exercicio3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TarefaAdapter extends ArrayAdapter<Tarefa> {
    public TarefaAdapter(Context context, List<Tarefa> tarefas){
        super(context, 0, tarefas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = null;

        Tarefa tarefa = getItem(position);
        if (tarefa != null){
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(android.R.layout.simple_list_item_2, null);
            TextView text1 = (TextView)view.findViewById(android.R.id.text1);
            TextView text2 = (TextView)view.findViewById(android.R.id.text2);
            text1.setText(tarefa.getDescricao());
            text2.setText("Prioridade: " + tarefa.getPrioridade());
        }

        return view;
    }

}
