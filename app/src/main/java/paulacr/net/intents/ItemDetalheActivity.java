package paulacr.net.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by paularosa on 1/21/16.
 */
public class ItemDetalheActivity extends AppCompatActivity {

    private static final String TAG = "Item Detalhe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe_item_layout);

        Intent intent = getIntent();
        Item item = intent.getParcelableExtra("itemSelecionado");

        ImageView imagem = (ImageView) findViewById(R.id.imagem);
        TextView titulo = (TextView) findViewById(R.id.titulo);

        if(intent.hasExtra("itemSelecionado")) {
            imagem.setImageResource(item.getIcon());
            titulo.setText(item.getTitle());
        }
    }

}
