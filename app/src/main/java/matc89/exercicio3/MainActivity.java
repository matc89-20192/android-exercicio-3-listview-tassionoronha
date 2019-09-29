package matc89.exercicio3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayAdapter<Tarefa> listAdapter;
    private List<Tarefa> tarefas = new ArrayList<Tarefa>();
    private Button buttonRemover;
    private Button buttonAdicionar;
    private EditText editTextDescricao;
    private EditText editTextPrioridade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView)findViewById(R.id.listView);
        listAdapter = new TarefaAdapter(
                this,
                tarefas
        );
        listView.setAdapter(listAdapter);

        buttonAdicionar = (Button)findViewById(R.id.buttonAdicionar);
        buttonRemover = (Button)findViewById(R.id.buttonRemover);
        editTextDescricao = (EditText)findViewById(R.id.editDescricao);
        editTextPrioridade = (EditText) findViewById(R.id.editPrioridade);
        this.setListeners();
        this.checkRemoveState();
    }

    public void setListeners(){
        buttonAdicionar.setOnClickListener(this);
        buttonRemover.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    public void checkRemoveState(){
        if(tarefas.isEmpty()){
            buttonRemover.setEnabled(false);
        }else{
            buttonRemover.setEnabled(true);
        }
    }

    public boolean checkDescription(Tarefa tarefa){
        for (Tarefa taskAux : tarefas){
            if(taskAux.getDescricao().equalsIgnoreCase(tarefa.getDescricao())){
                Toast.makeText(this,"Tarefa já cadastrada.", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        return true;
    }

    public boolean checkPriority(Tarefa tarefa){
        if (tarefa.getPrioridade() > 10 || tarefa.getPrioridade() < 1){
            Toast.makeText(this,"A prioridade deve estar entre 1 e 10.",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void cleanInput(){
        editTextDescricao.setText("");
        editTextPrioridade.setText("");
        editTextDescricao.requestFocus();
    }

    @Override
    public void onClick(View view) {
        int id  = view.getId();
        switch (id){
            case R.id.buttonRemover :
                tarefas.remove(0);
                listAdapter.notifyDataSetChanged();
                break;
            case R.id.buttonAdicionar :
                Tarefa tarefa = new Tarefa(
                        this.editTextDescricao.getText().toString(),
                        Integer.parseInt(this.editTextPrioridade.getText().toString())
                );
                if(this.checkDescription(tarefa) && this.checkPriority(tarefa)){
                    tarefas.add(tarefa);
                    Collections.sort(tarefas);
                    cleanInput();
                    listAdapter.notifyDataSetChanged();
                }
                break;
        }
        checkRemoveState();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        tarefas.remove(position);
        listAdapter.notifyDataSetChanged();
        checkRemoveState();
    }
}

