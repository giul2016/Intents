package paulacr.net.intents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by paularosa on 1/21/16.
 */
public class AdapterRoupaItem extends BaseAdapter{

    private Context context;
    private List<Item> itens;

    public AdapterRoupaItem(Context context, List<Item> itens) {
        this.context = context;
        this.itens = itens;
    }

    public static class ViewHolder {
        private ImageView icon;
        private TextView title;
        private TextView tag;

    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lista_item, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
            viewHolder.title = (TextView) convertView.findViewById(R.id.titulo);
            viewHolder.tag = (TextView) convertView.findViewById(R.id.tag);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Item item = (Item) getItem(position);

        viewHolder.icon.setImageResource(item.getIcon());
        viewHolder.title.setText(item.getTitle());
        viewHolder.tag.setText(item.getTag());
        viewHolder.tag.setTextColor(item.getColor());

        return convertView;
    }
}
