package unicauca.movil.clienthttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import unicauca.movil.clienthttp.models.Pelicula;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, calificacion, sinopsis, duracion;
    Spinner genero;

    String[] generos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nombre = (EditText) findViewById(R.id.nombre);
        calificacion = (EditText) findViewById(R.id.calificacion);
        sinopsis = (EditText) findViewById(R.id.sinopsis);
        duracion = (EditText) findViewById(R.id.duracion);
        genero = (Spinner) findViewById(R.id.genero);

        generos = getResources().getStringArray(R.array.genero);

        Button add = (Button) findViewById(R.id.btnAdd);
        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Pelicula pelicula = new Pelicula();

        String nom = nombre.getText().toString();
        int cal = Integer.parseInt(calificacion.getText().toString());
        String sin = sinopsis.getText().toString();
        int dur = Integer.parseInt(duracion.getText().toString());
        String gen = generos[genero.getSelectedItemPosition()];

        pelicula.setNombre(nom);
        pelicula.setCalificacion(cal);
        pelicula.setDuracion(dur);
        pelicula.setSinopsis(sin);
        pelicula.setGenero(gen);

    }
}
