package unicauca.movil.clienthttp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import unicauca.movil.clienthttp.R;
import unicauca.movil.clienthttp.models.Pelicula;

/**
 * Created by darfe on 28/04/2017.
 */

public class PeliculaAdapter extends BaseAdapter{

    LayoutInflater inflater;
    List<Pelicula> data;

    public PeliculaAdapter(LayoutInflater inflater, List<Pelicula> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null)
            v = inflater.inflate(R.layout.template_pelicula, parent, false);

        Pelicula p = data.get(position);

        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        TextView genero = (TextView) v.findViewById(R.id.genero);
        TextView sinopsis = (TextView) v.findViewById(R.id.sinopsis);

        nombre.setText(p.getNombre());
        genero.setText(p.getGenero());
        sinopsis.setText(p.getSinopsis());

        return v;
    }

    public void setData(List<Pelicula> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
