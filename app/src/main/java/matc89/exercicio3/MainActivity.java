package matc89.exercicio3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        listAdapter = new ArrayAdapter<Tarefa>(
                this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1,
                tarefas
        );
        listView.setAdapter(listAdapter);

        buttonAdicionar = (Button)findViewById(R.id.buttonAdicionar);
        buttonRemover = (Button)findViewById(R.id.buttonRemover);
        editTextDescricao = (EditText)findViewById(R.id.editDescricao);
        editTextPrioridade = (EditText) findViewById(R.id.editPrioridade);
    }

    @Override
    public void onClick(View view) {
        int id  = view.getId();
        switch (id){
            case R.id.buttonRemover :
                Toast.makeText(this,"remover.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonAdicionar :
                Toast.makeText(this,"adicionar.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

