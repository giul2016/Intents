package paulacr.net.intents;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listaItens);
        AdapterRoupaItem adapter = new AdapterRoupaItem(this, getItens());
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(this);
    }

    private List<Item> getItens() {

        List<Item> items = new ArrayList<>();

        items.add(new Item(R.drawable.blazer, "Blazer", "Casacos", Color.BLACK));
        items.add(new Item(R.drawable.blusa, "Camisa Social","Social", Color.BLUE));
        items.add(new Item(R.drawable.blusa_curta, "Blusa manga curta", "Casual", Color.CYAN));
        items.add(new Item(R.drawable.blusa_2, "Blusinha", "Casual", Color.DKGRAY));
        items.add(new Item(R.drawable.sapato_2, "Sapato festa", "Sapatos", Color.GREEN));
        items.add(new Item(R.drawable.casaco, "Casaco de frio","Casacos", Color.MAGENTA));
        items.add(new Item(R.drawable.chapeu, "Chapéu", "Acessórios", Color.YELLOW));
        items.add(new Item(R.drawable.sapato, "Sapato festa", "Sapatos", Color.RED));
        items.add(new Item(R.drawable.vestido, "Vestido", "Social", Color.BLUE));

        return items;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Acessar o item relacionado a posiçao clicada
        Item item = (Item) parent.getItemAtPosition(position);
        String titulo = item.getTitle();

        Intent intent = new Intent(this, ItemDetalheActivity.class);

        intent.putExtra("itemSelecionadoTitulo", titulo);
        intent.putExtra("itemSelecionadoPosition", position);

        intent.putExtra("itemSelecionado", item);

        Log.i("log debug", "item-->" + item.getIcon());

        startActivity(intent);
    }

}
